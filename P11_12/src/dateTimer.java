import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

class dateTimer implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Date now = new Date();
		System.out.println(now);
	}
}
