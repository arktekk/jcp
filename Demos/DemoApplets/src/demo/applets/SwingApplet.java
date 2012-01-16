package demo.applets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingApplet extends JApplet implements ActionListener {

	private static final long serialVersionUID = 1L;

	public void init() {
        // Execute a job on the event-dispatching thread; creating this applet's GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        } catch (Exception e) { 
            System.err.println("createGUI() exception occurred");
        }
    }
    
	private JLabel label = new JLabel("Enter text:");
	private JTextField textField = new JTextField(20);
	private JButton button = new JButton("Click me");

    // Create the GUI (for thread safety, this method should be invoked from the event-dispatching thread.)
	private void createGUI() {
		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	
		pane.add(label);
		pane.add(textField);
		pane.add(button);
		button.addActionListener(this);
	
	    this.setContentPane(pane);        
	}        
	
	public void actionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this, 
				                      textField.getText(),
				                      "My Dialog Box", 
				                      JOptionPane.PLAIN_MESSAGE);
	}
}