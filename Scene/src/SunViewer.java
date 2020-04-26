import javax.swing.JFrame;

public class SunViewer {

	/**
	 * Constructs and displays the JFrame which displays Suns via a Sun
	 * Component.
	 * 
	 * @param args
	 *            Command-line arguments, ignored here.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub.
		JFrame frame = new JFrame();
		frame.setSize(750, 600);
		frame.setTitle("Sun Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new SunComponent());
	}

}
