package student.innerclasses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// This class displays a Swing frame, containing a textbox and a button.
// The class implements the ActionListener itself (i.e. it implements actionPerformed() to handle button clicks).
// TODO: Don't implement ActionListener on this class.
//       Instead, define an anonymous inner class that implements ActionListener at the point where it's needed.
public class SimpleSwingExample implements ActionListener {

    private JFrame     frame;  
    private JLabel     label     = new JLabel("Enter text:");
    private JTextField textField = new JTextField(20);
    private JButton    button    = new JButton("Click me");
    
    
    public static void main(String[] args) {
        new SimpleSwingExample();
    }

    
    public SimpleSwingExample() {
        
    	// Create a panel to contain three buttons.
    	JPanel pane = new JPanel();   
        pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add components to panel.
        pane.add(label);
        pane.add(textField);
        pane.add(button);

        // Handle click event on the button.
        // TODO: Define your anonymous inner class here, to implement ActionListener.
        button.addActionListener(this);
            
    	// Create and set up the top-level frame window.
        frame = new JFrame("My Simple Swing Frame");
        frame.getContentPane().add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    
    // Event handler method (as required by ActionListener interface).
    // TODO: Move this code into an anonymous inner class, within the SimpleSwing constructor method above.
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(frame,
                                      textField.getText(),
                                      "My Dialog Box",
                                      JOptionPane.PLAIN_MESSAGE);
    }
}
