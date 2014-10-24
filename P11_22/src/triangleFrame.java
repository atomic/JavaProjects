import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author Tony LIm
 * frame that serves as a canvas to draw Triangle
 *
 */
public class triangleFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
	private triangleComponent triangle;
	
	class MousePressListener implements MouseListener
	{
		public void mousePressed(MouseEvent event)
		{
			int x = event.getX();
			int y = event.getY();
			triangle.addPoint(x, y);
		}
		// Do-nothing methods
		public void mouseReleased(MouseEvent event) {}
		public void mouseClicked(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
	}


	public triangleFrame()
	{
		triangle = new triangleComponent();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(triangle, BorderLayout.CENTER);
		
		MouseListener listener = new MousePressListener();
		panel.addMouseListener(listener);
		
		add(panel);
	}

}
