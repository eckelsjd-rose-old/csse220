import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

/**
 * 
 * Mover starts in center of world with an initial velocity and direction. Mover
 * is removed from world when it hits the extents of the world.
 *
 * @author eckelsjd. Created Oct 15, 2018.
 */
public class Mover extends Ball {
	private int velocity = Random.randRange(100, 300); // velocity = 100 pixels
														// to 300 pixels per
														// second
	private double angle = Random.randInterval(0, 2 * Math.PI);
	private Color color = Color.GREEN;
	private int dia = Random.randRange(20, 50);
	private BallEnvironment world;
	private double worldWidth;
	private double worldHeight;

	public Mover(BallEnvironment world) {
		super(world, new Point2D.Double(world.getCenterPoint().getX(), world.getCenterPoint().getY()));
		this.world = world;
		this.worldWidth = world.getSize().getWidth();
		this.worldHeight = world.getSize().getHeight();
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void updatePosition() {
		double vx = this.velocity * Math.cos(this.angle);
		double vy = this.velocity * Math.sin(this.angle);
		double dt = 0.01; // change in time is .01 s; this will run 100 times in
							// the duration of 1 second (10 ms * 100 = 1 second)
		double dx = vx * dt;
		double dy = vy * dt;
		double newX = this.getCenterPoint().getX() + dx;
		double newY = this.getCenterPoint().getY() + dy;
		this.setCenterPoint(new Point2D.Double(newX, newY));
		if (newX < 0 || newX > worldWidth || newY < 0 || newY > worldHeight) {
			this.die();
		}
	}

	@Override
	public void updateSize() {
		return;

	}

	@Override
	public void updateColor() {
		return;

	}

	@Override
	public double getDiameter() {
		return this.dia;
	}

}
