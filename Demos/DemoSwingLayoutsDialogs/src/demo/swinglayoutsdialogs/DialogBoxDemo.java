package demo.swinglayoutsdialogs;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class DialogBoxDemo {

    // Entry-point.
    public static void main(String[] args) {
    	setWindowsLookAndFeel();
    	DialogBoxDemo app = new DialogBoxDemo();
    	app.doDemo();
    }

    // Launch-pad for demos - uncomment statements in this method, to run demo(s) of interest.
    public void doDemo() {
        displayMessageDialogBoxes();
        // displayConfirmationDialogBoxes();
        // displayOptionDialogBoxes();
        // displayInputDialogBoxes();
        // displayFileChooserDialogBoxes();
        // displayColorChooserDialogBoxes();
        // displayCustomDialogBoxes();
    }        

    public void displayMessageDialogBoxes() {
        JOptionPane.showMessageDialog(
                null,	// Parent component
                "This is a plain (icon-less) dialog",
                "My Dialog Box",
                JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(
                null,	// Parent component
                "This is a warning message",
                "My Dialog Box",
                JOptionPane.WARNING_MESSAGE);

        JOptionPane.showMessageDialog(
                null,	// Parent component
                "This is an error message",
                "My Dialog Box",
                JOptionPane.ERROR_MESSAGE);

        JOptionPane.showMessageDialog(
                null,	// Parent component
                "This is an information message",
                "My Dialog Box",
                JOptionPane.INFORMATION_MESSAGE);
    }

    
    public void displayConfirmationDialogBoxes() {
        int result;

        result = JOptionPane.showConfirmDialog(
                         null,	// Parent component
                         "Are you sure you want to quit?",
                         "My Dialog Box",
                         JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                         null,	// Parent component
                         "You said YES!", 
                         "Popup", 
                         JOptionPane.PLAIN_MESSAGE);
        }

        result = JOptionPane.showConfirmDialog(
                         null,	// Parent component
                         "Save changes?",
                         "My Dialog Box",
                         JOptionPane.YES_NO_CANCEL_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                         null,	// Parent component
                         "You said YES!", 
                         "Popup", 
                         JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void displayOptionDialogBoxes() {
        Object[] options = {"Oui", "Non"};
        int result;

        result = JOptionPane.showOptionDialog(
                         null,	// Parent component
                         "Parlez-vous français couramment?", 
                         "Français", 
                         JOptionPane.YES_NO_OPTION,
                         JOptionPane.QUESTION_MESSAGE,
                         null, 
                         options, 
                         options[0]);

        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                         null,	// Parent component
                         "You speak French fluently!", 
                         "Popup", 
                         JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void displayInputDialogBoxes() {
        String s;

        s = (String) JOptionPane.showInputDialog(
                         null,	// Parent component
                         "Please enter your name:",
                         "My Dialog Box",
                         JOptionPane.PLAIN_MESSAGE);

        if (s != null) 
        	System.out.println("Name: " + s);
        
        s = (String) JOptionPane.showInputDialog(
                         null,	// Parent component
                         "Choose a currency:",
                         "My Dialog Box",
                         JOptionPane.PLAIN_MESSAGE,
                         null,
                         new Object[] {"USD", "GBP", "EUR"},
                         "USD");

        if (s != null) 
        	System.out.println("Currency: " + s);
    }

    public void displayFileChooserDialogBoxes() {
        JFileChooser chooser;

        chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println("File to open: " + file.getAbsolutePath());
        }

        chooser = new JFileChooser();
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            System.out.println("File to save: " + file.getAbsolutePath());
        }
    }

    public void displayColorChooserDialogBoxes() {
        Color chosenColour;
        chosenColour = JColorChooser.showDialog(
                         null,	// Parent component
                         "My Dialog Box",
                         Color.red);
        if (chosenColour != null) {
            System.out.println("Chosen colour: " + chosenColour);
        }
    }

    public void displayCustomDialogBoxes() {
        JLabel      label      = new JLabel("Enter text:");
        JTextField  textField  = new JTextField(20);
        JButton     button     = new JButton("Done");
        JPanel      pane       = new JPanel();

        pane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pane.add(label);
        pane.add(textField);
        pane.add(button);

        final JDialog dialog = new JDialog((Frame)null, "My Dialog Box", true);
        dialog.getContentPane().add(pane);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.pack();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        });

        dialog.setVisible(true);
    }

    public static void setWindowsLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            System.out.println("Unable to set Windows look-and-feel"); 
        }
    }
}
