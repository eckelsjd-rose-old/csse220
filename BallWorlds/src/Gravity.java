import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

/**
 * 
 * Gravity starts in center of the world with a random size, velocity, and
 * direction. Gravity ball object experiences a force from all Pulsar objects in
 * the current world, based on the "mass" of the object itself and each Pulsar,
 * as well as the distance from each pulsar object. If a Gravity ball gets too
 * close to a Pulsar, it is removed from the world (sucked into the black hole).
 *
 * @author eckelsjd. Created Oct 15, 2018.
 */
public class Gravity extends Ball {
	private Color color = Color.WHITE;
	protected double mass;
	private int dia = Random.randRange(20, 50);
	private double radius = this.dia / 2;
	private static final double gConstant = 0.0000000000667408; // Newton's
																// Gravitational
																// Constant G
	private static final double density = 0.0005968; // Arbitrary density used
														// for mass calculation
														// in the constructor.
	protected int velocity = Random.randRange(20, 100); // velocity = 100
														// pixels
	// to 300 pixels per
	// second
	private double angle = Random.randInterval(0, 2 * Math.PI);
	private double vx = this.velocity * Math.cos(this.angle);
	private double vy = this.velocity * Math.sin(this.angle);
	private BallWorld world;
	private double worldWidth;
	private double worldHeight;

	public Gravity(BallEnvironment world) {
		super(world, new Point2D.Double(world.getCenterPoint().getX(), world.getCenterPoint().getY()));
		this.world = (BallWorld) world;
		this.worldWidth = world.getSize().getWidth();
		this.worldHeight = world.getSize().getHeight();
		double volume = (4 / 3) * Math.PI * Math.pow(radius, 3); // Volume of a
																	// sphere,
																	// (pretend
																	// each
																	// Gravity
																	// Ball is a
																	// sphere
																	// with a
																	// volume
																	// and a
																	// mass.)
		this.mass = density * volume;
	}

	/**
	 * 
	 * Takes in the mass of two objects and the distance between them, and
	 * returns the force of gravity exerted by one mass on the other.
	 *
	 * @param m1
	 * @param m2
	 * @param r
	 * @return
	 */
	public double calculateForce(double m1, double m2, double r) {
		return (gConstant * m1 * m2) / (Math.pow(r * Math.pow(10, 9), 2));
	}

	@Override
	public double getDiameter() {
		return this.dia;
	}

	@Override
	public void updateSize() {
		return;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void updateColor() {
		return;
	}

	public void updatePosition() {
		this.updateVelocity();
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

	/**
	 * 
	 * Change the x and y velocities based on the force of gravity exerted on
	 * the Gravity Ball. Pulsar objects or Bouncer objects can be used as the
	 * "black holes"
	 *
	 */
	public void updateVelocity() {
		for (Pulsar ball : this.world.getPulsarBalls()) { // Optional : Change
															// Pulsar here to
															// Bouncer for
															// same gravity
															// effect, but on a
															// moving object.
			double distance = Point2D.distance(ball.getCenterPoint().getX(), ball.getCenterPoint().getY(),
					this.getCenterPoint().getX(), this.getCenterPoint().getY());
			if (distance < 5) {
				this.die();
			}
			double dy = Math.abs(ball.getCenterPoint().getY() - this.getCenterPoint().getY());
			double dx = Math.abs(ball.getCenterPoint().getX() - this.getCenterPoint().getX());
			double angleForce = Math.atan(dy / dx);
			double force = this.calculateForce(ball.mass, this.mass, distance);
			double Fx = force * Math.cos(angleForce);
			double Fy = force * Math.sin(angleForce);
			if (this.getCenterPoint().getX() < ball.getCenterPoint().getX()) {
				if (this.getCenterPoint().getY() < ball.getCenterPoint().getY()) {
					this.vx = this.vx + (Fx / this.mass);
					this.vy = this.vy + (Fy / this.mass);
				} else {
					this.vx = this.vx + (Fx / this.mass);
					this.vy = this.vy - (Fy / this.mass);
				}
			} else {
				if (this.getCenterPoint().getY() < ball.getCenterPoint().getY()) {
					this.vx = this.vx - (Fx / this.mass);
					this.vy = this.vy + (Fy / this.mass);
				} else {
					this.vx = this.vx - (Fx / this.mass);
					this.vy = this.vy - (Fy / this.mass);
				}
			}
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
}
