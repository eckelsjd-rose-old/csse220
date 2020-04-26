import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class PineTreesComponent extends JComponent {

	/**
	 * Draws some PineTrees on a graphics area.
	 * 
	 * @author eckelsjd
	 */
	protected void paintComponent(Graphics graphics) {
		// TODO Auto-generated constructor stub.
		super.paintComponent(graphics);
		Graphics2D g2 = (Graphics2D) graphics;

		PineTree tree = new PineTree(100, 100, 100, 200);
		tree.drawOn(g2);

		PineTree littleTree = new PineTree(300, 200, 50, 100);
		littleTree.drawOn(g2);
	}

}
