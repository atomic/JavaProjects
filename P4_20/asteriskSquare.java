import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 3, 2014
 * Assignment : P4.20
 * Description : The program will print a display of solid square and hollow square
 */


class asteriskSquare {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int input;
	String option;
	boolean done = false;
	do {
	    System.out.print("Input the integer : ");
	    input = in.nextInt();
	    
	    //first, print the first 2 block of the squares
	    printRepeatedString("*", input); 
	    System.out.print(" ");
	    printRepeatedString("*", input);
	    System.out.println();

	    //then, print the next n-2 solid and hollow square
	    for (int i = 0; i < input - 2; i++) {
		printRepeatedString("*", input);
		System.out.print(" *");
		printRepeatedString(" ", input - 2);
		System.out.print("*\n");
	    }
	    
	    //Lasty, this will print the last 2 block of asterisk
	    printRepeatedString("*", input); 
	    System.out.print(" ");
	    printRepeatedString("*", input);
	    System.out.println();

	    System.out.print("are you done (y/n) : ");
	    option = in.next();
	    done = (option.equals("y") ? true : false);
	} while (!done);
	in.close();
	System.out.print("Cosing Program");
    }
    

    /**
     * The function is used to print a certain string certain times
     * @param str : the string to be repeated
     * @param n : the number of times the string will be repeated
     */
    static void printRepeatedString(String str, int n) {
	String toPrint = "";
	for (int i = 0; i < n; i++)
	    toPrint += str;
	System.out.print(toPrint);
    }

}

/**  	TEST CASES


Input the integer : 5
***** *****
***** *   *
***** *   *
***** *   *
***** *****
are you done (y/n) : n
Input the integer : 4
**** ****
**** *  *
**** *  *
**** ****
are you done (y/n) : n
Input the integer : 3
*** ***
*** * *
*** ***
are you done (y/n) : n
Input the integer : 2
** **
** **
are you done (y/n) : n
Input the integer : 1
* *
* *
are you done (y/n) : n
Input the integer : 10
********** **********
********** *        *
********** *        *
********** *        *
********** *        *
********** *        *
********** *        *
********** *        *
********** *        *
********** **********
are you done (y/n) : n
Input the integer : 15
*************** ***************
*************** *             *
*************** *             *
*************** *             *
*************** *             *
*************** *             *
*************** *             *
*************** *             *
*************** *             *
*************** *             *
*************** *             *
*************** *             *
*************** *             *
*************** *             *
*************** ***************
are you done (y/n) : y


*/