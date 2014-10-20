import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
A frame that shows the growth of an investment with variable interest.
 */
public class InvestmentFrame2 extends JFrame
{
	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 400;
	
	private static final int AREA_ROWS = 15;
	private static final int AREA_COLUMNS = 30;

	private static final double DEFAULT_RATE = 5;
	private static final double INITIAL_BALANCE = 1000;

	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private JLabel resultLabel;
	private JTextArea resultArea;
	private double balance;
	
	private JPanel panel;

	public static void main(String[] args)
	{
		JFrame frame = new InvestmentFrame2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public InvestmentFrame2()
	{
		balance = INITIAL_BALANCE;
		
		resultLabel = new JLabel("Balance: " + balance);
		resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		
		resultArea.setText(balance + "\n");
		resultArea.setEditable(false);

		createTextField();
		createButton();
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private void createTextField()
	{
		rateLabel = new JLabel("Interest Rate: ");
		final int FIELD_WIDTH = 10;
		rateField = new JTextField(FIELD_WIDTH);
		rateField.setText("" + DEFAULT_RATE);
	}
	
	/**
		Adds interest to the balance and updates the display.
	 */
	class AddInterestListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			double rate = Double.parseDouble(rateField.getText());
			double interest = balance * rate / 100;
			balance = balance + interest;
			resultLabel.setText("Balance: " + balance);
			resultArea.append(balance + "\n");
		}
	}
	
	private void createButton()
	{
		button = new JButton("Add Interest");
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
	}
	
	private void createPanel()
	{
		panel = new JPanel();
		panel.add(rateLabel);
		panel.add(rateField);
		panel.add(button);
		panel.add(resultLabel);

		// this create scrollable area 
		JScrollPane scrollPane = new JScrollPane(resultArea);
		panel.add(scrollPane); // this adds both the texts field and the scroll

		add(panel);
	}
}