package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.CardLayout;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JToggleButton;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFormattedTextField;
import javax.swing.JFileChooser;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class UI {

	private JFrame frame;
	private JToggleButton tglbtnNewToggleButton;
	private JToggleButton tglbtnNewToggleButton_1;
	private JToggleButton tglbtnNewToggleButton_2;
	private JToggleButton tglbtnNewToggleButton_3;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private Button button;
public static String QrelFileName = null;
public static String RunFileName = null;
public static String QrelDir = null;
public static String RunDir = null;
public static String QrelFileNamePath = null;
public static String RunFileNamePath = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		label = new JLabel("");
		label.setBounds(19, 16, 0, 0);
		frame.getContentPane().add(label);
		
		label_18 = new JLabel("");
		label_18.setBounds(24, 16, 0, 0);
		frame.getContentPane().add(label_18);
		
		
		label_6 = new JLabel("");
		label_6.setBounds(29, 16, 0, 0);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("");
		label_7.setBounds(34, 16, 0, 0);
		frame.getContentPane().add(label_7);
		
		label_8 = new JLabel("");
		label_8.setBounds(39, 16, 0, 0);
		frame.getContentPane().add(label_8);
		
		label_9 = new JLabel("");
		label_9.setBounds(44, 16, 0, 0);
		frame.getContentPane().add(label_9);
		
		label_10 = new JLabel("");
		label_10.setBounds(49, 16, 0, 0);
		frame.getContentPane().add(label_10);
		
		label_11 = new JLabel("");
		label_11.setBounds(54, 16, 0, 0);
		frame.getContentPane().add(label_11);
		
		label_12 = new JLabel("");
		label_12.setBounds(59, 16, 0, 0);
		frame.getContentPane().add(label_12);
		
		label_13 = new JLabel("");
		label_13.setBounds(64, 16, 0, 0);
		frame.getContentPane().add(label_13);
		
		label_14 = new JLabel("");
		label_14.setBounds(69, 16, 0, 0);
		frame.getContentPane().add(label_14);
		
		label_15 = new JLabel("");
		label_15.setBounds(74, 16, 0, 0);
		frame.getContentPane().add(label_15);
		
		label_16 = new JLabel("");
		label_16.setBounds(79, 16, 0, 0);
		frame.getContentPane().add(label_16);
		
		label_17 = new JLabel("");
		label_17.setBounds(84, 16, 0, 0);
		frame.getContentPane().add(label_17);
		
		label_1 = new JLabel("");
		label_1.setBounds(89, 16, 0, 0);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(94, 16, 0, 0);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("");
		label_3.setBounds(99, 16, 0, 0);
		frame.getContentPane().add(label_3);
		
		tglbtnNewToggleButton = new JToggleButton("Submit");
		tglbtnNewToggleButton.setBounds(19, 3, 121, 36);
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		
		tglbtnNewToggleButton_3 = new JToggleButton("Basic stats");
		
ItemListener itemListener = new ItemListener() {
			
			public void itemStateChanged(ItemEvent itemEvent)
            {
  
                // event is generated in button
                int state = itemEvent.getStateChange();
  
                // if selected print selected in console
                if (state == ItemEvent.SELECTED) {
                    System.out.println("Selected");
                    //new newFrame();
                     makeNewFrame newFrame=new makeNewFrame();
                     JFrame f2 = null;
                    newFrame.initialize(f2, "Basic_Stats", "reOrdertrecevalAllsReOrdered.txt");
                     newFrame.createFrame();
                                     }
                else {
  
                    // else print deselected in console
                    System.out.println("Deselected");
                }
            }
        };
	
	tglbtnNewToggleButton_3.addItemListener(itemListener);
	tglbtnNewToggleButton_3.setBounds(19, 50, 121, 36);
	frame.getContentPane().add(tglbtnNewToggleButton_3);
		
		tglbtnNewToggleButton_2 = new JToggleButton("Detailed stats");
		
ItemListener itemListener2 = new ItemListener() {
			
			public void itemStateChanged(ItemEvent itemEvent)
            {
  
                // event is generated in button
                int state = itemEvent.getStateChange();
  
                // if selected print selected in console
                if (state == ItemEvent.SELECTED) {
                    System.out.println("Selected");
                    //new newFrame();
                     makeNewFrame newFrameNA=new makeNewFrame();
                     JFrame f3 = null;
                    newFrameNA.initialize(f3, "Advanced_Stats", "trecevalNonalls.txt");
                     newFrameNA.createFrame();
                                     }
                else {
  
                    // else print deselected in console
                    System.out.println("Deselected");
                }
            }
        };
	
				
        tglbtnNewToggleButton_2.addItemListener(itemListener2);
		tglbtnNewToggleButton_2.setBounds(19, 97, 121, 36);
		frame.getContentPane().add(tglbtnNewToggleButton_2);
		
		label_4 = new JLabel("");
		label_4.setBounds(412, 16, 0, 0);
		frame.getContentPane().add(label_4);
		
		tglbtnNewToggleButton_1 = new JToggleButton("Graphs");
		tglbtnNewToggleButton_1.setBounds(19, 146, 121, 33);
		frame.getContentPane().add(tglbtnNewToggleButton_1);
		
ItemListener itemListenerG = new ItemListener() {
			
			public void itemStateChanged(ItemEvent itemEvent)
            {
  
                // event is generated in button
                int state = itemEvent.getStateChange();
  
                // if selected print selected in console
                if (state == ItemEvent.SELECTED) {
                    System.out.println("Selected");
                    PlotData pd = new PlotData();
                    try {
						PlotData.MakeGraphs();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                   
                    
                }
                else {
  
                    // else print deselected in console
                    System.out.println("Deselected");
                }
            }
        };
	
	tglbtnNewToggleButton_1.addItemListener(itemListenerG);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(489, 5, 5, 22);
		frame.getContentPane().add(textArea);
		

		
		JButton btnNewButton = new JButton("Generate");
		btnNewButton.setBounds(192, 107, 77, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getQrelFileName();
				getRunFileName();
				getQrelDir();
				getRunDir();
				
				QrelFileNamePath=QrelDir;
				RunFileNamePath=RunDir;
	System.out.println("the full QrelDir is:" + QrelFileNamePath);
	System.out.println("the full RunDir is:" +RunFileNamePath);
	String qrelFile = QrelFileNamePath;
	String runFile = RunFileNamePath;
	jtreceval jtrc=new jtreceval();
	
	jtrc.initializenew(qrelFile, runFile);
				try {
					jtrc.dotreceval();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
		label_5 = new JLabel("");
		label_5.setBounds(499, 16, 0, 0);
		frame.getContentPane().add(label_5);
		frame.getContentPane().add(btnNewButton);
		
		
		Button button1 = new Button("Choose run file");
		button1.setBounds(180, 69, 104, 22);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf = new JFileChooser("c:");
				jf.showSaveDialog(null);
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"eval files", "txt");
				jf.setFileFilter(filter);
				int returnVal = jf.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				//System.out.println("You chose to open this file: " +
				//jf.getSelectedFile().getName());
				//System.out.println("getCurrentDirectory(): " +  jf.getCurrentDirectory());
				setRunFileName(jf.getSelectedFile().getName());
				setRunDir(jf.getSelectedFile().getAbsolutePath());
				}
			}

			private void setRunDir(String currentDirectory) {
				RunDir = currentDirectory; // TODO Auto-generated method stub
				
			}

			private void setRunFileName(String name) {
				RunFileName = name;
				
				// TODO Auto-generated method stub
				
			}
			});
			
		frame.getContentPane().add(button1);
		
		button = new Button("Choose .qrel file");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser j = new JFileChooser("c:");
				j.showSaveDialog(null);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"eval files", "txt");
				j.setFileFilter(filter);
				int returnVal = j.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				//System.out.println("You chose to open this file: " +
				//j.getSelectedFile().getName());
				setQrelFileName(j.getSelectedFile().getName());
				setQrelDir(j.getSelectedFile().getAbsolutePath());
				}
			}

			private void setQrelDir(String currentDirectory) {
				QrelDir = currentDirectory;// TODO Auto-generated method stub
				
			}

			private void setQrelFileName(String name) {
				QrelFileName = name;
				
				// TODO Auto-generated method stub
				
			}
			});
		
		button.setBounds(180, 36, 104, 22);
		frame.getContentPane().add(button);
	}
public static String getQrelFileName() {
		return  QrelFileName;
	}

public static String getRunFileName() {
	return  RunFileName;
}

public static String getQrelDir() {
	return  QrelDir;
}

public static String getRunDir() {
return  RunDir;
}
}

