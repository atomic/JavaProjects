import java.util.ArrayList;
import java.util.Scanner;

/* Name : Tony Lim
 * Date : Oct 12, 2014
 * Assignment : P9.23
 * Description : Improved Appointment Book Program
 */


public class tester{

	public static void main(String[] args) {
		
		ArrayList<Appointment> myMemo = new ArrayList<>(); //making a list of Appointment

		int option = 0;
		boolean done = false;
		System.out.println("1. Add Appointment");
		System.out.println("2. List all Appointment");
		System.out.println("3. List Appointment for a Day");
		System.out.println("5. Exit");
		System.out.println("\n");

		Scanner in = new Scanner(System.in);
		do {
			System.out.print(" add/listall/listdate/exit >> ");
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
                                case 3: listAppointmentOnDate(myMemo); break;
                                case 5: done = true; break;
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
		
		memo.add(new OneTime(desc, y, m - 1, d));
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
			memo.add(new Daily(desc, e_y, e_m - 1, e_d));
		else
			memo.add(new Daily(desc, s_y, s_m - 1, s_d, e_y, e_m - 1, e_d));
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

		memo.add(new Monthly(desc, s_m - 1, e_m - 1, d));
		System.out.println("Appointment Created !");
	}

	public static void listAppointmentOnDate(ArrayList<Appointment> memo) {
		Scanner in = new Scanner(System.in);
		int y, m ,d;
		System.out.print("Date to check ( y m d ): ");
		y = in.nextInt();
		m = in.nextInt();
		d = in.nextInt();
		
		System.out.print("Here's the list of appointment for that day : \n");
		for (Appointment appointment : memo) {
			if(appointment.occursOn(y, m - 1, d))
				System.out.println(" - " + appointment.getDescription());
		}
	}
}


/**  	------------- TEST CASES ----------
 * @assumptions : noinputs
 * @preconditions : none

Test Cases:

1. Add Appointment
2. List all Appointment
3. List Appointment for a Day
5. Exit


 add/listall/listdate/exit >> 1
1. Add OneTime Appointment
2. Add Daily Appointment
3. Add Monthly
 >> 1
Appointment Description : get a cat
When is the appointment ? Year Month Day : 2014 10 12
Appointment Created !
 add/listall/listdate/exit >> 1
1. Add OneTime Appointment
2. Add Daily Appointment
3. Add Monthly
 >> 1
Appointment Description : fix bike
When is the appointment ? Year Month Day : 2014 10 12
Appointment Created !
 add/listall/listdate/exit >> 1
1. Add OneTime Appointment
2. Add Daily Appointment
3. Add Monthly
 >> 1
Appointment Description : go to bank
When is the appointment ? Year Month Day : 2014 10 13
Appointment Created !
 add/listall/listdate/exit >> 1
1. Add OneTime Appointment
2. Add Daily Appointment
3. Add Monthly
 >> 2
Appointment Description : eat healthy
It starts today ? (y/n) : n
Isert your starting date? y m d : 2014 10 5
endding date (y m d) : 2015 10 5
Appointment Created !
 add/listall/listdate/exit >> 1
1. Add OneTime Appointment
2. Add Daily Appointment
3. Add Monthly
 >> 3
Appointment Description : get a haircut
Which day of the month ? 12
Which month it starts at ? (1-12) 1
Which month it ends at ? (1-12) 12
Appointment Created !
 add/listall/listdate/exit >> 1
1. Add OneTime Appointment
2. Add Daily Appointment
3. Add Monthly
 >> 2
Appointment Description : go to gym
It starts today ? (y/n) : y
endding date (y m d) : 2019 2 25
Appointment Created !
 add/listall/listdate/exit >> 3
Date to check ( y m d ): 2014 10 12
Here's the list of appointment for that day : 
 - eat healthy
 - get a haircut
 - go to gym
 add/listall/listdate/exit >> 2
One time appointment on 2014-10-12, get a cat
One time appointment on 2014-10-12, fix bike
One time appointment on 2014-10-13, go to bank
Daily Appointment from 2014-10-05 to 2015-10-05, eat healthy
Monthly Appointment on day 12 from January to December, get a haircut
Daily Appointment from 2014-10-12 to 2019-02-25, go to gym
 add/listall/listdate/exit >> 3
Date to check ( y m d ): 2014 10 13
Here's the list of appointment for that day : 
 - eat healthy
 - go to gym
 add/listall/listdate/exit >> 5
Cosing Program...




*/