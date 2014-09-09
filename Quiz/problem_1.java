import java.awt.print.Printable;
import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 8, 2014
 * Assignment : Quiz 1
 * Description : Write a program which uses functions (methods) to convert a byte of binary or single digit to hexidecimal
 */


public class problem_1 {

	// 1- First function will receive binary (one byte) and converts it to digit .Name this function ByteToDigit
	public static int ByteToDigit(String binary) {
		int value = 0;
		int power = 0;
		for (int i = binary.length() - 1; i >= 0; i--) {
			if(binary.charAt(i) == '1')
				value += Math.pow(2, power);
			power++;
		}
		return value;
	}
	
	//2- Second function will receive a digit ( 0-15) and converts it to hexadecimal. Call this function (method) DigitToHex
	public static char DigitToHex(int digit) {
		switch (digit) {
		case 10: return 'A';
		case 11: return 'B';
		case 12: return 'C';
		case 13: return 'D';
		case 14: return 'E';
		case 15: return 'F';
		default: return (char) (digit + '0');
		}
	}
	// 3. Third function will ask the user to enter a number -
	//     It will verify if the number is correct (either 8 bits or single digit)
	// 	    If it is binary it will call first function and then the second function with the result. 
	//		If the user input was a single digit it will call the second function  only.
	
	public static void getInput() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please input ");
		String user_input = in.next();
	}
	
	public static boolean check8bit(String input) {
		//check if the string is in 8bits binary
		if(input.length() == 8) {
			for(int i = 0; i < input.length(); i++) 
				if(input.charAt(i) != '1' && input.charAt(i) != '0')
					return false; //not binary
		}
		else
			return false;
		return true;
	}
	
	public static boolean checkDigit15(String input) {
		if(input.length() > 2)
			return false;
		int value = Integer.parseInt(input); //convert string to integer
		return (value < 16 ? true : false);
	}
	
	public static String get2DigitHex(String input) {
		int firstDigit= ByteToDigit(input.substring(0, 4));
		int secondDigit= ByteToDigit(input.substring(4, 8));
		char firstHex = DigitToHex(firstDigit);
		char secondHex = DigitToHex(secondDigit);
		return "" + firstHex + secondHex;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Please input a binary or digit (0-15): ");
		String binary_input = in.next();
		
		int decimal_representation;
		char hex_representation = 0;
		System.out.println("Now, lets check if your input is 8bits binary");
		boolean is_8bits = check8bit(binary_input);
		boolean is_digit = checkDigit15(binary_input);
		if(is_8bits) {
			System.out.println("Your input is 8bits");
			decimal_representation = ByteToDigit(binary_input);
			hex_representation = DigitToHex(decimal_representation);
		}
		else {
			System.out.println("Your input is not 8bits");
			if(is_digit) {
				System.out.println("Your input is a valid digit");
				hex_representation = DigitToHex(Integer.parseInt(binary_input));
			}
			else {
				System.out.println("Error, not 8bits, not valid digit (0 - 15)");
				System.exit(0);
			}
		}
		System.out.println("The heximal representation is " + hex_representation);
		System.out.println("The 2 digit representation ids " + get2DigitHex(binary_input));
	}
}

/**  	------------- TEST CASES ----------
 * @assumptions : noinputs
 * @preconditions : none

Test Cases:


Please input a binary or digit (0-15): 16
Now, lets check if your input is 8bits binary
Your input is not 8bits
Error, not 8bits, not valid digit (0 - 15)

Please input a binary or digit (0-15): 00001111
Now, lets check if your input is 8bits binary
Your input is 8bits
The heximal representation is F

Please input a binary or digit (0-15): 13
Now, lets check if your input is 8bits binary
Your input is not 8bits
Your input is a valid digit
The heximal representation is D

Please input a binary or digit (0-15): 10
Now, lets check if your input is 8bits binary
Your input is not 8bits
Your input is a valid digit
The heximal representation is A


Please input a binary or digit (0-15): 11110000
Now, lets check if your input is 8bits binary
Your input is 8bits
The heximal representation is ?
The 2 digit representation ids F0

*/