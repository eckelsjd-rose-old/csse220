import java.awt.Color;
import java.awt.event.MouseEvent;

public class ColorChangingBall extends Ball {
	
	private Color[] colors;
	private boolean isRed = false;

	public ColorChangingBall(int x, int y) {
		super(x, y);
		colors = new Color[2];
		colors[0] = Color.GREEN;
		colors[1] = Color.RED;
		this.color = colors[0];
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (checkClickOverlap(e.getX(), e.getY())) {
			this.color = (this.isRed) ? this.colors[0] : this.colors[1];
			this.isRed = (this.isRed) ? false : true;
		}
	}

}
