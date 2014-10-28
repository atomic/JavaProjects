import javax.swing.JFrame;


public class ColorFrame extends JFrame {
	
	
	private ComboPanel myColorPanel;
	
	public ColorFrame() {
		initilalize();
	}

	void initilalize() {
		myColorPanel = new ComboPanel();
		add(myColorPanel);
	}
}
