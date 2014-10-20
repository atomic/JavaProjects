import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;


public class olympicComponent extends JComponent {

	private static final int DIAMETER = 200;
	private static final int shellThickness = 20;
	private static final int Xpos = 30;
	private static final int Ypos = 30;


	public void paintComponent(Graphics g) {
		
		//Draw Top Circles first
		drawRing(g, Xpos, Ypos, Color.BLUE);
		drawRing(g, Xpos + DIAMETER + shellThickness/2, Ypos, Color.BLACK);
		drawRing(g, Xpos + 2*DIAMETER + shellThickness, Ypos, Color.RED);

		//Draw Bottom circle
		int newY = Ypos + DIAMETER/2;
		int newx = Ypos + DIAMETER/2;
		drawRing(g, newx, newY, Color.YELLOW);
		drawRing(g, newx + DIAMETER + shellThickness/2, newY, Color.GREEN);
		
	}
	
	private void drawRing(Graphics g, int x, int y, Color ringColor) {
		
		//graphics2d allow stroke width
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10.0f));
		g2.setColor(ringColor);
		g2.drawOval(x, y, DIAMETER, DIAMETER);
		
//		Color transParent = new Color(255,255,255,125);
//		g.setColor(transParent);
//		g.fillOval(x + shellThickness/2, y + shellThickness/2,
//				   DIAMETER - shellThickness, DIAMETER - shellThickness);

	}
}