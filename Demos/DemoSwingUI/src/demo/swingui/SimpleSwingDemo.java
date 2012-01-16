package demo.swingui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SimpleSwingDemo implements ActionListener {

	// Frame, components, and a console-reader.
	private JFrame frame;
	private JLabel label = new JLabel("Enter text:");
	private JTextField textField = new JTextField(20);
	private JButton button = new JButton("Click me");
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		new SimpleSwingDemo();
	}

	public SimpleSwingDemo() {

		JPanel pane; // Pane, contains components

		// Set the look and feel.
		try {
			System.out.print("Choose look-and-feel [windows, motif, metal, default] ");
			String in = br.readLine();

			if (in.equals("windows")) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} else if (in.equals("motif")) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			} else if (in.equals("motif")) {
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			} else {
				// Set the cross-platform look and Feel
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			}
		} catch (IOException ex) {
			System.out.println("IOException: " + ex);
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException: " + ex);
		} catch (InstantiationException ex) {
			System.out.println("InstantiationException: " + ex);
		} catch (IllegalAccessException ex) {
			System.out.println("IllegalAccessException: " + ex);
		} catch (UnsupportedLookAndFeelException ex) {
			System.out.println("UnsupportedLookAndFeelException: " + ex);
		}

		// Create the JFrame, add components, set event handlers, and then make the frame visible.
		frame = new JFrame("My Simple Swing Frame");
		pane = new JPanel();
		pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		pane.add(label);
		pane.add(textField);
		pane.add(button);

		button.addActionListener(this);

		frame.getContentPane().add(pane);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(frame, 
				                      textField.getText(),
				                      "My Dialog Box", 
				                      JOptionPane.PLAIN_MESSAGE);
	}
}
