import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ball implements MouseListener {

	private int x;
	private int y;
	protected Color color;
	private static final int SIZE = 30;
	private BallComponent comp;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		this.color = Color.BLUE;
	}

	public void drawOn(Graphics2D g2) {
		g2.setColor(this.color);
		g2.fillOval(this.x, this.y, SIZE, SIZE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		checkClickOverlap(e.getX(), e.getY());
	}
	
	public boolean checkClickOverlap(int xClick, int yClick) {
		if (xClick >= this.x && xClick <= (this.x + SIZE) && yClick >= this.y && yClick <= (this.y + SIZE)) {
			System.out.println("Clicked: " + this.y / SIZE + " " + this.x / SIZE);
			return true;
		}
		return false;
	}
	
	// probably could've made this an abstract class, then made this method abstract. But this
	// works for the problem description
	public void updateColor() {
		// Do nothing
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// nothing
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// nothing
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// nothing

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// nothing
	}

}
