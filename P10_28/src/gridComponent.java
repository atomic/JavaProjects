import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;


public class gridComponent extends JComponent {

	private final int screen_width = 500;
	private final int screen_height = 500;
	
	private int n; //number of grids


	public gridComponent(int num) {
		n = num;
	}

	public void changeGrid(int num) {
		n = num;
		repaint();
	}

	public void paintComponent(Graphics g) {
		
		//graphics2d allow stroke width
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10.0f));

		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n; j++) {
				g2.drawRect(getXposAt(i), getYposAt(j), screen_width/n, screen_height/n);
			}
		}
	}

	public int getXposAt(int i) {
		return screen_width/n * i;
	}

	public int getYposAt(int j) {
		return screen_width/n * j;
	}
}
