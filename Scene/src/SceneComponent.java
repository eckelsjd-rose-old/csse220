import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent;

/**
 * 
 * Draws Houses, a Sun, and PineTrees onto a colored graphics area via the
 * appropriate classes.
 *
 * @author eckelsjd. Created Sep 18, 2018.
 */
public class SceneComponent extends JComponent {

	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		Graphics2D g2 = (Graphics2D) graphics;

		g2.setColor(Color.BLUE);
		Rectangle sky = new Rectangle(0, 0, 750, 375);
		g2.draw(sky);
		g2.fill(sky);

		g2.setColor(Color.GREEN);
		Rectangle grass = new Rectangle(0, 375, 750, 225);
		g2.draw(grass);
		g2.fill(grass);

		Sun sun = new Sun();
		sun.drawOn(g2);

		int houseX = 100;
		for (int i = 0; i < 5; i++) {
			House house = new House(houseX, 475, Color.RED);
			house.drawOn(g2);
			houseX += 125;
		}

		Random rand = new Random();

		int littleTreeX = 100;
		int littleTreeY = 350;
		for (int i = 0; i < 25; i++) {
			PineTree littleTree = new PineTree(littleTreeX, littleTreeY, 10, 40);
			littleTree.drawOn(g2);
			littleTreeX += rand.nextInt((35 - 12) + 1) + 12;
		}

		int bigTreeX = 150;
		int bigTreeY = 360;
		for (int i = 0; i < 15; i++) {
			PineTree bigTree = new PineTree(bigTreeX, bigTreeY, 20, 80);
			bigTree.drawOn(g2);
			bigTreeX += rand.nextInt((45 - 22) + 1) + 22;
		}
	}

}
