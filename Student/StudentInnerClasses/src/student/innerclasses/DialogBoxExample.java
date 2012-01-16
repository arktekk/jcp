package student.innerclasses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// This class displays a Swing frame, containing several buttons.
// The class implements the ActionListener itself (i.e. it implements actionPerformed() to handle button clicks).
// TODO: Don't implement ActionListener on this class.
//       Instead, define separate anonymous inner classes that implement ActionListener at the point where they are needed.
public class DialogBoxExample implements ActionListener {

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

        // Handle click event on each button (at the moment, we handle all click events in "this" object).
        // TODO: Define your anonymous inner classes here, to implement ActionListener separately for each button.
        ibutton.addActionListener(this);
        wbutton.addActionListener(this);
        ebutton.addActionListener(this);

    	// Create and set up the top-level frame window.
        frame = new JFrame("My Main Frame");
        frame.getContentPane().add(pane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }


    // Handle click events for all buttons.
    // TODO: Move this code into separate anonymous inner classes, one per button click.
    public void actionPerformed(ActionEvent evt) {

    	// Determine which button the user clicked.
    	if (evt.getSource() == ibutton) {

    		JOptionPane.showMessageDialog(
                    frame,
                    "This is an information message",
                    "My Dialog Box",
                    JOptionPane.INFORMATION_MESSAGE);

    	} else if (evt.getSource() == wbutton) {

    		JOptionPane.showMessageDialog(
                    frame,
                    "This is a warning message",
                    "My Dialog Box",
                    JOptionPane.WARNING_MESSAGE);

    	} else if (evt.getSource() == ebutton) {

    		JOptionPane.showMessageDialog(
                    frame,
                    "This is an error message",
                    "My Dialog Box",
                    JOptionPane.ERROR_MESSAGE);
    	}
    }
}
