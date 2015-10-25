

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ComboPanel extends JPanel {
	

	private JComboBox<Integer> R;
	private JComboBox<Integer> G;
	private JComboBox<Integer> B;


	public ComboPanel() {
		initialize();
		setLayout(new GridLayout(6,3));
		add(R);
		add(G);
		add(B);
		
	}
	
	void initialize() {
		R = new JComboBox<Integer>();
		G = new JComboBox<Integer>();	
		B = new JComboBox<Integer>();	
		R.setToolTipText("Red Color");
		fillBoxNum(R);
		G.setToolTipText("Green Color");
		fillBoxNum(G);
		B.setToolTipText("Blue Color");
		fillBoxNum(B);
			
		ActionListener refreshScreenListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Rval = (int)R.getSelectedItem();
				int Gval = (int)B.getSelectedItem();
				int Bval = (int)B.getSelectedItem();
				setBackground(new Color(Rval, Gval, Bval));
			}
		};

		R.addActionListener(refreshScreenListener);
		G.addActionListener(refreshScreenListener);
		B.addActionListener(refreshScreenListener);
	}
			
	void fillBoxNum(JComboBox<Integer> Box) {
		for (int i = 1; i < 256; i++)
			Box.addItem(i);
	}
}