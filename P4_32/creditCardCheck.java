import java.util.Scanner;

/* Name : Tony lim
 * Date : Sep 3, 2014
 * Assignment : P4.32
 * Description : The program is used to check whether 8-digit card number is valid or not
 */


/** Methods
 * 1) From the number inputted, first calculate the first sum of odd digits (firstSum)
 * 2) From the even digits in the number, double the number and form a strings of all the collection all these doubled number
 * 	then, sum all of the number in this digits of string
 */
public class creditCardCheck {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	
	String option;
	boolean done = false;
	do {
	    System.out.print("Input the credit card number : ");
	    String input = in.next();
	    System.out.println("The input is " + input);
	    int sumOfTwo = getFirstSum(input) + getSecondSum(input);
	    System.out.println("The 1st sum is " + getFirstSum(input));
	    System.out.println("The 2nd sum is " + getSecondSum(input));
	    System.out.println("The sum is " + sumOfTwo);
	    if (sumOfTwo % 10 == 0)
		System.out.println("The credit card number is valid.\n");
	    else {
		System.out.println("The number is not valid.");
		System.out.println("To be valid the card number should be : " + input.substring(0, 6) + findStableLastDigit(sumOfTwo, input));
	    }
	    System.out.print("are you done (y/n) : ");
	    option = in.next();
	    done = (option.equals("y") ? true : false);
	} while (!done);
	in.close();
	System.out.print("Cosing Program...");
    }
    
    
    public static int getFirstSum(String input) {
	int sum = 0;
	for (int i = 7; i > 0; i-= 2 ) //note : last index is 1
	    sum += Character.getNumericValue(input.charAt(i)); 
	//alternatively, to convert char to int, char - 48
	return sum;
    }

    public static int getSecondSum(String input) {
	//first, lets generate a new string that is made of up doubled digits
	int temp = 0; //used to store temporary integer before being doubled
	String doubledDigitString = "";
	for (int i = 6; i >= 0; i-= 2 ) { //note : last index is 0
	    temp = Character.getNumericValue(input.charAt(i));
	    temp *= 2;
	    doubledDigitString += temp; //storing the digits into string
	}
	//Now, we from these digits in strings, we find the sum
	int sum = 0;
	for (int i = 0; i < doubledDigitString.length(); i++ ) //loop through the strings
	    sum += Character.getNumericValue(doubledDigitString.charAt(i)); //convert digit to char then to int, and add it to sum
	return sum;
    }
    
    /**
     * The function tries to find what last digit will make the last input divisible by 10
     * 
     * @param sum : This is the final sum of the two sums calculated from the algorithm
     * @param input : original credit card number in strings
     * @return the last digit that will make the card valid
     */
    public static int findStableLastDigit(int sum, String input) {
	int lastDigit = Character.getNumericValue(input.charAt(input.length() - 1));
	int extra = sum % 10; //to get a value that needs to be substracted or added
	if (lastDigit >= extra)
	    return lastDigit - extra;
	else
	    return lastDigit + (10 - extra);
    }
}

/**  	TEST CASE

Input the credit card number : 43589795
The input is 43589795
The 1st sum is 23
The 2nd sum is 27
The sum is 50
The credit card number is valid.

are you done (y/n) : n
Input the credit card number : 43589792
The input is 43589792
The 1st sum is 20
The 2nd sum is 27
The sum is 47
The number is not valid.
To be valid the card number should be : 4358975
are you done (y/n) : n
Input the credit card number : 23448272
The input is 23448272
The 1st sum is 11
The 2nd sum is 24
The sum is 35
The number is not valid.
To be valid the card number should be : 2344827
are you done (y/n) : n
Input the credit card number : 11112328
The input is 11112328
The 1st sum is 13
The 2nd sum is 12
The sum is 25
The number is not valid.
To be valid the card number should be : 1111233
are you done (y/n) : y
Cosing Program...

*/