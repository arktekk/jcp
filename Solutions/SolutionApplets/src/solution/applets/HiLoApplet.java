package solution.applets;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class HiLoApplet extends JApplet implements ActionListener {

	private static final long serialVersionUID = 1L;

	// Instance variables for Hi-Lo logic.
	private int upperLimit;
	private int target;
	private int count;
	
	
	// Instance variables for Swing UI components.
	private JLabel promptLabel = new JLabel("Guess a number:");
	private JTextField guessTextField = new JTextField(3);
	private JButton tryButton = new JButton("Try it!");
	private JLabel infoLabel = new JLabel();
	private JButton newGameButton = new JButton("New game");

	
	// Initialize the applet.
	public void init() {

		// Get the upperLimit parameter from the HTML host page.
		try {
			upperLimit = Integer.parseInt(this.getParameter("upperLimit"));
		}
		catch (NumberFormatException ex) {
			upperLimit = 100;
		}

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
    

    // Create the GUI (for thread safety, this method should be invoked from the event-dispatching thread.)
	private void createGUI() {
		
		// Create the upper panel (input components).
		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		upperPanel.add(promptLabel);
		upperPanel.add(guessTextField);
		upperPanel.add(tryButton);

		// Create the middle panel (info messages).
		JPanel middlePanel = new JPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		middlePanel.add(infoLabel);
		infoLabel.setFont(new Font("Arial", Font.BOLD, 18));
		infoLabel.setForeground(Color.ORANGE);

		// Create the lower panel ("new game" button).
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		lowerPanel.add(newGameButton);
		
		// Create a main panel to contain the 3 panels created above.
		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridLayout(3, 0, 20, 20));
		contentPane.add(upperPanel);
		contentPane.add(middlePanel);
		contentPane.add(lowerPanel);
		this.setContentPane(contentPane);        
		
		// Handle button clicks.
		tryButton.addActionListener(this);
		newGameButton.addActionListener(this);

		// Start a new game, to get the ball rolling.
		doNewGame();
	}        
	

	// Handle button clicks.
	public void actionPerformed(ActionEvent evt) {

		Object source = evt.getSource();
		
		if (source == newGameButton) {
			doNewGame();
		}
		else if (source == tryButton) {
			doTry();
		}
	}
	
	
	// Start a new game.
	private void doNewGame() {
		count = 0;
		target = (int) (Math.random() * upperLimit) + 1;
		infoLabel.setText("Guess a number between 1 and " + upperLimit + " (inclusive)");
		guessTextField.setText("");
	}
	
	
	// Try a number.
	private void doTry() {
		
		count++;
		int guess = Integer.parseInt(guessTextField.getText());
		
		if (guess > target) {
			infoLabel.setText("Lower!"); 
		}
		else if (guess < target) {
			infoLabel.setText("Higher!"); 
		}
		else {
			infoLabel.setText("Correct! You took " + count + " guesses.");
		}
	}
}