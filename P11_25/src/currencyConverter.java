import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.UIManager;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;


public class currencyConverter {

	private JFrame frame;
	private JTextField txtAmount;
	private final Action action = new SwingAction();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					currencyConverter window = new currencyConverter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public currencyConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 190, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(28, 27, 117, 24);
		txtAmount.setText("Amount");
		txtAmount.setColumns(10);
		frame.getContentPane().add(txtAmount);
		
		JLabel lblConvertedValue = new JLabel("Converted Value");
		lblConvertedValue.setBounds(28, 193, 117, 31);
		lblConvertedValue.setForeground(UIManager.getColor("Button.foreground"));
		frame.getContentPane().add(lblConvertedValue);
		
		JComboBox fromComboBox = new JComboBox();
		fromComboBox.setBounds(28, 72, 114, 24);
		fromComboBox.setFont(new Font("Consolas", Font.BOLD, 12));
		fromComboBox.setToolTipText("From");
		fromComboBox.addItem("USD");
		fromComboBox.addItem("EUR");
		fromComboBox.addItem("GBP");
		frame.getContentPane().add(fromComboBox);
		
		JComboBox toComboBox = new JComboBox();
		toComboBox.setBounds(28, 108, 114, 24);
		toComboBox.setFont(new Font("Consolas", Font.BOLD, 12));
		fromComboBox.setToolTipText("To");
		toComboBox.addItem("USD");
		toComboBox.addItem("EUR");
		toComboBox.addItem("GBP");
		frame.getContentPane().add(toComboBox);

		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Double value = Double.parseDouble(txtAmount.getText());
					lblConvertedValue.setText( (Double.toString(
							convertCurrency( 
									(String) fromComboBox.getSelectedItem()
									,(String) toComboBox.getSelectedItem()
									, value)))
							);
				} catch (Exception e2) {
					lblConvertedValue.setText("ERROR!");
				}

			}
		});
		btnConvert.setAction(action);
		btnConvert.setBounds(28, 150, 117, 31);
		frame.getContentPane().add(btnConvert);
		
	}

	
	
	/**
	 * Core functions
	 */
	private double convertCurrency(String from, String to, double value) {

		if(from.equals("USD")) {
			if(to.equals("EUR"))
				return value/1.42;
			else if(to.equals("GBP"))
				return value/1.64;
		}
			
		if(from.equals("EUR")) {
			if(to.equals("USD"))
				return value*1.42;
			else if(to.equals("GBP"))
				return value/1.13;
		}
			
		if(from.equals("GBP")) {
			if(to.equals("USD"))
				return value*1.62;
			else if(to.equals("EUR"))
				return value*1.13;
		}
		
		return value; // if its equal to itself
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
