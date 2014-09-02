import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 1, 2014
 * Assignment : P3.32
 * Description : ATM Pin card simulation
 */


public class PINcard {
	public static void main(String[] args) {
		/**
		 * Method :
		 * First, as stated in the problem, set "1234" as the default PIN, in this case its a constant.
		 * Then, use while loop to keep track of the number of errors attempted'
		 * If the input is correct, break out of the loop.
		 * If by the end of the while loop, the error is 3. Tell the user about the BANK card suspension.
		 */
		final int DEFAULT_PIN = 1234;
		int error = 0;
		Scanner in = new Scanner(System.in);
		int input_PIN = 0;
		while (error < 3) {
			System.out.print("Enter your PIN number : ");
			input_PIN = in.nextInt();
			if (input_PIN == DEFAULT_PIN) {
				System.out.print("Your PIN is correct.\n");
				break;
			}
			System.out.print("Your PIN is incorrect.\n");
			error++; //here, error is incremented because the input is not correct
		}
		if(error == 3)
			System.out.print("Your bank card is blocked.\n");
	}
}
/* Test Case 1
Enter your PIN number : 123
Your PIN is incorrect.
Enter your PIN number : 124
Your PIN is incorrect.
Enter your PIN number : 125
Your PIN is incorrect.
Your bank card is blocked.

	Test Case 2
Enter your PIN number : 12938213
Your PIN is incorrect.
Enter your PIN number : 234
Your PIN is incorrect.
Enter your PIN number : 1234
Your PIN is correct.

	Test case 3
Enter your PIN number : 1234
Your PIN is correct.
*/