import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JComponent;



public class rectangleComponents extends JComponent{
	
	private final int HEIGHT = 10;
	private final int WIDTH = 20;
	
	private final int screen_width = 500;
	private final int screen_height = 500;
	
	private int numberOfRectangle;


	public rectangleComponents(int num) {
		numberOfRectangle = num;
	}

	public void changeRectangle(int num) {
		numberOfRectangle = num;
		repaint();
	}

	public void paintComponent(Graphics g) {
		
		//graphics2d allow stroke width
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10.0f));

		int randomXpos;
		int randomYpos;
		for (int i = 0; i < numberOfRectangle; i++) {
			randomXpos = randInt(0, screen_width - WIDTH);
			randomYpos = randInt(0, screen_height - HEIGHT);
			g2.drawRect(randomXpos, randomYpos, WIDTH, HEIGHT);
		}
	}

	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 */
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

}
