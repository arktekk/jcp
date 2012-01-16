package solution.swingui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MemoMinder implements ActionListener {

	// Frame and components.
	private JFrame frame = new JFrame("Memo Minder");
	private JLabel label = new JLabel("Enter memo:");
	private JTextField memoTextField = new JTextField(20);
	private JButton addButton = new JButton("Add to list");
	private JButton displayButton = new JButton("Display list");
	private JButton clearButton = new JButton("Clear list");

	
	// List of "memo" items (note, this is just a regular list, not a GUI listbox!).
	List<String> memoItems = new ArrayList<String>();

	
	public static void main(String[] args) {
		new MemoMinder();
	}


	// Constructor.
	public MemoMinder() {

		// Create a JPanel for the frame.
		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		frame.getContentPane().add(pane);

		// Add components to the pane.
		pane.add(label);
		pane.add(memoTextField);
		pane.add(addButton);
		pane.add(displayButton);
		pane.add(clearButton);

		// Handle action events on all the buttons.
		addButton.addActionListener(this);
		displayButton.addActionListener(this);
		clearButton.addActionListener(this);

		// Display the JFrame.
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	
	// Handle all button clicks.
	public void actionPerformed(ActionEvent evt) {
		
		// Determine which button was clicked, and call a method to do the appropriate processing.
		Object eventSource = evt.getSource();
		
		if (eventSource == addButton) {
			doAddToList();
		}
		else if (eventSource == displayButton) {
			doDisplayList();
		}
		else if (eventSource == clearButton) {
			doClearList();
		}
		
		// Tidy up the UI (i.e. put the cursor back into the textfield, and clear the textfield.
		memoTextField.grabFocus();
		memoTextField.setText("");
	}

	
	// Process the "Add to list" button click.
	private void doAddToList() {
		
		// Get the text from the textfield, add it to the list of memo items, and display a message box to let the user know.
		String memo = memoTextField.getText();
		memoItems.add(memo);
		JOptionPane.showMessageDialog(frame, memo, "Added Memo Item", JOptionPane.INFORMATION_MESSAGE);
	}

	
	// Process the "Display list" button click.
	private void doDisplayList() {

		// Create a string that contains all the memo items in our list, and display in a message box.
		String message = "";
		for (String memo: memoItems) {
			message += memo + "\n";
		}
		JOptionPane.showMessageDialog(frame, message, "Memo Items", JOptionPane.PLAIN_MESSAGE);
	}
	

	// Process the "Clear list" button click.
	private void doClearList() {

		// Clear the list of memo items, and display a message box to let the user know.
		memoItems.clear();
		JOptionPane.showMessageDialog(frame, "No memo items remaining", "Cleared all Memo Items", JOptionPane.INFORMATION_MESSAGE);
	}
}
