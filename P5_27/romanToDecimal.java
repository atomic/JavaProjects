import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 5, 2014
 * Assignment : P5.27
 * Description : THe program will convert roman numeral to decimal
 */


/**
 * Using the algorithm provided by the question
 *  1) use a method convert each roman numeral to decimal representation
 *  2) Instead of using while loop, i choose to use recursive algorithm to 
 *  	compound the value of the roman numeral and shrink the roman string
 */
public class romanToDecimal {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.print("Enter some string");
	String romanNumeral;
	String option;
	boolean done = false;
	do {
	    System.out.print("Enter the roman numeral(capital) : ");
	    romanNumeral = in.next();
	    System.out.println("The value in decimal is " + convertRomanNumbers(romanNumeral));

	    System.out.print("are you done (y/n) : ");
	    option = in.next();
	    done = (option.equals("y") ? true : false);
	} while (!done);
	in.close();
	System.out.print("Cosing Program...");

    }

    /**
     * The functio will take a char and return integer
     * @param roman : roman character
     * @return integer value of roman character
     */
    public static int romanToInt(char roman) {
	switch(roman) { 
	    case 'I' : return 1;
	    case 'V' : return 5;
	    case 'X' : return 10;
	    case 'L' : return 50;
	    case 'C' : return 100;
	    case 'D' : return 500;
	    case 'M' : return 1000;
	}
	System.out.print("error : roman char input is not known.");
	return -1; // exception
    }
    
    /**
     * This is recursive function that behave more or less similar to the algorithm described by the question
     * @param roman : sequence of roman numeral
     * @return total value of the roman character
     */
    public static int convertRomanNumbers(String roman) {
	if(roman.length() == 0)
	    return 0;
	else if(roman.length() == 1)
	    return romanToInt(roman.charAt(0));
	int firstValue = romanToInt(roman.charAt(0));
	int secondValue = romanToInt(roman.charAt(1));
	if(secondValue > firstValue && roman.length() > 2)
	    return secondValue - firstValue + convertRomanNumbers(roman.substring(2));
	if(secondValue > firstValue && roman.length() == 2)
	    return secondValue - firstValue; 
	else
	    return firstValue + convertRomanNumbers(roman.substring(1));
    }
}


/** TEST CASES

Enter some stringEnter the roman numeral(capital) : MCMLXXVII
The value in decimal is 1977
are you done (y/n) : N
Enter the roman numeral(capital) : MCMLXXVIII
The value in decimal is 1978
are you done (y/n) : n
Enter the roman numeral(capital) :  MMXIV
The value in decimal is 2014
are you done (y/n) : n
Enter the roman numeral(capital) : CDXLIV
The value in decimal is 444
are you done (y/n) : n
Enter the roman numeral(capital) : CMXCIV
The value in decimal is 994
are you done (y/n) : y
Cosing Program...

*/