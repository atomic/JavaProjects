import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JComponent;


public class triangleComponent extends JComponent {
	
	private ArrayList<Point> myPoints;
	
	boolean fullDraw;
	
	public triangleComponent() {
		myPoints = new ArrayList<>();
	}

	public void addPoint(int x, int y) {
		if(myPoints.size() < 3)
			myPoints.add(new Point(x,y));
		else
			myPoints.clear();
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		if(myPoints.size() == 1)
			g.drawLine(myPoints.get(0).x,myPoints.get(0).y ,
					   myPoints.get(0).x,myPoints.get(0).y );
		else if(myPoints.size() == 2) {
			g.drawLine(myPoints.get(0).x,myPoints.get(0).y ,
					   myPoints.get(1).x,myPoints.get(1).y );
		}
		else if(myPoints.size() == 3) {
			g.drawLine(myPoints.get(0).x,myPoints.get(0).y ,
					   myPoints.get(1).x,myPoints.get(1).y );
			g.drawLine(myPoints.get(1).x,myPoints.get(1).y ,
					   myPoints.get(2).x,myPoints.get(2).y );
			g.drawLine(myPoints.get(2).x,myPoints.get(2).y ,
					   myPoints.get(0).x,myPoints.get(0).y );
		}

	}
}
