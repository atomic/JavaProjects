import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class rectangleFrame extends JFrame {

	private static final int FRAME_WIDTH    = 700;
	private static final int FRAME_HEIGHT   = 600;

	private static final int CANVAS_HEIGHT  = 500;
	private static final int CANVAS_WIDTH   = 500;

	private   JLabel                rectangleNumberLabel;
	private   JTextField            rectangleNumberField;
	private   JButton               buttonToDraw;

	private   JPanel                panel;
	private   rectangleComponents   myCanvas;
	
	
	public rectangleFrame() {
		setTitle("Random Rectangles Generator");
		setSize(FRAME_WIDTH,FRAME_HEIGHT);	
		
		// allocating data for components
		rectangleNumberField = new JTextField(7); // with of 7 by default
		rectangleNumberLabel = new JLabel("Number of Rectangle : ");
		
		
		myCanvas = new rectangleComponents(1);
		myCanvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

		createButton();
		createPanel();
	}
	

	class redrawListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			myCanvas.changeRectangle(Integer.parseInt(rectangleNumberField.getText()));
		}
	}

	private void createButton() {
		buttonToDraw = new JButton("Draw");
		ActionListener triggerDrawing = new redrawListener();
		buttonToDraw.addActionListener(triggerDrawing);
	}

	private void createPanel() {
		panel = new JPanel();
		panel.add(rectangleNumberLabel);
		panel.add(rectangleNumberField);
		panel.add(buttonToDraw);
		panel.add(myCanvas);


		add(panel);
	}
	
}
