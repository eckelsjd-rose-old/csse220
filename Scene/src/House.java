import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 * Draws a rectangular house with triangular roof on to a graphics object.
 *
 * @author eckelsjd. Created Sep 18, 2018.
 */
public class House {
	private static final int HEIGHT = 50;
	private static final int WIDTH = 100;
	private static final int ROOF_HEIGHT = 20;
	private int cornerX;
	private int cornerY;

	private Color color;

	public House(int x, int y, Color color) {
		// TODO: save off the parameters into instance variables
		this.cornerX = x;
		this.cornerY = y;
		this.color = color;
	}

	public void drawOn(Graphics2D g2) {
		// TODO: Draw the house body (a rectangle) and the roof (3 lines or a
		// Polygon)
		g2.setColor(this.color);
		Rectangle box = new Rectangle(this.cornerX, this.cornerY, this.WIDTH, this.HEIGHT);
		g2.fill(box);
		g2.draw(box);
		Point topRoof = new Point(this.cornerX + this.WIDTH / 2, this.cornerY - this.ROOF_HEIGHT);
		g2.drawLine(this.cornerX, this.cornerY, topRoof.x, topRoof.y);
		g2.drawLine(topRoof.x, topRoof.y, this.cornerX + this.WIDTH, this.cornerY);
	}

}
