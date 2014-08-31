import java.util.Scanner;

/* Name : Tony Lim
 * Date : Aug 30, 2014
 * Assignment : P3.18
 * Description : The program ask user for month and day in and 
 * 				 return corresponding season
 */


public class seasonOfTheYear {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int month = 0;
		System.out.print("Enter the month : ");
		if (in.hasNextInt())
			month = in.nextInt();
		else {
			String stringMonth = in.next();
			stringMonth = stringMonth.toLowerCase();
			if (stringMonth.equals("january")) { month = 1; }
			else if (stringMonth.equals("february")) { month = 2; }
			else if (stringMonth.equals("march")) { month = 3; }
			else if (stringMonth.equals("april")) { month = 4; }
			else if (stringMonth.equals("may")) { month = 5; }
			else if (stringMonth.equals("june")) { month = 6; }
			else if (stringMonth.equals("july")) { month = 7; }
			else if (stringMonth.equals("august")) { month = 8; }
			else if (stringMonth.equals("septermber")) { month = 9; }
			else if (stringMonth.equals("october")) { month = 10; }
			else if (stringMonth.equals("november")) { month = 11; }
			else if (stringMonth.equals("december")) { month = 12; }
			else {
				System.err.println("Input invalid");
				System.exit(0);
			}
		}
		System.out.print("Enter day : ");
		int day = in.nextInt();
		String season = "";
		switch (month) {
		case 1:	
		case 2:
		case 3:
			season = "Winter";
			break;
		case 4:	
		case 5:
		case 6:
			season = "Spring";
			break;
		case 7:	
		case 8:
		case 9:
			season = "Summer";
			break;
		case 10:	
		case 11:
		case 12:
			season = "Fall";
			break;
		default:
			break;
		}
		
		if ( ( (month % 3) == 0) && (day >= 21) ) {
			if (season.equals("Winter")) { season = "Spring"; }
			else if (season.equals("Spring")) { season = "Summer"; }
			else if (season.equals("Summer")) { season = "Fall"; }
			else if (season.equals("Fall")) { season = "Winter"; }
		}
		
		System.out.printf("The season is %s.\n", season);
		in.close();
	}
}
