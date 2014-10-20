import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class mainFrame {

	public static void main(String[] args) {
		
		
		
		
		JFrame frame = new JFrame();
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 100;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("This is a default frame declare on main");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JButton button = new JButton("Click me!");
		JLabel label = new JLabel("Hello, World!");
		panel.add(button);
		panel.add(label);
		frame.add(panel);
		frame.setVisible(true);
		
		
		
		// get screen size 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		
		JFrame myCostumFrame = new FilledFrame();
		frame.setTitle("This is costum Frame with specific class");
		myCostumFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myCostumFrame.setLocation( (int)(width/2), (int)(height/2)); //set default pos to middle of the screen
		myCostumFrame.setVisible(true);
	}

}
