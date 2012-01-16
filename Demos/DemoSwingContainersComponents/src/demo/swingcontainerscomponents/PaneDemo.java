package demo.swingcontainerscomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;

public class PaneDemo {

    // Entry-point.
    public static void main(String[] args) {
    	setWindowsLookAndFeel();
    	PaneDemo app = new PaneDemo();
    	app.doDemo();
    }

    // Launch-pad for demos - uncomment statements in this method, to run demo(s) of interest.
    public void doDemo() {
        demoJPanel();
        // demoJScrollPane();
        // demoJSplitPane();
        // demoJToolBar();
        // demoJTabbedPane();
    }        

    public void demoJPanel() {
        JFrame  frame  = new JFrame("Frame using JPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel  pane   = new JPanel();
 
        pane.setBackground(Color.red);
        pane.setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
        pane.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        pane.add(new JTextField(20));
        pane.add(new JButton("A Button"));
            
        frame.getContentPane().add(pane);
        frame.setSize(300, 200);
        frame.setVisible(true); 
    }

    public void demoJScrollPane() {
        JFrame      frame    = new JFrame("Frame using JScrollPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextArea   textarea = new JTextArea(10, 30);
        JScrollPane pane     = new JScrollPane(textarea);
 
        frame.getContentPane().add(pane);
        frame.setSize(300, 100);
        frame.setVisible(true); 
    }

    public void demoJSplitPane() {
        JFrame      frame     = new JFrame("Frame using JSplitPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextArea   textareaT = new JTextArea(10, 30);
        JTextArea   textareaB = new JTextArea(10, 30);
        JScrollPane paneT     = new JScrollPane(textareaT);
        JScrollPane paneB     = new JScrollPane(textareaB);
        JSplitPane  splitPane = new JSplitPane(
                                       JSplitPane.VERTICAL_SPLIT, 
                                       paneT,
                                       paneB);

        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(100);

        paneT.setMinimumSize(new Dimension(100,50));
        paneB.setMinimumSize(new Dimension(100,50));

        frame.getContentPane().add(splitPane);
        frame.setSize(300, 300);
        frame.setVisible(true); 
    }

    public void demoJToolBar() {
        JFrame      frame      = new JFrame("Frame using JToolBar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextArea   textarea   = new JTextArea(10, 30);
        JScrollPane scrollpane = new JScrollPane(textarea);

        JToolBar toolbar = new JToolBar();

        JButton button1 = new JButton("Button1");
        button1.setActionCommand("OPEN");
        button1.setToolTipText("Open a file");
//      button1.addActionListener(this);
        toolbar.add(button1);

        JButton button2 = new JButton("Button2");
        button2.setActionCommand("CLOSE");
        button2.setToolTipText("Close a file");
//      button2.addActionListener(this);
        toolbar.add(button2);

        JPanel mainpane = new JPanel();
        mainpane.setLayout(new BorderLayout());
        mainpane.add(toolbar, BorderLayout.PAGE_START);
        mainpane.add(scrollpane, BorderLayout.CENTER);

        frame.getContentPane().add(mainpane);
        frame.setSize(300, 300);
        frame.setVisible(true); 
    }

    public void demoJTabbedPane() {
        JFrame      frame       = new JFrame("Frame using JTabbedPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextField  textfield1  = new JTextField(30);
        JButton     button2     = new JButton("A button");

        JPanel panel1 = new JPanel();
        panel1.add(textfield1);

        JPanel panel2 = new JPanel();
        panel2.add(button2);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Tab 1", null, panel1, "Go to tab 1");
        tabbedPane.addTab("Tab 2", null, panel2, "Go to tab 2");

        frame.getContentPane().add(tabbedPane);
        frame.setSize(300, 300);
        frame.setVisible(true); 
    }

    public static void setWindowsLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            System.out.println("Unable to set Windows look-and-feel"); 
        }
    }
}
