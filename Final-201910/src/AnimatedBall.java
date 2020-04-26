import java.awt.Color;
import java.awt.event.MouseEvent;

public class AnimatedBall extends Ball {
	
	private int indexColor = 0;
	private boolean shouldChangeColor = false;

	public AnimatedBall(int x, int y) {
		super(x, y);
		this.color = Color.BLACK;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (checkClickOverlap(e.getX(), e.getY())) {
			this.shouldChangeColor = true;
		}
	}
	
	@Override
	public void updateColor() {
		if (shouldChangeColor) {
			this.color = new Color(indexColor, indexColor, indexColor);
			indexColor += 1;
			if (indexColor > 250) {
				shouldChangeColor = false;
				indexColor = 0;
				this.color = Color.BLACK;
			}
		}
	}
}
