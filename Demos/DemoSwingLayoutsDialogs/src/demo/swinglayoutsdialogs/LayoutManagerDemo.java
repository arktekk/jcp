package demo.swinglayoutsdialogs;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.UIManager;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.Box;

public class LayoutManagerDemo {

    // Entry-point.
    public static void main(String[] args) {
    	setWindowsLookAndFeel();
    	LayoutManagerDemo app = new LayoutManagerDemo();
    	app.doDemo();
    }

    // Launch-pad for demos - uncomment statements in this method, to run demo(s) of interest.
    public void doDemo() {
    	demoFlowLayout();
        // demoBorderLayout();
        // demoGridLayout();
        // demoBoxLayout();
    }

    public void demoFlowLayout() {
        JFrame frame = new JFrame("FlowLayout Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();

        pane.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        pane.add(new JTextField(20));
        pane.add(new JTextField(20));
        pane.add(new JButton("Button 1"));
        pane.add(new JButton("Button 2"));
        pane.add(new JButton("Button 3"));
            
        frame.getContentPane().add(pane);
        frame.setSize(300, 200);
        frame.setVisible(true); 
    }

    public void demoBorderLayout() {
        JFrame frame = new JFrame("BorderLayout Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();

        pane.setLayout(new BorderLayout(10, 10));
        pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        pane.add(new JTextField(20), BorderLayout.NORTH);
        pane.add(new JTextField(20), BorderLayout.SOUTH);
        pane.add(new JButton("Button 1"), BorderLayout.WEST);
        pane.add(new JButton("Button 2"), BorderLayout.CENTER);
        pane.add(new JButton("Button 3"), BorderLayout.EAST);
            
        frame.getContentPane().add(pane);
        frame.setSize(300, 200);
        frame.setVisible(true); 
    }

    public void demoGridLayout() {
        JFrame frame = new JFrame("GridLayout Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();

        pane.setLayout(new GridLayout(5, 1, 10, 10));
        pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        pane.add(new JTextField(20));
        pane.add(new JTextField(20));
        pane.add(new JButton("Button 1"));
        pane.add(new JButton("Button 2"));
        pane.add(new JButton("Button 3"));
            
        frame.getContentPane().add(pane);
        frame.setSize(300, 200);
        frame.setVisible(true); 
    }

    public void demoBoxLayout() {
        JFrame frame = new JFrame("BoxLayout Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel textPanel   = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel mainPanel   = new JPanel();

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(new JTextField(20));
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(new JTextField(20));

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(new JButton("Button 1"));
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(new JButton("Button 2"));
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(new JButton("Button 3"));
           
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        mainPanel.add(textPanel);
        mainPanel.add(buttonPanel);

        frame.getContentPane().add(mainPanel);
        frame.setSize(300, 200);
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
