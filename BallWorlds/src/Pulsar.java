import java.awt.Color;
import java.awt.geom.Point2D;

import util.Random;

/**
 * 
 * Pulsar picks random location and pulses color between black and white. Stored
 * in its BallWorld for use by the Gravity Ball. (Pulsar acts as a black hole
 * for Gravity balls).
 *
 * @author eckelsjd. Created Oct 15, 2018.
 */
public class Pulsar extends Ball {
	private int indexColor;
	private Color currentColor;
	private int dia = Random.randRange(20, 40);
	private boolean isIncreasing = false;
	private BallWorld world;
	protected double mass = 25 * Math.pow(10, 30); // mass is used for Gravity
													// ball

	public Pulsar(BallEnvironment world) {
		super(world, new Point2D.Double(Random.randRange(0, world.getSize().width),
				Random.randRange(0, world.getSize().height)));
		indexColor = 255;
		currentColor = new Color(indexColor, indexColor, indexColor);
		this.world = (BallWorld) world;
		this.world.getPulsarBalls().add(this);
	}

	public Pulsar(BallEnvironment world, Point2D centerPoint) {
		super(world, centerPoint);
		indexColor = 255;
		currentColor = new Color(indexColor, indexColor, indexColor);
		this.world = (BallWorld) world;
		this.world.getPulsarBalls().add(this);
	}

	@Override
	public Color getColor() {
		return currentColor;
	}

	@Override
	public void updatePosition() {
		return;

	}

	@Override
	public void updateSize() {
		return;

	}

	@Override
	public void updateColor() {
		if (isIncreasing) {
			currentColor = new Color(indexColor, indexColor, indexColor);
			indexColor = indexColor + 2;
			if (indexColor > 252) {
				isIncreasing = false;
			}
		} else {
			currentColor = new Color(indexColor, indexColor, indexColor);
			indexColor = indexColor - 2;
			if (indexColor < 2) {
				isIncreasing = true;
			}
		}
	}

	@Override
	public double getDiameter() {
		return this.dia;
	}

}
