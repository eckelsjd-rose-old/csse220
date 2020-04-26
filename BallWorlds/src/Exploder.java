import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

/**
 * 
 * Exploder starts in center of world with a random initial velocity and
 * direction. Exploder grows to a certain size, and then "explodes" by deleting
 * itself and creating two new exploders in the same location.
 *
 * @author eckelsjd. Created Oct 15, 2018.
 */
public class Exploder extends AbstractBouncer {
	private Color color = Color.MAGENTA;
	private double startDia = Random.randRange(5, 15);
	private double currentDia = startDia;
	private double finalDia = Random.randInterval(2 * this.startDia, 10 * this.startDia);
	private BallEnvironment world;

	public Exploder(BallEnvironment world) {
		super(world);
		this.world = world;
	}

	public Exploder(BallEnvironment world, Point2D center) {
		super(world, center);
		this.world = world;
		this.world.addBall(this);
	}

	@Override
	public double getDiameter() {
		return this.currentDia;
	}

	@Override
	public void updateSize() {
		this.currentDia = this.currentDia + 0.1;
		if (this.currentDia >= this.finalDia) {
			Point2D finalCenter = this.getCenterPoint();
			Exploder new1 = new Exploder(this.world, finalCenter);
			Exploder new2 = new Exploder(this.world, finalCenter);
			this.die();
		}

	}

	@Override
	public Color getColor() {
		return this.color;
	}

}
