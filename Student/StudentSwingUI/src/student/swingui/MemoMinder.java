package student.swingui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


// TODO: This class should implement ActionListener, so that it can handle button clicks.
public class MemoMinder {

	// The main frame for the application.
	private JFrame frame = new JFrame("Memo Minder");

	// TODO: Declare the following Swing UI components here.
	//   - JLabel containing the text "Enter memo:"
	//   - JTextField 20 characters in size, to hold a memo text
	//   - JButton to "Add to list"
	//   - JButton to "Display list"
	//   - JButton to "Clear list"

	
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

		// TODO: Add all the components to the pane.


		// TODO: Handle action events on all the buttons.


		// Display the JFrame.
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	
	// TODO: Write an actionPerformed() method here, to handle all the button clicks.
	//       In the method, determine which button was clicked, and call one of the helper methods below to do the processing.
	//       For example, if the user clicked the "Add to list" button, call the doAddToList() method, etc.


	
	// Process the "Add to list" button click.
	private void doAddToList() {
		
		// TODO: Get the text from the textfield, add it to the list of memo items, and display a message box to let the user know.

	}

	
	// Process the "Display list" button click.
	private void doDisplayList() {

		// Create a string that contains all the memo items in our list.
		String message = "";
		for (String memo: memoItems) {
			message += memo + "\n";
		}
		
		// TODO: Display a message box to output the message. 

	}
	

	// Process the "Clear list" button click.
	private void doClearList() {

		// Clear the list of memo items.
		memoItems.clear();

		// TODO: Display a message box to let the user know the list has been cleared. 

	}
}
