package views;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
//import uk.ac.gla.terrier.jtreceval.trec_eval;

public class jtreceval {
	
	static String QFile = null;
	static String RFile = null;

	public jtreceval() {
		
	}
	
	
	public static void initializenew(String QFileSelected, String RFileSelected) {
		QFile = QFileSelected;
		RFile = RFileSelected;
			
		} 
	
					
	public static void dotreceval() throws IOException {	
	    String qrels = QFile;
	    
	    System.out.println(qrels);
	    String res = RFile;
	    
	  System.out.println("THe filename of the Qrels file select is" + qrels);
	  System.out.println("The Res filenam is " +  res);
	    
	    trec_eval te = new trec_eval();
	    String[][] output = te.runAndGetOutput(new String[]{"-q", qrels, res});
	    //1st dimension is line of output, 2nd dim is [measure, query, value]

	    System.out.println(output.length + " " + output[0].length);
	    ArrayList<String> arrTotal = new ArrayList();
	    
	    for(int row =0 ; row < output.length; ++row) {
	     
	    	         System.out.println(output[row][0] + " "+ output[row][1] + " " + output[row][2]);
	    	         arrTotal.add(output[row][0] + " "+ output[row][1] + " " + output[row][2]);
	    }
	    String fileNameOutput;
	    
	    fileNameOutput="trecevaloutput";
	    createFile(fileNameOutput, arrTotal);
	    	    
	    
		}   
	
	private static void createFile(String file, ArrayList<String> arrData)
			throws IOException {
			FileWriter writer = new FileWriter(file + ".txt",false); //change to true for append
			int size = arrData.size();
			for (int i=0;i<size;i++) {
			String str = arrData.get(i).toString();
			writer.write(str);
			if(i < size-1) //This prevent creating a blank like at the end of the file**
			writer.write("\n");
			}
			writer.close();
			}
		}

	
