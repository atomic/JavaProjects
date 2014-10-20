import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.lang.model.type.IntersectionType;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FilledFrame extends JFrame{

	private ArrayList<JButton> frameButtons;
	private ArrayList<JPanel> framePanels;
	private JLabel label;
	private JButton interestButton;
	private JTextField rateField;

	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 300;

	public static void main(String[] args) {
		JFrame myFrame = new FilledFrame();
		myFrame.setTitle("Calling main inside frame");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);

	}
	
	public FilledFrame()
	{
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private void createComponents()
	{
		frameButtons = new ArrayList<>();
		frameButtons.add(new JButton("Click me!"));
		frameButtons.add(new JButton("Don't click me!"));
		frameButtons.add(new JButton("Wow, this is different!"));
		
		
		ActionListener clickListener = new ClickListener();

		framePanels = new ArrayList<>();
		framePanels.add(new JPanel()); // add top bar
		label = new JLabel("Hello, World!");
		

		for (JButton jButton : frameButtons) {
			jButton.addActionListener(clickListener);
			framePanels.get(0).add(jButton);
		}

		framePanels.add(new JPanel()); // add second bar
		framePanels.get(1).add(label);
		
		framePanels.add(new JPanel()); // add panel for text field and button
		rateField = new JTextField();
		interestButton = new JButton();
		interestButton.addActionListener(new AddInterestListener());
		framePanels.get(2).add(rateField);
		framePanels.get(2).add(interestButton);

		JPanel mainPanel = new JPanel();
		for (JPanel panel : framePanels)
			mainPanel.add(panel);
		
		

		add(mainPanel);
	}
	
	/**
	An action listener that prints a message.
	 */
	public class ClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			label.setText("That's what she said");
		}
	}
	
	class AddInterestListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			double rate = Double.parseDouble(rateField.getText());
			double interest = balance * rate / 100;
			balance = balance + interest;
			resultLabel.setText("Balance: " + balance);
		}
	}


}