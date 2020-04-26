import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

/**
 * 
 * Draws triangular pine trees with green branches and a brown trunk on to a
 * graphics area.
 *
 * @author eckelsjd. Created Sep 18, 2018.
 */
public class PineTree {

	private int x;
	private int y;
	private int width;
	private int height;
	private Color branchColor;
	private Color trunkColor;

	public PineTree(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.branchColor = new Color(40, 135, 22);
		this.trunkColor = new Color(145, 112, 33);
	}

	public void drawOn(Graphics2D g2) {
		g2.setColor(this.trunkColor);
		int trunkHeight = this.height / 3;
		int trunkWidth = this.width / 3;
		Point trunkCorner = new Point(this.x + trunkWidth, this.y + 2 * trunkHeight);
		Rectangle trunk = new Rectangle(trunkCorner.x, trunkCorner.y, trunkWidth, trunkHeight);
		g2.draw(trunk);
		g2.fill(trunk);

		g2.setColor(this.branchColor);
		Point branchLeft = new Point(this.x, trunkCorner.y);
		Point branchRight = new Point(this.x + this.width, trunkCorner.y);
		Point branchTop = new Point(this.x + this.width / 2, this.y);
		int[] polygonXs = { branchLeft.x, branchRight.x, branchTop.x };
		int[] polygonYs = { branchLeft.y, branchRight.y, branchTop.y };
		Polygon branches = new Polygon(polygonXs, polygonYs, 3);
		g2.draw(branches);
		g2.fill(branches);
	}
}
