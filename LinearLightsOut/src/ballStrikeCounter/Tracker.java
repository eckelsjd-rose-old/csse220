package ballStrikeCounter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Tracker class creates a JFrame with a label that displays balls and strikes, and two buttons to increment the 
 * number of balls and strikes.
 *
 * @author eckelsjd.
 *         Created Oct 8, 2018.
 */
public class Tracker {
	private JLabel label = new JLabel();
	private int ballCount = 0;
	private int strikeCount = 0;

	// Call this to update the text on the label.
	public void updateLabel(int numBalls, int numStrikes) {
		this.label.setText("<html>Balls: " + numBalls + "<br />Strikes: " + numStrikes + "</HTML>");
	}

	public static void main(String[] args) {
		new Tracker();
	}

	public Tracker() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		frame.add(label, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		
		JButton ball = new JButton("Add Ball");
		JButton strike = new JButton("Add Strike");
		ball.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Tracker.this.ballCount < 3) {
					Tracker.this.ballCount++;
					Tracker.this.updateLabel(Tracker.this.ballCount, Tracker.this.strikeCount);
				}
				else {
					Tracker.this.ballCount = 0;
					Tracker.this.strikeCount = 0;
					Tracker.this.updateLabel(Tracker.this.ballCount, Tracker.this.strikeCount);
				}
			}
		});
		strike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Tracker.this.strikeCount < 2) {
					Tracker.this.strikeCount++;
					Tracker.this.updateLabel(Tracker.this.ballCount, Tracker.this.strikeCount);
				}
				else {
					Tracker.this.ballCount = 0;
					Tracker.this.strikeCount = 0;
					Tracker.this.updateLabel(Tracker.this.ballCount, Tracker.this.strikeCount);
				}
			}
		});
		
		panel.add(ball);
		panel.add(strike);

		// The following line is given to show you how to use the given method:
		updateLabel(0, 0);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
