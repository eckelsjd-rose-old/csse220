package linearLightsOut;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Runs the Linear Lights Out application.
 * 
 * @author Joshua Eckels. Created October 7, 2018
 */
public class LinearMain {

	private JFrame myFrame;
	private JFrame winFrame = new JFrame("You Won!");
	private Random rand;
	private int nButtons;
	private ArrayList<JButton> myButtons;
	private ArrayList<String> buttonValues;

	/**
	 * Iterates through all the button objects and stores an ArrayList of all of
	 * the values of the buttons (X or O).
	 * 
	 */

	public void setButtonValues() {
		ArrayList<String> buttonValues = new ArrayList<>();
		for (int i = 0; i < nButtons; i++) {
			JButton currentButton = this.myButtons.get(i);
			buttonValues.add(currentButton.getText());
		}
		this.buttonValues = buttonValues;
	}

	/**
	 * 
	 * Recursively check if a win condition has been met (all O's or all X's).
	 * If win condition is achieved, create and display a new JFrame. Win
	 * condition is not achieved if game starts in a winning position at random.
	 *
	 * @return boolean (true if win condition is met; false otherwise)
	 */
	public boolean checkWin() {
		if (buttonValues.size() < 2) {
			JLabel winLabel = new JLabel("Congratulations!!");
			this.winFrame.add(winLabel, BorderLayout.CENTER);
			this.winFrame.setSize(300, 100);
			this.winFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.winFrame.setVisible(true);
			return true;
		}

		if (buttonValues.get(0).equals(buttonValues.get(1))) {
			buttonValues.remove(0);
		} else {
			return false;
		}
		return checkWin();
	}

	/**
	 * 
	 * LinearMain constructs a JFrame, a gamePanel, and a controlPanel. Game
	 * buttons are created and added onto gamePanel; New Game and Quit buttons
	 * are created and added to controlPanel. Both Panels are added to the
	 * JFrame.
	 *
	 */
	public LinearMain() {
		String nButtonsString = JOptionPane.showInputDialog("How many buttons would you like?");
		this.nButtons = Integer.parseInt(nButtonsString);
		this.myFrame = new JFrame("Linear Lights Out!");
		this.rand = new Random();
		this.myButtons = new ArrayList<>();
		this.buttonValues = new ArrayList<>();

		JPanel gamePanel = new JPanel();
		JPanel controlPanel = new JPanel();

		/**
		 * 
		 * Inner Class "ButtonListener" takes in 3 buttons: a center button, and
		 * the left and right adjacent buttons. ButtonListener updates the value
		 * of each of the 3 buttons based on the action of the center button.
		 *
		 * @author eckelsjd. Created Oct 8, 2018.
		 */
		class ButtonListener implements ActionListener {
			private JButton currentButton;
			private JButton leftButton;
			private JButton rightButton;

			public ButtonListener(JButton left, JButton current, JButton right) {
				this.currentButton = current;
				this.leftButton = left;
				this.rightButton = right;
			}

			/**
			 * 
			 * Takes in a JButton and sets its text to the opposite value (X, if
			 * current text is O; vice versa)
			 *
			 * @param JButton
			 *            b
			 */
			public void changeValue(JButton b) {
				if (b.getText().equals("X")) {
					b.setText("O");
				} else {
					b.setText("X");
				}
			}

			/**
			 * Changes the value of the center button and the two adjacent
			 * buttons when center button is pressed. Checks win condition for
			 * each button press.
			 */
			public void actionPerformed(ActionEvent e) {
				this.changeValue(this.currentButton);
				this.changeValue(this.leftButton);
				this.changeValue(this.rightButton);
				LinearMain.this.setButtonValues();
				if (LinearMain.this.checkWin()) {
					System.out.println("Victory!");
				} else {
					System.out.println("In progress. . ");
				}
			}
		}

		// Create nButtons buttons. Randomize the text on each button.
		for (int i = 0; i < this.nButtons; i++) {
			JButton button = new JButton();

			if (this.rand.nextBoolean()) {
				button.setText("X");
				this.myButtons.add(button);
				this.buttonValues.add("X");
			} else {
				button.setText("O");
				this.myButtons.add(button);
				this.buttonValues.add("O");
			}
			gamePanel.add(button);
		}

		// Defines a current button and 2 adjacent buttons. Adds a
		// ButtonListener to each button based on center,right, and left
		// buttons.
		for (int i = 0; i < this.nButtons; i++) {
			JButton currentButton = this.myButtons.get(i);
			JButton leftButton = new JButton();
			JButton rightButton = new JButton();
			String currentValue = this.buttonValues.get(i);
			if (i > 0) {
				leftButton = this.myButtons.get(i - 1);
				String leftValue = this.buttonValues.get(i - 1);
			}
			if (i < this.nButtons - 1) {
				rightButton = this.myButtons.get(i + 1);
				String rightValue = this.buttonValues.get(i + 1);
			}
			currentButton.addActionListener(new ButtonListener(leftButton, currentButton, rightButton));
		}

		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LinearMain.this.myFrame.dispose();
				LinearMain.this.winFrame.dispose();
			}
		});
		controlPanel.add(quitButton);

		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < LinearMain.this.nButtons; i++) {
					JButton b = LinearMain.this.myButtons.get(i);
					if (rand.nextBoolean()) {
						b.setText("X");
					} else {
						b.setText("O");
					}
				}
				LinearMain.this.winFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				LinearMain.this.winFrame.dispose();
			}
		});
		controlPanel.add(newGameButton, BorderLayout.LINE_START);

		this.myFrame.add(controlPanel, BorderLayout.SOUTH);
		this.myFrame.add(gamePanel, BorderLayout.CENTER);
		this.myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.myFrame.pack();
		this.myFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new LinearMain();
	}
}
