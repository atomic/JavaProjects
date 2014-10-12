import java.util.ArrayList;
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
		ArrayList<Appointment> myMemo = new ArrayList<>(); //making a list of Appointment
		
		myMemo.add(new OneTime("Onet 1"));
		myMemo.add(new OneTime("Onet 2"));
		myMemo.add(new OneTime("Onet 3"));
		
		myMemo.add(new Monthly("Monthly 1"));
		myMemo.add(new Monthly("Monthly 2"));
		myMemo.add(new Monthly("Monthly 3"));
		
		myMemo.add(new Daily("Daily 1"));
		myMemo.add(new Daily("Daily 2"));
		myMemo.add(new Daily("Daily 3"));
		
		for (Appointment appointment : myMemo) {
			System.out.println(appointment.getDate() + ", " + appointment.getDescription());
		}
		
		int option;
		boolean done = false;
		System.out.println("1. Add Appointment");
		System.out.println("2. List Appointment");
		System.out.println("3. Exit");
		System.out.println("\n");

		do {
			System.out.print(" >> ");
			option = in.nextInt();
			switch (option) {
                                case 1:
                                        System.out.println("1. Add OneTime Appointment");
                                        System.out.println("2. Add Daily Appointment");
                                        System.out.println("3. Add Monthly");
                                        System.out.print(" >> ");
                                        option = in.nextInt();
                                        switch (option) {
                                                case 1: getOneTimeAppointment(myMemo); break;
                                                case 2: getDailyAppointment(myMemo);   break;
                                                case 3: getMonthlyAppointment(myMemo); break;
                                                default: break;
                                        } break;
                                case 2:
                                        for (Appointment appointment : myMemo) {
                                                System.out.println(appointment.getDate() + ", " + appointment.getDescription());
                                        } break;
                                case 3: done = true; break;
                                default: 			  break;
			}
		} while (!done);
		in.close();
		System.out.print("Cosing Program...");

		in.close();
	}
	
	public static void getOneTimeAppointment(ArrayList<Appointment> memo) {
		Scanner in = new Scanner(System.in);
		String desc;
		System.out.print("Appointment Description : ");
		desc = in.nextLine();
		System.out.print("When is the appointment ? Year Month Day : ");
		int y, m , d;
		y = in.nextInt();
		m = in.nextInt();
		d = in.nextInt();
		memo.add(new OneTime(desc, y, m, d));
		in.close();
		System.out.println("Appointment Created !");
	}

	public static void getDailyAppointment(ArrayList<Appointment> memo) {
		Scanner in = new Scanner(System.in);
		String desc;
		int s_y = 0, s_m = 0 , s_d = 0;
		int e_y, e_m , e_d;
		System.out.print("Appointment Description : ");
		desc = in.nextLine();
		System.out.print("It starts today ? (y/n) : ");
		boolean startsToday = in.next().equals("y");

		if(!startsToday) { //if user wants to input their own starting date
			System.out.print("Isert your starting date? y m d : ");
			s_y = in.nextInt();
			s_m = in.nextInt();
			s_d = in.nextInt();
		} 

		System.out.print("endding date (y m d) : ");
		e_y = in.nextInt();
		e_m = in.nextInt();
		e_d = in.nextInt();

		if(startsToday)
			memo.add(new Daily(desc, e_y, e_m, e_d));
		else
			memo.add(new Daily(desc, s_y, s_m, s_d, e_y, e_m, e_d));
		in.close();
		System.out.println("Appointment Created !");
	}


	public static void getMonthlyAppointment(ArrayList<Appointment> memo) {
		Scanner in = new Scanner(System.in);
		String desc;
		int s_m, e_m, d ;

		System.out.print("Appointment Description : ");
		desc = in.nextLine();

		System.out.print("Which day of the month ? ");
		d = in.nextInt();
		System.out.print("Which month it starts at ? (1-12) ");
		s_m = in.nextInt();
		System.out.print("Which month it ends at ? (1-12) ");
		e_m = in.nextInt();

		memo.add(new Monthly(desc, s_m, e_m, d));
		in.close();
		System.out.println("Appointment Created !");
	}

}
