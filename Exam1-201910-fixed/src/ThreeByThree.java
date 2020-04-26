import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;

public class ThreeByThree {

	private static final int SQUARE_WIDTH = 30;
	private int upperLeftX;
	private int upperLeftY;
	private Color color;
	private HashMap<Point, Color> store;
	private HashMap<Point, Color> source;

	/* feel free to modify this class and add fields and methods as you need */
	
	
	public ThreeByThree(int x, int y, Color color) {
		this.upperLeftX = x;
		this.upperLeftY = y;
		this.color = color;
		this.store = new HashMap<Point, Color>();
		this.source = new HashMap<Point,Color>();
	}
	
	public ThreeByThree() {
		this.upperLeftX = 0;
		this.upperLeftY = 0;
		this.color = Color.WHITE;
		this.store = new HashMap<Point, Color>();
		this.source = new HashMap<Point, Color>();
	}
	
	public void drawOn(Graphics2D g) {
		// some example code that draws one box
		for (int j=0;j<3;j++) {
			for (int i=0;i<3;i++) {
				Point currentBox = new Point(j, i);
				if (this.store.containsKey(currentBox)) {
					g.setColor(this.store.get(currentBox)); // see comments below for my attempt at a solution
					g.fillRect(this.upperLeftX, this.upperLeftY, SQUARE_WIDTH, SQUARE_WIDTH);
					g.setColor(Color.BLACK);
					g.drawRect(this.upperLeftX, this.upperLeftY, SQUARE_WIDTH, SQUARE_WIDTH);
					g.translate(30, 0);
					this.source.put(currentBox, this.store.get(currentBox));
				}
				else {
					g.setColor(this.color);
					g.fillRect(this.upperLeftX, this.upperLeftY, SQUARE_WIDTH, SQUARE_WIDTH);
					g.setColor(Color.BLACK);
					g.drawRect(this.upperLeftX, this.upperLeftY, SQUARE_WIDTH, SQUARE_WIDTH);
					g.translate(30, 0);
				}
			}
			g.translate(-90, 30);
		}
		g.translate(0, -90);
		
	}
	
	public void setCellColor(int r, int c, Color color) {
		Point location = new Point(r,c);
		this.store.put(location,color);
	}
	
	public ThreeByThree copyTo(int x, int y) {
		ThreeByThree copy = new ThreeByThree(x, y, this.color);
		for (Point point : this.source.keySet()) {
			copy.store.put(point, this.source.get(point));
		}
		
		return copy;
	}
		
}

// This class is not complete. My goal here in the setCellColor method was to store the row and column number in a hashmap as a point object, with 
// a value of the color. Then I would check in the draw on method if the currentbox was located at one of these hashmap 
// "points". If so, the graphics2D would switch to the appropriate color and draw the box as normal. If not, the draw on
// method would continue as normal with the default color.
