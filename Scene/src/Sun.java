import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/**
 * 
 * Draws a Sun with a circular center and 8 rectangular rays equidistant around
 * the outside of the center circle. The Sun is defined the corner of a bounding
 * box, a diameter, and a color.
 *
 * @author eckelsjd. Created Sep 18, 2018.
 */
public class Sun {

	private static final Color BORDER_COLOR = Color.BLACK;
	private static final int NUMBER_OF_RAYS = 8;
	private static final double RAY_LENGTH_SCALE = 0.5;
	private static final double RAY_WIDTH_SCALE = 0.1;
	private static final double RAY_DISTANCE_FROM_SUN_SCALE = .2;
	private static final double DEFAULT_SUN_DIAMETER = 100.0;
	private static final double DEFAULT_SUN_X = 100.0;
	private static final double DEFAULT_SUN_Y = 100.0;
	private static final Color DEFAULT_SUN_COLOR = Color.YELLOW;
	private static final double LITTLE_SUNS_X_OFFSET = 50;

	private double x;
	private double y;
	private double circleDiameter;
	private double rayLength;
	private double rayWidth;
	private double rayDistanceFromSun;
	private Color color;
	private double height;
	private Point sunCorner;
	private Point sunCenter;

	/**
	 * 
	 * Constructs a Sun object with default values in a default location.
	 *
	 */
	public Sun() {
		this.x = this.DEFAULT_SUN_X;
		this.y = this.DEFAULT_SUN_Y;
		this.color = this.DEFAULT_SUN_COLOR;
		this.circleDiameter = this.DEFAULT_SUN_DIAMETER;
		this.rayDistanceFromSun = this.RAY_DISTANCE_FROM_SUN_SCALE * this.DEFAULT_SUN_DIAMETER;
		this.rayLength = this.RAY_LENGTH_SCALE * this.DEFAULT_SUN_DIAMETER;
		this.rayWidth = this.RAY_WIDTH_SCALE * this.DEFAULT_SUN_DIAMETER;
		this.height = 2 * (this.rayLength + this.rayDistanceFromSun) + this.circleDiameter;
		this.sunCorner = new Point((int) this.x, (int) this.y);
		this.sunCenter = new Point((int) (this.sunCorner.x + this.circleDiameter / 2),
				(int) (this.sunCorner.y + this.circleDiameter / 2));
	}

	/**
	 * 
	 * Constructs a Sun object with the given parameters.
	 *
	 * @param x
	 * @param y
	 * @param dia
	 * @param color
	 */
	public Sun(double x, double y, double dia, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.circleDiameter = dia;
		this.rayDistanceFromSun = this.RAY_DISTANCE_FROM_SUN_SCALE * dia;
		this.rayLength = this.RAY_LENGTH_SCALE * dia;
		this.rayWidth = this.RAY_WIDTH_SCALE * dia;
		this.height = 2 * (this.rayLength + this.rayDistanceFromSun) + this.circleDiameter;
		this.sunCorner = new Point((int) this.x, (int) this.y);
		this.sunCenter = new Point((int) (this.sunCorner.x + this.circleDiameter / 2),
				(int) (this.sunCorner.y + this.circleDiameter / 2));
	}

	/**
	 * 
	 * Draws the center circle of the sun on a graphics object. Draws 8 rays
	 * around the center circle.
	 *
	 * @param g2
	 */
	public void drawOn(Graphics2D g2) {
		g2.setColor(this.BORDER_COLOR);
		Ellipse2D center = new Ellipse2D.Double(this.sunCorner.x, this.sunCorner.y, this.circleDiameter,
				this.circleDiameter);
		// Rectangle bound = new Rectangle((int) this.x, (int) this.y, (int)
		// this.height, (int) this.height);
		// Rectangle sunBound = new Rectangle(this.sunCorner.x,this.sunCorner.y,
		// (int) this.circleDiameter, (int) this.circleDiameter);
		// g2.draw(sunBound);
		// g2.draw(bound);
		g2.draw(center);
		g2.setColor(this.color);
		g2.fill(center);
		this.drawRay(g2);
		for (int i = 0; i < this.NUMBER_OF_RAYS; i++) {
			this.drawRay(g2);
			g2.rotate((2 * Math.PI) / this.NUMBER_OF_RAYS, this.sunCenter.x, this.sunCenter.y);
		}

	}

	/**
	 * 
	 * Draws one rectangular ray near the center circle of the Sun.
	 *
	 * @param g2
	 */
	public void drawRay(Graphics2D g2) {
		Rectangle ray = new Rectangle((int) (this.sunCorner.x + this.circleDiameter / 2),
				(int) (this.sunCorner.y - this.rayDistanceFromSun - this.rayLength), (int) this.rayWidth,
				(int) this.rayLength);
		g2.setColor(this.BORDER_COLOR);
		g2.draw(ray);
		g2.setColor(this.color);
		g2.fill(ray);
	}
}
