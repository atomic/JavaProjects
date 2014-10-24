import java.awt.event.ActionListener;

import javax.swing.Timer;

/* Name : Tony Lim
 * Date : Oct 23, 2014
 * Assignment : P11.12
 * Description : Print current times once a second
 */


public class printTimer {

	public static void main(String[] args) throws InterruptedException {
		ActionListener myListener = new dateTimer();
		Timer t = new Timer(1000, myListener);
		t.start();
		Thread.sleep(10000);
	}

}


/**  	------------- TEST CASES ----------
 * @assumptions : noinputs
 * @preconditions : none

Test Cases:

Thu Oct 23 21:28:34 PDT 2014
Thu Oct 23 21:28:35 PDT 2014
Thu Oct 23 21:28:36 PDT 2014
Thu Oct 23 21:28:37 PDT 2014
Thu Oct 23 21:28:38 PDT 2014
Thu Oct 23 21:28:39 PDT 2014
Thu Oct 23 21:28:40 PDT 2014
Thu Oct 23 21:28:41 PDT 2014
*/