/* Name : Tony Lim
 * Date : Oct 11, 2014
 * Assignment : P9.19
 * Description : Implement formattable
 */


public class testFormattable {

	public static void main(String[] args) {
		
		// testcase for BankAccount
		BankAccount acc1 = new BankAccount(2000.5424);
		System.out.println("Printing BankAccount directly");
		System.out.println(acc1); //this calls to String
		
		System.out.println("Default formatting (%s):");
		System.out.printf("%s", acc1);
		
		System.out.println("\n");
		System.out.println("Now test precision formattings (%.2)");
		System.out.printf("Your balance is : $%.2s on checking account", acc1);

		
		System.out.println("\n");
		System.out.println("Now test width formattings (%5s)");
		System.out.printf("Your balance is : $%5s on your checking account", acc1);
		
		System.out.println("\n");
		System.out.println("Now test width and precision formattings (%10.1s)");
		System.out.printf("Your balance is : $%10.1s on your checking account", acc1);
	}

}



/**  	------------- TEST CASES ----------
 * @preconditions : inputs is object of class BankAccount

Test Cases:

Printing BankAccount directly
Account Number : 1001
Balance : 2000.5424

Default formatting (%s):
2000.5424

Now test precision formattings (%.2)
Your balance is : $2000.54 on checking account

Now test width formattings (%5s)
Your balance is : $2000.4 on your checking account

Now test width and precision formattings (%10.1s)
Your balance is : $2000.5     on your checking account

*/