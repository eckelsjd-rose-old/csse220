import java.util.ArrayList;

public class Grid {
	
	protected ArrayList<Ball> balls = new ArrayList<>();

	public Grid() {
		for(int row = 0; row < 20; row++) {
			for(int col = 0; col < 20; col++) {
				if (Math.random() < 0.25) {
					this.balls.add(new Ball(col*30, row*30));
				}
				if (Math.random() < 0.25) {
					this.balls.add(new ColorChangingBall(col*30, row*30));
				}
				if (Math.random() < 0.25) {
					this.balls.add(new AnimatedBall(col*30, row*30));
				}
			}
		}
	}

}
