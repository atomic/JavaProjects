import java.util.Scanner;

/* Name : Tony LIm
 * Date : Sep 1, 2014
 * Assignment : P3.26
 * Description : The program will convert positive integer to roman number
 */

/** Method
 * To solve the problem, i apply the Recursion technique to smartly 
 * chop down the digits of number sequentially.
 * First, ask user for inputs in integer. 
 * if its value is valid, proceed to next steps to find the roman numeral
 */

public class numToRoman {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = getValidInt();
		if (num > 3999 || num < 1) {
			System.out.print("Ivalid input, sir.\n");
			System.exit(0);
		}
		String theRomanNumber = getRomanNumeral(num);
		System.out.printf("The roman number is : %s", theRomanNumber);
	}

	// function asking for integer input
	public static int getValidInt() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please input integer : ");
		if(in.hasNextInt())
			return in.nextInt();
		else
			return getValidInt();
	}
	
	/**
	 * The function works recursively by keeping track of the "Stack" of 
	 * previous Strings. Visually, the process can be imagined as a growing a tree 
	 * from root to branches, and chop it down from branches to root.
	 * 
	 * @param i
	 * @return
	 */
	public static String getRomanNumeral(int i) {
		if (i >= 900 && i < 1000)
			return "CM"  + getRomanNumeral(i - 900);
		else if (i >= 1000)
			return "M"   + getRomanNumeral(i - 1000);
		else if (i >= 400 && i < 500)
			return "CD"  + getRomanNumeral(i - 400);
		else if (i >= 500)
			return "D"   + getRomanNumeral(i - 500);
		else if (i >= 90 && i < 100)
			return "XC"  + getRomanNumeral(i - 90);
		else if (i >= 100)
			return "C"   + getRomanNumeral(i - 100);
		else if (i >= 40 && i < 50)
			return "XL"  + getRomanNumeral(i - 40);
		else if (i >= 50)
			return "L"   + getRomanNumeral(i - 50);
		else if (i == 9)
			return "IX";
		else if (i >= 10)
			return "X"   + getRomanNumeral(i - 10);
		else if (i == 4)
			return "IV";
		else if (i >= 5)
			return "V"  + getRomanNumeral(i - 5);
		else if (i > 0)
			return "I"  + getRomanNumeral(i - 1);
		else
			return "";
	}
}

/* Test Cases

Please input integer : 23012
Ivalid input, sir.

Please input integer : 1978
The roman number is : MCMLXXVIII

Please input integer : 2021
The roman number is : MMXXI

Please input integer : 2020
The roman number is : MMXX

Please input integer : 2094
The roman number is : MMXCIV

Please input integer : 9
The roman number is : IX

Please input integer : 4
The roman number is : IV

Please input integer : 19
The roman number is : XIX

Please input integer : 29
The roman number is : XXIX

Please input integer : 49
The roman number is : XLIX

Please input integer : 94
The roman number is : XCIV

Please input integer : 4999
The roman number is : MMMMCMXCIX

Please input integer : 3999
The roman number is : MMMCMXCIX
*/
