import java.util.Arrays;
import java.util.Scanner;

/* Name : Tony Lim, Derek Nakano
 * Date : Sep 4, 2014
 * Assignment : P5.25
 * Description : This program will convert zipcode to barcode
 */


public class zipToBar {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String option;
		boolean done = false;
		do {
			System.out.print("Please input the zipcode : ");
			int zipcode = in.nextInt();
			//debug
			String theWholeBar = convertDigitToBar(zipcode);
			System.out.println("The ZipCode in Barcode is : " + theWholeBar);
			System.out.print("are you done (y/n) : ");
			option = in.next();
			done = (option.equals("y") ? true : false);
		} while (!done);
		in.close();
		System.out.print("Cosing Program...");
	}

	public static void printDigit(int d) {
		String digittoPrint = OnedigitToOneBar(d);
		System.out.print(digittoPrint);
	}

	public static String OnedigitToOneBar(int d) {
		switch (d) {
		case 0: return "||:::"; 
		case 1: return ":::||"; 
		case 2: return "::|:|"; 
		case 3: return "::||:"; 
		case 4: return ":|::|"; 
		case 5: return ":|:|:"; 
		case 6: return ":||::"; 
		case 7: return "|:::|"; 
		case 8: return "|::|:"; 
		case 9: return "|:|::"; 
		}
		return "ERROR";
	}
	public static String convertDigitToBar(int d) {
		int[] digitsOfZipCode = new int[5];
		String zipInString = "" + d;
		for (int i = 0; i < 5; i++)
			digitsOfZipCode[i] = Character.getNumericValue(zipInString.charAt(i));
		String wholeBar = "|";
		for (int i : digitsOfZipCode)
			wholeBar += OnedigitToOneBar(i);
		
		int sum = 0;
		for (int i : digitsOfZipCode)
			sum += i;
		if (sum % 10 != 0)
			wholeBar += OnedigitToOneBar(10 - (sum%10));
		wholeBar += "|";
		return wholeBar;
	}
	
}

/** TESTCASE
 * 
 
Please input the zipcode : 95014
The ZipCode in Barcode is : ||:|:::|:|:||::::::||:|::|:::|||
are you done (y/n) : n
Please input the zipcode : 79123
The ZipCode in Barcode is : ||:::||:|:::::||::|:|::||:|::|:|
are you done (y/n) : n
Please input the zipcode : 91780
The ZipCode in Barcode is : ||:|:::::|||:::||::|:||::::|:|:|

*/