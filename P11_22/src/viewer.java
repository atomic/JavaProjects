import javax.swing.JFrame;

/*
 * Name : Tony LIm
 * Date : Oct 23, 2014
 * Assignment : P11.22
 * Description : Draw triangle
 */


public class viewer {

	public static void main(String[] args) {

		JFrame rectFrame = new triangleFrame();
		rectFrame.setSize(320, 440);
		rectFrame.setTitle("Draw triangle");
		rectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rectFrame.setVisible(true);

	}

}
