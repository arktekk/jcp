package student.swingcontainerscomponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ContactManager implements ActionListener, ListSelectionListener {

	// Declare components for the 1st tab.
	private JTextField   nameTextField;
	private JComboBox    countryComboBox;
	private JRadioButton businessRadioButton;
	private JRadioButton friendRadioButton;
	private JSlider      familiaritySlider;
	private JButton      addButton;
	private JButton      resetButton;

	// Declare components for the 2nd tab.
	private JList   contactsList;
	private JLabel  selectedContactLabel;
	private JButton removeButton;


	public static void main(String[] args) {
		ContactManager cm = new ContactManager();
		cm.display();
	}


	private void display() {
		
		// Create the main fame window for the application.
        JFrame frame = new JFrame("Contact Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a tabbed pane containing two tabs.
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("Add contact", createAddContactPanel());
		tabbedPane.add("List contacts", createListContactsPanel());

        // Display the frame window.
        frame.getContentPane().add(tabbedPane);
        frame.setSize(360, 260);
        frame.setVisible(true); 
    }
	
	
	// Create a JPanel containing the components for the 1st tab.
	private JPanel createAddContactPanel() {
		
		// Create a panel.
		JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // TODO: Create components for the 1st tab.

        // TODO: Put the radio buttons into a group.
		
		// TODO: Register event listeners.
		
        // TODO: Uncomment the following statements, to add components to the panel.
		/*
        panel.add(nameTextField);
		panel.add(countryComboBox);
		panel.add(businessRadioButton);
		panel.add(friendRadioButton);
		panel.add(familiaritySlider);
		panel.add(addButton);
		panel.add(resetButton);
		*/
        
		// Return the panel.
		return panel;
	}


	// Create a JPanel containing the components for the 2nd tab.
	private JPanel createListContactsPanel() {
		
		// Create a panel.
		JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // TODO: Create components for the 2nd tab.

        // TODO: Configure some of the component properties.
       
		// TODO: Register event listeners.

        // TODO: Uncomment the following statements, to add components to the panel.
        /*
        panel.add(contactsList);
        panel.add(selectedContactLabel);
        panel.add(removeButton);
		 */
        
		// Return the panel.
		return panel;
	}

	
	// Handle all button click events in the application.
	public void actionPerformed(ActionEvent evt) {
		
		// Determine which button was clicked, and call a method to do the appropriate processing.
		Object eventSource = evt.getSource();
		
		if (eventSource == addButton) {
			doAdd();
		}
		else if (eventSource == resetButton) {
			doReset();
		}
		else if (eventSource == removeButton) {
			doRemove();
		}
	}
	
	
	// Process the "Add" button click, to add a new contact to the list box.
	private void doAdd() {
		
		// TODO: Create a new Contact object from the data entered by the user.

		// TODO: Get the "model" associated with the list box, 
		//       and then add the new contact into the list box's model.

	}
	
	
	// Process the "Reset" button click, to reset all the user input controls.
	private void doReset() {
		// TODO: Reset all of input controls.
		
	}
	
	
	// Process the "Remove" button click, to remove the selected contact from the list box.
	private void doRemove() {

		// TODO: Get the index of the selected item in the list box.
		//       If there was an item selected, remove the item from the list box's model.

	}

	
	// Handle list selection events in the application.
	public void valueChanged(ListSelectionEvent arg0) {

		// TODO: Get the selected item in the list box.
		//       If there was an item selected, display it.
		//       Otherwise, display an empty string.

	}
}
