package demo.swingcontainerscomponents;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import java.awt.FlowLayout;


public class ComponentDemo {

	// Instance variables, to enable easy access to components from the demo methods.
    private JButton b1, b2;
    private JCheckBox cb1, cb2;
    private JRadioButton rb1, rb2;

    private ImageIcon icon1 = new ImageIcon("images/Cross.gif");
    private ImageIcon icon2 = new ImageIcon("images/Tick.gif");

    // Entry-point.
    public static void main(String[] args) {
    	setWindowsLookAndFeel();
    	ComponentDemo app = new ComponentDemo();
    	app.doDemo();
    }

    // Launch-pad for demos - uncomment statements in this method, to run demo(s) of interest.
    public void doDemo() {
        demoText();
        // demoPushButtons();
        // demoCheckBoxes();
        // demoRadioButtons();
        // demoMenus();
    }

    public void demoText() {
        JFrame frame  = new JFrame("Frame with text components");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel pane   = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));
       
        pane.add(new JTextField(10));
        pane.add(new JPasswordField(10));
        JScrollPane scrollpane = new JScrollPane(new JTextArea(30, 10));
        pane.add(scrollpane);

        frame.getContentPane().add(pane);
        frame.setSize(300, 200);
        frame.setVisible(true); 
    }

    public void demoPushButtons() {
        JFrame frame = new JFrame("Frame with buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        b1 = new JButton("Hide icons", icon1);
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_H);
        b1.setActionCommand("hide");
        b1.setToolTipText("Click to hide icons on buttons");

        b2 = new JButton("Show icons", icon2);
        b2.setVerticalTextPosition(AbstractButton.CENTER);
        b2.setHorizontalTextPosition(AbstractButton.TRAILING);
        b2.setMnemonic(KeyEvent.VK_S);
        b2.setActionCommand("show");
        b2.setToolTipText("Click to show icons on buttons");

		PushButtonActionListener listener = new PushButtonActionListener();
		b1.addActionListener(listener);
		b2.addActionListener(listener);

        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));     
        pane.add(b1);
        pane.add(b2);

        frame.getContentPane().add(pane);
        frame.setSize(300, 200);
        frame.setVisible(true); 
    }

    public void demoCheckBoxes() {
        JFrame frame = new JFrame("Frame with check boxes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cb1 = new JCheckBox("Ski hire");
        cb1.setMnemonic(KeyEvent.VK_S);
        cb1.setSelected(true);
        cb1.setToolTipText("Do you require ski hire?");

        cb2 = new JCheckBox("Boots hire");
        cb2.setMnemonic(KeyEvent.VK_B);
        cb2.setSelected(true);
        cb2.setToolTipText("Do you require boot hire?");

		CheckBoxItemListener listener = new CheckBoxItemListener();
		cb1.addItemListener(listener);
		cb2.addItemListener(listener);

        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane.add(cb1);
        pane.add(cb2);

        frame.getContentPane().add(pane);
        frame.setSize(300, 200);
        frame.setVisible(true); 
    }

    public void demoRadioButtons() {
        JFrame frame = new JFrame("Frame with radio buttons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        rb1 = new JRadioButton("Male");
        rb1.setMnemonic(KeyEvent.VK_M);
        rb1.setActionCommand("male");
        rb1.setToolTipText("Are you male?");
        rb1.setSelected(true);

        rb2 = new JRadioButton("Female");
        rb2.setMnemonic(KeyEvent.VK_F);
        rb2.setActionCommand("female");
        rb2.setToolTipText("Are you female?");

		RadioButtonActionListener listener = new RadioButtonActionListener();
		rb1.addActionListener(listener);
		rb2.addActionListener(listener);

        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);

        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));
        pane.add(rb1);
        pane.add(rb2);

        frame.getContentPane().add(pane);
        frame.setSize(300, 200);
        frame.setVisible(true); 
    }

    public void demoMenus() {
        JFrame frame = new JFrame("Frame with menus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        menuBar.add(file);

        JMenuItem open = new JMenuItem("Open...", KeyEvent.VK_O);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        JMenuItem close = new JMenuItem("Close", KeyEvent.VK_C);
        close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));

        file.add(open);
        file.addSeparator();
        file.add(close);

        JMenu edit = new JMenu("Edit");
        edit.setMnemonic(KeyEvent.VK_E);
        menuBar.add(edit);

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

	// Inner class, to handle ActionEvents for the demoPushButtons() method.
	class PushButtonActionListener implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {
	        if ("hide".equals(e.getActionCommand())) {
	            b1.setIcon(null);
	            b2.setIcon(null);
	        } else if ("show".equals(e.getActionCommand())) {
	            b1.setIcon(icon1);
	            b2.setIcon(icon2);
	        }
	    }
	}

	// Inner class, to handle ItemEvents for the demoCheckBoxes() method.
	class CheckBoxItemListener implements ItemListener {
	
	    public void itemStateChanged(ItemEvent e) {
	        Object source = e.getItemSelectable();
	        String label  = "";
	
	        if (source == cb1) {
	            label = cb1.getText();
	        } else if (source == cb2) {
	            label = cb2.getText();
	        }
	
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	        	System.out.println(label + " required");
	        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
	        	System.out.println(label + " not required");
	        }
	    } 
	}

	// Inner class, to handle ActionEvents for the demoRadioButtons() method.
	class RadioButtonActionListener implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {
			if ("male".equals(e.getActionCommand())) {
	            JOptionPane.showMessageDialog(null, "Male", "Item selected", JOptionPane.PLAIN_MESSAGE);
	        } else if ("female".equals(e.getActionCommand())) {
	            JOptionPane.showMessageDialog(null, "Female", "Item selected", JOptionPane.PLAIN_MESSAGE);
	        }
		}
	}
}

