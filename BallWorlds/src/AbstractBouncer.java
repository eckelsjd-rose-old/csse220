import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

/**
 * A ball that bounces off the walls.
 * 
 * @author Curt Clifton. Created Jan 22, 2011.
 */
public abstract class AbstractBouncer extends Ball {
	protected int velocity = Random.randRange(100, 300); // velocity = 100
															// pixels
	// to 300 pixels per
	// second
	protected double angle = Random.randInterval(0, 2 * Math.PI);
	protected double vx = this.velocity * Math.cos(this.angle);
	protected double vy = this.velocity * Math.sin(this.angle);
	protected int dia = Random.randRange(20, 50);
	private BallEnvironment world;
	private double worldWidth;
	private double worldHeight;

	/**
	 * Constructs a abstract bouncer in the given world.
	 * 
	 * @param world
	 */

	public AbstractBouncer(BallEnvironment world) {
		super(world, new Point2D.Double(world.getCenterPoint().getX(), world.getCenterPoint().getY()));
		this.world = world;
		this.worldWidth = world.getSize().getWidth();
		this.worldHeight = world.getSize().getHeight();
	}

	public AbstractBouncer(BallEnvironment world, Point2D center) {
		super(world, center);
		this.world = world;
		this.worldWidth = world.getSize().getWidth();
		this.worldHeight = world.getSize().getHeight();
	}

	@Override
	public void updatePosition() {
		double dt = 0.01; // change in time is .01 s; this will run 100 times in
							// the duration of 1 second (10 ms * 100 = 1 second)
		double dx = this.vx * dt;
		double dy = this.vy * dt;
		double newX = this.getCenterPoint().getX() + dx;
		double newY = this.getCenterPoint().getY() + dy;
		this.setCenterPoint(new Point2D.Double(newX, newY));
		if (newX < 0 || newX > worldWidth || newY < 0 || newY > worldHeight) {
			this.changeDirection(newX, newY);
		}
	}

	public void changeDirection(double x, double y) {
		if (x < 0 || x > this.worldWidth) {
			this.vx = this.vx * (-1);
		}
		if (y < 0 || y > this.worldHeight) {
			this.vy = this.vy * (-1);
		}
	}

	@Override
	public void updateColor() {
		return;

	}

	@Override
	public abstract double getDiameter();

	@Override
	public abstract void updateSize();

	@Override
	public abstract Color getColor();
}
