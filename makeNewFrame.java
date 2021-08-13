package views;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class makeNewFrame {
		
	JFrame frameNumber;
	JTextArea textArea;
    ArrayList<String> filedata = new ArrayList<String>();
    String fileTitle=null;
    
	public makeNewFrame() {
			
	}
	
	public void initialize(JFrame frameName, String frameTitle, String Filename) {
		frameNumber=frameName;
		frameNumber = new JFrame(frameTitle);
		fileTitle=Filename;
	}
	
	
	
	public void createFrame() {
	
		File dirOutputs = new File("C:\\Users\\DELL\\Documents\\CS Project\\for trec eval\\CLEFeHealth2016\\outputs");
		String AllfileName=null;
	    AllfileName= dirOutputs.toString() + "\\" + fileTitle;
	    System.out.println(AllfileName);
	    filedata = readAllsFile(AllfileName);
		
	    frameNumber.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frameNumber.setSize(200,200);
	    JTextArea textArea = new JTextArea(30,50);
	    JScrollPane scroll = new JScrollPane(textArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    for(String a : filedata){
	    textArea.append(a +"\n");
	    }
	    frameNumber.getContentPane().add(scroll);
	    frameNumber.pack();
	    frameNumber.setLocationRelativeTo(null);
	    frameNumber.setVisible(true);	}
	  
	public static ArrayList readAllsFile(String fileName) {
		
		StringBuilder contentBuilder = new StringBuilder();
		String content=null;
		ArrayList allEntries = new ArrayList();

		try (Stream<String> lines = Files.lines( Paths.get(fileName), StandardCharsets.UTF_8)) { 
			lines.forEach(line -> 
					allEntries.add(line));	
		}    catch (IOException e)  {
			e.printStackTrace();
		}
		return allEntries;
}
}