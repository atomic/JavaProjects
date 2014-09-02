import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 1, 2014
 * Assignment : P3.32
 * Description : ATM Pin card simulation
 */


public class PINcard {
	public static void main(String[] args) {
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
			error++;
		}
		if(error == 3)
			System.out.print("Your bank card is blocked.\n");
	}
}