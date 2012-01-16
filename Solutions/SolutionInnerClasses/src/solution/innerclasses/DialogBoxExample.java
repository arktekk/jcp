package solution.innerclasses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// This class displays a Swing frame, containing several buttons.
// The class no longer implements the ActionListener itself.
public class DialogBoxExample {

    private JFrame  frame;  
    private JButton ibutton = new JButton("Show info message");
    private JButton wbutton = new JButton("Show warning message");
    private JButton ebutton = new JButton("Show error message");

    
    public static void main(String[] args) {
        new DialogBoxExample();
    }

    
    public DialogBoxExample() {

    	// Create a panel to contain three buttons.
        JPanel pane  = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add buttons to panel.
        pane.add(ibutton);
        pane.add(wbutton);
        pane.add(ebutton);

        // Handle click event on the "info" button.
        ibutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
        		JOptionPane.showMessageDialog(
                        frame,
                        "This is an information message",
                        "My Dialog Box",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Handle click event on the "warning" button.
        wbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
        		JOptionPane.showMessageDialog(
                        frame,
                        "This is a warning message",
                        "My Dialog Box",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        // Handle click event on the "error" button.
        ebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
        		JOptionPane.showMessageDialog(
                        frame,
                        "This is an error message",
                        "My Dialog Box",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

    	// Create and set up the top-level frame window.
        frame = new JFrame("My Main Frame");
        frame.getContentPane().add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
}
