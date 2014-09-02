/* Name : Tony LIm
 * Date : Aug 28, 2014
 * Assignment : Page 74, P74.74
 * Description : transform month number to string
 */
import java.util.Scanner;


public class numToMonth {

	public static void main(String[] args) {
		String[] monthList = { 
		"January"   , "February" , "March"    , "April"       ,
		"May"       , "June"     , "July"     , "August"      ,
		"September" , "October"  , "November" , "December" };

		Scanner in = new Scanner(System.in);
		System.out.print("Input your month in number : ");
		int month = in.nextInt();
		while (month < 1 || month > 12) {
			System.out.println("Please enter the correct month number (1-12).");
			System.out.print("Input your month in number : ");
			month = in.nextInt();
		}
		System.out.printf("That month is %s", monthList[month - 1]);
		in.close();
	}

}
