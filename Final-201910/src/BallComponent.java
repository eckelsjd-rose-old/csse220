

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * A component that contains balls.
 * 
 * Modify this class as you need
 * 
 * 
 */
public class BallComponent extends JComponent {
	
	private Grid grid;

	public BallComponent() {
		// this generates a random number between 0 and 1
		double random = Math.random();
		this.grid = new Grid();
		for(Ball b : this.grid.balls) {
			this.addMouseListener(b);
		}
	}
	
	//This method should draw anything considered to be part of the Component
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for(int row = 0; row < 20; row++) {
			for(int col = 0; col < 20; col++) {
				g2.setColor(Color.LIGHT_GRAY);
				g2.drawRect(col*30, row*30, 30, 30);
			}
		}
		
		for (Ball b : this.grid.balls) {
			b.updateColor();
			b.drawOn(g2);
		}
		
	}
}
