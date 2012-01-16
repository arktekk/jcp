package solution.swingcontainerscomponents;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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

        // Create components for the 1st tab.
    	nameTextField       = new JTextField(20);
    	countryComboBox     = new JComboBox(new String[]{"[Unknown]", "Wales", "Scotland", "England", "Ireland"});
    	businessRadioButton = new JRadioButton("Business");
    	friendRadioButton   = new JRadioButton("Friend");
    	familiaritySlider   = new JSlider(1, 5);
    	addButton           = new JButton("Add");
    	resetButton         = new JButton("Reset");

    	// Put the radio buttons into a group.
		ButtonGroup typeGroup = new ButtonGroup(); 
		typeGroup.add(businessRadioButton);
		typeGroup.add(friendRadioButton);
		
		// Register event listeners.
		addButton.addActionListener(this);
		resetButton.addActionListener(this);
		
        // Add components to the panel.
		panel.add(nameTextField);
		panel.add(countryComboBox);
		panel.add(businessRadioButton);
		panel.add(friendRadioButton);
		panel.add(familiaritySlider);
		panel.add(addButton);
		panel.add(resetButton);

		// Return the panel.
		return panel;
	}


	// Create a JPanel containing the components for the 2nd tab.
	private JPanel createListContactsPanel() {
		
		// Create a panel.
		JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // Create components for the 2nd tab.
    	contactsList         = new JList(new DefaultListModel());
    	selectedContactLabel = new JLabel();
    	removeButton         = new JButton("Remove");

    	// Configure some of the component properties.
        contactsList.setFixedCellWidth(200);
        contactsList.setSelectionBackground(Color.YELLOW);
        selectedContactLabel.setForeground(Color.BLUE);
        
		// Register event listeners.
        contactsList.addListSelectionListener(this);
		removeButton.addActionListener(this);

        // Add components to the panel.
        panel.add(new JScrollPane(contactsList));
        panel.add(selectedContactLabel);
        panel.add(removeButton);

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
		
		// Create a new Contact object from the data entered by the user.
		Contact contact = new Contact(nameTextField.getText(), 
				                      (String)countryComboBox.getSelectedItem(), 
				                      businessRadioButton.isSelected() ? Contact.Type.Business : Contact.Type.Friend, 
				                      familiaritySlider.getValue());

		// Get the "model" associated with the list box, 
		// and then add the new contact into the list box's model.
		DefaultListModel listModel = (DefaultListModel)contactsList.getModel();
		listModel.addElement(contact);
	}
	
	
	// Process the "Reset" button click, to reset all the user input controls.
	private void doReset() {
		nameTextField.setText(null);
		countryComboBox.setSelectedIndex(0);
		businessRadioButton.setSelected(true);
		familiaritySlider.setValue(1);
	}
	
	
	// Process the "Remove" button click, to remove the selected contact from the list box.
	private void doRemove() {

		// Get the index of the selected item in the list box.
		int selectedIndex = contactsList.getSelectedIndex();
		
		// If there was an item selected...
		if (selectedIndex != -1) {
			
			// Remove the item from the list box's model.
			DefaultListModel listModel = (DefaultListModel)contactsList.getModel();
			listModel.remove(selectedIndex);
		}
	}

	
	// Handle list selection events in the application.
	public void valueChanged(ListSelectionEvent arg0) {

		// Get the selected item in the list box.
		Contact selectedContact = (Contact)contactsList.getSelectedValue();
		
		// If there was an item selected...
		if (selectedContact != null) { 
			// Display the selected contact.
			this.selectedContactLabel.setText(selectedContact.getFullDetails());
		}
		else {
			// Display an empty string.
			this.selectedContactLabel.setText("");
		}
	}
}
