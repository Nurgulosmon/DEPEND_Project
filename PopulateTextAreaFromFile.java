package views;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.awt.event.*;

 

public class PopulateTextAreaFromFile extends JFrame {
          
        // JFrame
        static JFrame f;
         // JButton
        static JButton b;
         // label to display text
        static JLabel l;
         // text area
        static JTextArea textArea;
        static //  array list for data
        ArrayList<String> filedata = new ArrayList<String>();
         // default constructor
      
      
        // main class
        public static void main(String[] args)
        {
             SwingUtilities.invokeLater(new Runnable()
             {
                 public void run()
                 {
                     PopulateTextAreaFromFile.makeGUI();
                 }
             });    
        }        
            
        public static void makeGUI() {    
            File dirOutputs = new File("C:\\Users\\DELL\\Documents\\CS Project\\for trec eval\\CLEFeHealth2016\\outputs");
            String AllfileName= dirOutputs.toString() + "\\" + "reOrdertrecevalAllsReOrdered.txt";
            filedata = readAllsFile(AllfileName);
              
            // create a new frame to store text field and button
            f = new JFrame("textfield");
              f.setSize(400, 400);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
            JTextArea textArea = new JTextArea(30,50);
            JButton displayButton = new JButton("Display");
                   
            displayButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                       String s = e.getActionCommand();
                       if (s.equals("Display")) {
                           for(String a : filedata){
                               System.out.println(a);
                               if(a.equals(filedata.get(filedata.size()-1))){
                                   textArea.append(a +"\n");
                               }else{
                                  textArea.append(a +"\n");
                               }
                               }
                                 }
                }
            });
            
            
            f.getContentPane().add(textArea, BorderLayout.CENTER);
            f.getContentPane().add(displayButton, BorderLayout.PAGE_END);
            f.pack();
            f.setLocationByPlatform(true);
            f.setVisible(true);
            
    
        }
      
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
 