import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 4, 2014
 * Assignment : P5.18
 * Description : The program is used to find the number of digit in an integer
 */


/**
 * Pseudo-code:
 * To recursively find the digit, 
 * in each loop of recursion:
 * 	if i is larger than 9
 * 		divide i by 10
 * 		return 1 + recur(i); 
 * 	else : return 1
 *
 */
public class digitInt {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int i;
	String option;
	boolean done = false;
	do {
	    System.out.print("input your number : ");
	    i = in.nextInt();
	    System.out.println("Your number has " + findDigit(i) + " digits.");
	    
	    System.out.print("are you done (y/n) : ");
	    option = in.next();
	    done = (option.equals("y") ? true : false);
	} while (!done);
	in.close();
	System.out.print("Cosing Program...");
    }

    public static int findDigit(int i) {
	if (i > 9)
	    return 1 + findDigit(i/10);
	else
	    return 1;
    }
}


/** 	TESTCASE

 
input your number : 219
Your number has 3 digits.
are you done (y/n) : n
input your number : 20
Your number has 2 digits.
are you done (y/n) : n
input your number : 320
Your number has 3 digits.
are you done (y/n) : n
input your number : 33344
Your number has 5 digits.
are you done (y/n) : y
Cosing Program...

*/