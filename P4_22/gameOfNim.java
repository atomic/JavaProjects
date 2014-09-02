import java.util.Scanner;

/* Name : Tony Lim, Benjamin Loh
 * Date : Sep 2, 2014
 * Assignment : P4.22
 * Description : THE GAME of Nim
 */

public class gameOfNim {

	public static int generateStupidComNumber(int n) {
		return (int) (Math.random()*(n/2)) + 1;
	}

	public static int generateSmartCOMNumber(int n) {
		int randomPower = (int) (( Math.random() * 6 )+ 1);
		if (Math.pow(2, randomPower) > n)
			generateSmartCOMNumber(n);
		return (int) (n - Math.pow(2, randomPower));
	}

public static void playGame(int n, int comDIFF) {
		Scanner in = new Scanner(System.in);
		int currentSize = n;
		boolean playerLast = false;
		boolean comLast = false;
		int playerChosenNum = 0;
		int comChosenNum = 0;
		while(currentSize > 0) {
			System.out.printf("The pile size is %d .\n", currentSize);
			System.out.print("Player number : ");
			playerChosenNum = in.nextInt();
			currentSize -= playerChosenNum;
			playerLast = true;
			comLast = false;
			if (currentSize == 1) {
				playerLast = false;
				comLast = true;
			}

			System.out.print("\nCOM Moves.\n");
			switch (comDIFF) {
			case 0:
				comChosenNum = generateStupidComNumber(currentSize);
				break;
			case 1:
				comChosenNum = generateSmartCOMNumber(currentSize);
				break;
			}

			System.out.printf("COM chosen number : %d \n", comChosenNum);
			currentSize -= comChosenNum;
			playerLast = false;
			comLast = true;
		}

		if (playerLast) {
			System.out.print("You lose, computer win.");
		}
		else
			System.out.print("Congratulations, you win.");
	}

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int pileSIZE =  (int) (Math.random() * 100 ) + 10;
	System.out.printf("The pile generated is %d \n", pileSIZE);
	int whoStartFirst = (int) (Math.random() + 1); // 0 <-- Player, 1 <-- COM
	int playerChosenNum = 0; //declare
	int comChosenNum = 0; //declare
	int comDIFF = (int) (Math.random() + 1); // smart or stupid
	if (comDIFF == 0)
		System.out.print("The computer is stupid.\n");
	else
		System.out.print("The computer is smart");

	if (whoStartFirst == 0)
		playGame(pileSIZE, comDIFF);
	else {
		System.out.print("COM Moves.\n");
		switch (comDIFF) {
		case 0:
			comChosenNum = generateStupidComNumber(pileSIZE);
			break;
		case 1:
			comChosenNum = generateSmartCOMNumber(pileSIZE);
			break;
		}
		System.out.printf("COM chosen number : %d \n", comChosenNum);
		pileSIZE -= comChosenNum;
		playGame(pileSIZE, comDIFF);
	}
	in.close();
}
}


/**
 * Program still have errors
 * - Computer choose negative numbers
 * - Program always terminate in infinite loop
*/