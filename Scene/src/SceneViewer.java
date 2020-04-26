import javax.swing.JFrame;

public class SceneViewer {
	/**
	 * Constructs and displays the JFrame which displays the full scene, via a
	 * SceneComponent.
	 * 
	 * @param args
	 *            Command-line arguments, ignored here.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub.
		JFrame frame = new JFrame();
		frame.setSize(750, 600);
		frame.setTitle("Scene Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new SceneComponent());
	}
}
