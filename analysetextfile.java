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

public class analysetextfile {
	static File dir = new File("C:\\Users\\DELL\\Documents\\CS Project\\for trec eval\\CLEFeHealth2016\\treceval_output");
	static File dirOutputs = new File("C:\\Users\\DELL\\Documents\\CS Project\\for trec eval\\CLEFeHealth2016\\outputs");

 public void reorderAllFile() throws Exception
{
String fileData;
String fileNameOutput;
String[] fileList = dir.list();
for(String str : fileList) {
extractAllsfromTextFile(dir.toString() +"\\"+str);
}
reorderAllFile(dirOutputs.toString() + "\\" + "trecevalalls.txt");
}

public static void extractAllsfromTextFile(String fileName) {
ArrayList alls = new ArrayList();
String fileData;
readFileOneString(fileName);
}

 public static void readFileOneString(String fileName) {
StringBuilder contentBuilder = new StringBuilder();
String content=null;

String regex = "\\ball\\b";
String regexNeg = "^(?!.*all).*$";

Pattern p = Pattern.compile(regex);
Pattern pNeg = Pattern.compile(regexNeg);

ArrayList allEntries = new ArrayList();
ArrayList noNallEntries = new ArrayList();

try (Stream<String> lines = Files.lines( Paths.get(fileName), StandardCharsets.UTF_8)) {
lines.forEach(line ->
{
Matcher matcher = p.matcher(line);
while (matcher.find()){
allEntries.add(line);
}
Matcher matcherNeg = pNeg.matcher(line);
while (matcherNeg.find()){
noNallEntries.add(line);
}
}

 );

String AllfileNameOutput= dirOutputs.toString() + "\\" + "trecevalalls";
createFile(AllfileNameOutput, allEntries);
String NonAllfileNameOutput= dirOutputs.toString() + "\\" + "trecevalNonalls";
createFile(NonAllfileNameOutput, noNallEntries);

} catch (IOException e) {
e.printStackTrace();
}
}

private static void reorderAllFile(String fileName) throws IOException {
StringBuilder contentBuilder = new StringBuilder();
String content=null;
NavigableSet<String> allFile = new TreeSet<String>();
try (Stream<String> lines = Files.lines( Paths.get(fileName), StandardCharsets.UTF_8))
{
lines.forEach(line ->
{
allFile.add(line);
}
);
} catch (IOException e) {
e.printStackTrace();
}

String find5 = "map";
String find4 = "P_20";
String find3 = "P_10";
String find2 = "P_5";
String find1 = "gm_map";
String find0 = "runid";
String zeroMatch = allFile.ceiling(find0);
allFile.remove(zeroMatch);
String firstMatch = allFile.ceiling(find1);
allFile.remove(firstMatch);
String secondMatch = allFile.ceiling(find2);
allFile.remove(secondMatch);
String thirdMatch = allFile.ceiling(find3);
allFile.remove(thirdMatch);
String fourthMatch = allFile.ceiling(find4);
allFile.remove(fourthMatch);
String fifthMatch = allFile.ceiling(find5);
allFile.remove(fifthMatch);
ArrayList<String> arrayListAlls = new ArrayList<String>();
arrayListAlls.addAll(allFile);
arrayListAlls.add(0,fifthMatch);
arrayListAlls.add(0,fourthMatch);
arrayListAlls.add(0,thirdMatch);
arrayListAlls.add(0,secondMatch);
arrayListAlls.add(0,firstMatch);
arrayListAlls.add(0,zeroMatch);
String ReOrderAllfileNameOutput= dirOutputs.toString() + "\\" + "reOrdertrecevalAllsReOrdered";
createFile(ReOrderAllfileNameOutput, arrayListAlls);
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

public static void plotData(ArrayList<String> input,String title,plotXYline pxy) {
int length=input.size();

double[] XAxis=new double[length];
double[] YAxis=new double[length];

int index=0;
for (String s : input) {
String[] splitStr = s.trim().split("\\s+");;
XAxis[index]=Double.parseDouble(splitStr[1]);
YAxis[index]=Double.parseDouble(splitStr[2]);
// System.out.println("x= " + XAxis[index] + " y= " + YAxis[index]);
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
