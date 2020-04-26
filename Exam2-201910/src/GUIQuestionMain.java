import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIQuestionMain {
	
	private ArrayList<JButton> buttons;
	protected int maxSum;
	protected JLabel label;

	public GUIQuestionMain() {
		this.buttons = new ArrayList<JButton>();
		this.maxSum = 6;
		this.label = new JLabel("Current Max: " + this.maxSum);
	}

	public void displayWindow() {
		JFrame frame = new JFrame();

		//note: if you need to convert a int to a string, you can do it like this
		//String someString = Integer.toString(someInt);
		//if you need to convert a string to an int, you can do it like this
		//int x = Integer.parseInt("2");
		
		frame.add(label, BorderLayout.NORTH);
		
		JPanel numberPanel = new JPanel();
		JPanel increasePanel = new JPanel();
		
		JButton button1 = new JButton("0");
		JButton button2 = new JButton("0");
		JButton button3 = new JButton("0");
		JButton button4 = new JButton("0");
		
		this.buttons.add(button1);
		this.buttons.add(button2);
		this.buttons.add(button3);
		this.buttons.add(button4);
		
		numberPanel.add(button1);
		numberPanel.add(button2);
		numberPanel.add(button3);
		numberPanel.add(button4);
		
		class ButtonListener implements ActionListener {
			
			private JButton button;
			private int value;
			private ArrayList<JButton> buttons;
			
			public ButtonListener(JButton button, ArrayList<JButton> buttons) {
				this.button = button;
				this.value = Integer.parseInt(this.button.getText());
				this.buttons = buttons;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if (this.checkMax()) {
					this.value++;
					String newText = Integer.toString(this.value);
					this.button.setText(newText);
				}
			}
			
			public boolean checkMax() {
				int sum = 0;
				for (JButton button : this.buttons) {
					int nextInt = Integer.parseInt(button.getText());
					sum += nextInt;
				}
				if (sum >= GUIQuestionMain.this.maxSum) {
					return false;
				}
				return true;
			}
		}
		
		button1.addActionListener(new ButtonListener(button1, this.buttons));
		button2.addActionListener(new ButtonListener(button2, this.buttons));
		button3.addActionListener(new ButtonListener(button3, this.buttons));
		button4.addActionListener(new ButtonListener(button4, this.buttons));
		
		JButton increase = new JButton("Increase Max");
		increasePanel.add(increase);
		
		class MaxListener implements ActionListener {
		
			public MaxListener() {
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				GUIQuestionMain.this.maxSum++;
				GUIQuestionMain.this.label.setText("Current Max: " + GUIQuestionMain.this.maxSum);
			}
		}
		
		increase.addActionListener(new MaxListener());
		
		frame.add(increasePanel, BorderLayout.SOUTH);
		frame.add(numberPanel, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		GUIQuestionMain r = new GUIQuestionMain();
		r.displayWindow();
	}
}
