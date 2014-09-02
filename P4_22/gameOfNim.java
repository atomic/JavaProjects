import java.util.Scanner;

/* Name : Tony Lim, Benjamin Loh
 * Date : Sep 2, 2014
 * Assignment : P4.22
 * Description : THE GAME of Nim
 */

public class gameOfNim {

public static void playGame(int n, int comDIFF) {
		Scanner in = new Scanner(System.in);
		int currentSize = n;
		boolean playerLast = false;
		boolean comLast = false;
		while(currentSize > 0) {
			System.out.print("Player number : ");
			playerChosenNum = in.nextInt();
			playerLast = true;
			comLast = false;
			System.out.print("COM Moves.");
			switch (comDIFF) {
			case 0:
				comChosenNum = generateStupidComNumber(n);
				break;
			case 1:
				comChosenNum = generateSmartCOMNumber(n);
				break;
			}
			pileSIZE -= comChosenNum;
			playerLast = true;
			comLast = false;
		}
	}

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int pileSIZE =  (int) (Math.random() * 100 ) + 10;
	int whoStartFirst = (int) (Math.random() + 1); // 0 <-- Player, 1 <-- COM
	int playerChosenNum = 0; //declare
	int comChosenNum = 0; //declare
	int comDIFF = (int) (Math.random() + 1); // smart or stupid
	if (whoStartFirst == 0) {
		playerChosenNum(pileSIZE, comDIFF);
	}
	else {
		System.out.print("COM Moves.");
		switch (comDIFF) {
		case 0:
			comChosenNum = generateStupidComNumber(n);
			break;
		case 1:
			comChosenNum = generateSmartCOMNumber(n);
			break;
		}
		pileSIZE -= comChosenNum;
		playGame(pileSIZE, comDIFF);
	}

	public static int generateStupidComNumber(int n) {
		return (int) Math.random()*(n/2) + 1;
	}

	public static int generateSmartCOMNumber(int n) {
		int randomPower = (int) (( Math.random() * 6 )+ 1);
		if (Math.pow(2, randomPower) >= n)
			generateSmartCOMNumber(n);
		return (int) (n - Math.pow(2, randomPower));
	}
}
}
