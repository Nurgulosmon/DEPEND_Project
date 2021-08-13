package views;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PlotData {
	//static File dir = new File("C:\\Users\\DELL\\Documents\\CS Project\\for trec eval\\CLEFeHealth2016\\treceval_output");
	static File dirOutputs = new File("C:\\Users\\DELL\\Documents\\CS Project\\for trec eval\\CLEFeHealth2016\\outputs");

 public static void MakeGraphs() throws Exception
{
String fileData;
String fileNameOutput;

ArrayList<String> bpref_dataRequired = new ArrayList<String>();
ArrayList<String> map_dataRequired = new ArrayList<String>();
ArrayList<String> P_5_dataRequired = new ArrayList<String>();
ArrayList<String> P_10_dataRequired = new ArrayList<String>();
ArrayList<String> P_20_dataRequired = new ArrayList<String>();

bpref_dataRequired=extractFileData(dirOutputs.toString() + "\\" + "trecevalNonalls.txt","map");
map_dataRequired=extractFileData(dirOutputs.toString() + "\\" + "trecevalNonalls.txt","map");
P_5_dataRequired=extractFileData(dirOutputs.toString() + "\\" + "trecevalNonalls.txt","P_5");
P_10_dataRequired=extractFileData(dirOutputs.toString() + "\\" + "trecevalNonalls.txt","P_10");
P_20_dataRequired=extractFileData(dirOutputs.toString() + "\\" + "trecevalNonalls.txt","P_20");
plotXYline bpref=new plotXYline();
plotData(bpref_dataRequired, "bpref",bpref);
plotXYline map=new plotXYline();
plotData(map_dataRequired, "map",map);
plotXYline pxy_5=new plotXYline();
plotData(P_5_dataRequired, "P_5",pxy_5);
plotXYline pxy_10=new plotXYline();
plotData(P_10_dataRequired, "P_10",pxy_10);
plotXYline pxy_20=new plotXYline();
plotData(P_20_dataRequired, "P_20",pxy_20);
}



private static ArrayList extractFileData(String fileName,String patternToFind) {
StringBuilder contentBuilder = new StringBuilder();
String content=null;
ArrayList<String> inputFile = new ArrayList<String>();
ArrayList<String> dataRequired = new ArrayList<String>();
try (Stream<String> lines = Files.lines( Paths.get(fileName), StandardCharsets.UTF_8))
{
lines.forEach(line ->
{
inputFile.add(line);
}
);
} catch (IOException e) {
e.printStackTrace();
}
String regex="\\b" + patternToFind + "\\b";
Pattern p = Pattern.compile(regex);
int index=0;
for (String s : inputFile) {
Matcher matcher = p.matcher(s);
if (matcher.find())
dataRequired.add(s);
}

return dataRequired;
}


public static void plotData(ArrayList<String> input,String title,plotXYline pxy) {
int length=input.size();

double[] XAxis=new double[length];
double[] YAxis=new double[length];

int index=0;
for (String s : input) {
String[] splitStr = s.trim().split("\\s+");;
XAxis[index]=Double.parseDouble(splitStr[1]);
YAxis[index]=Double.parseDouble(splitStr[2]);

index++;
}
pxy.plotData(XAxis, YAxis, title, "X data", "Y data", "Data Plot");

StdStats ss=new StdStats();
double average=ss.mean(YAxis);
double stdDeviation=ss.stddev(YAxis);
double variance=ss.var(YAxis);
System.out.println("This is the statistics for " + title +" The Average = " + average + " The Standard Deviation =" + stdDeviation + " The Variance = " + variance);

}

}