import java.util.Scanner;

/* Name : Tony Lim
 * Date : Oct 12, 2014
 * Assignment : P9.23
 * Description : Improved Appointment Book Program
 */


public class tester{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String temp;
		
		//testcase for Appointments
		Appointment[] reminders = new  Appointment[5];
		for(int i = 0; i < 5; i++){
			reminders[i] = new Appointment(); //by default, it should be set to today's date
			System.out.println("For date " + reminders[i].getDate());
			System.out.print("Appointment description : "); 
			temp = in.nextLine(); // get description
			reminders[i].setDescription(temp);
		}
		
		for (Appointment app: reminders) {
			System.out.println("Date : " + app.getDate());
			System.out.println("Appointment : " + app.getDescription());
		}
		
		//try to print all appointments on the day
		// ex : 2014-10-10
		System.out.println("Here's the list of appointments on 2014-10-10.");
		for (Appointment memo : reminders) {
			if(memo.occursOn(2014, 10, 11))
				System.out.println("- " + memo.getDescription());
		}

		in.close();
	}

}
