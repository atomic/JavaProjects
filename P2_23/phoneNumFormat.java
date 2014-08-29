/* Name : Tony Lim
 * Date : Aug 29, 2014
 * Assignment : Page 75, P2.23
 * Description : Formatting phone numberoC
 */
import java.util.Scanner;


public class phoneNumFormat {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the unformatted phone number (10-digit) : ");
		String numInput = in.next();
		System.out.printf("Formatted number : %s", processedNum(numInput));
		
		in.close();
	}

	/**
	 * This function takes in unformatted phone number and return the phone number 
	 * 	in the format of (xxx) xxx-xxxx, extra number beyond 10 digits will be added 
	 * 	at the end of the numbers
	 * @param inString
	 * @return
	 */
	public static String processedNum(String inString) {
		String newString = "("; 
		newString += inString.substring(0,3);
		newString += ") ";
		newString += inString.substring(3,6);
		newString += "-";
		newString += inString.substring(6);
		return newString;
	}

}
