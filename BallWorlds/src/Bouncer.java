import java.awt.Color;

import util.Random;

/**
 * 
 * Bouncer starts in center of world with a random initial velocity and
 * direction. Bouncer changes direction when the "walls" of the world have been
 * reached. Bouncer has a "mass" for optional use with Gravity Ball objects.
 * (See code for Gravity Ball class).
 *
 * @author eckelsjd. Created Oct 15, 2018.
 */
public class Bouncer extends AbstractBouncer {
	private Color color = Color.YELLOW;
	private int dia = Random.randRange(20, 50);
	private BallWorld world;
	protected double mass = 25 * Math.pow(10, 31);

	public Bouncer(BallEnvironment world) {
		super(world);
		this.world = (BallWorld) world;
		this.world.getBouncerBalls().add(this);
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

}
