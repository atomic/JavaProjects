/* Name : Tony Lim
 * Date : Oct 19, 2014
 * Assignment : P10.26
 * Description : Draw olympic rings
 */

import javax.swing.JComponent;
import javax.swing.JFrame;

public class olympicViewer extends JFrame {
	
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 550;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new olympicViewer();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public olympicViewer() {
		createComponents();
		createOlypicCircles();
	}
	
	private void createComponents(){
		setTitle("Olympic Rings with colors");
		setSize(FRAME_WIDTH,FRAME_HEIGHT);	
	}
	
	private void createOlypicCircles() {
		JComponent component = new olympicComponent();
		add(component);
	}

}
