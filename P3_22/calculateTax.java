import java.util.Scanner;

/* Name : Tony Lim
 * Date : Aug 31, 2014
 * Assignment : P3.22
 * Description : The program will calculate the tax based on marital status and income range
 */

/*
 * Method:
 * To calculate taxes depending on a person's marital status,
 * i choose to make two functions that process the tax differently.
 *
 */

public class calculateTax {

	// This function follow the mentioned procedure in the book
	public static double singleTax(double income) {
		if (income <= 8E3)
			return income*0.1;
		else if (income <= 32E3)
			return 800 + (income - 8E3)*.15;
		else
			return 4400 + (income - 32E3)*.25;
	}

	// This function follow the mentioned procedure in the book
	public static double marriedTax(double income) {
		if (income <= 16E3)
			return income*0.1;
		else if (income <= 64E3)
			return 16E2 + (income - 16E3)*.15;
		else
			return 88E2 + (income - 64E3)*.25;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("What is your marital status? (M)arried or (S)ingle? : ");
		String maritalStatus = in.next();
		System.out.print("Enter your tax income  : ");
		double income = in.nextDouble();
		double tax = 0.0; //declaring tax

		// Here, we check if the person is married or single, based on this, call different functions
		if (maritalStatus.equals("S") || maritalStatus.equals("Single"))
			tax = singleTax(income);
		else if (maritalStatus.equals("M") || maritalStatus.equals("Married"))
			tax = marriedTax(income);
		
		System.out.printf("Based on your input, your tax is : %.2f", tax);
		
		in.close();
	}
}
/* 	Test Cases

What is your marital status? (M)arried or (S)ingle? : S
Enter your tax income  : 7000
Based on your input, your tax is : 700.00

What is your marital status? (M)arried or (S)ingle? : S
Enter your tax income  : 15000
Based on your input, your tax is : 1850.00

What is your marital status? (M)arried or (S)ingle? : S
Enter your tax income  : 50000
Based on your input, your tax is : 8900.00

What is your marital status? (M)arried or (S)ingle? : Married
Enter your tax income  : 10000
Based on your input, your tax is : 1000.00

What is your marital status? (M)arried or (S)ingle? : M
Enter your tax income  : 16000
Based on your input, your tax is : 1600.00

What is your marital status? (M)arried or (S)ingle? : M
Enter your tax income  : 50000
Based on your input, your tax is : 6700.00

What is your marital status? (M)arried or (S)ingle? : M
Enter your tax income  : 70000
Based on your input, your tax is : 10300.00

*/