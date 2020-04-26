import javax.swing.JFrame;

public class PineTreesViewer {

	/**
	 * Constructs and displays the JFrame which displays Pine Trees via a
	 * PineTreeComponent.
	 * 
	 * @param args
	 *            Command-line arguments, ignored here.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub.
		JFrame frame = new JFrame();
		frame.setSize(500, 400);
		frame.setTitle("Pine Tree Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new PineTreesComponent());
	}

}
