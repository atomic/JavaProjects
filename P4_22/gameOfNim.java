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
		int[] thePowerPile = {1,3,7,15,31,63};
		for (int i = 1; i < 6; i++)
			if(thePowerPile[i] >= n)
				return n - thePowerPile[i-1];
		return n - thePowerPile[5];
	}

    public static int playerGetNumber(int n) {
    	Scanner in = new Scanner(System.in);
    	System.out.print("Player number : ");
    	int chosen = in.nextInt();
    	if (chosen > n/2 || chosen < 1) {
    		System.out.print("Please don't cheat. Choose at most half of the pile!\n");
    		return playerGetNumber(n);
    	}
    	return chosen;
    }

    public static void playGame(int n, int comDIFF) {
    	int currentSize = n;
    	boolean playerLast = false;

    	int playerChosenNum = 0;
    	int comChosenNum = 0;
    	while(currentSize > 0) {
    		System.out.printf("The pile size is %d .\n", currentSize);
    		playerChosenNum = playerGetNumber(currentSize); 
    		currentSize -= playerChosenNum;
    		playerLast = true;
    		if(currentSize == 0)
    			break;

    		System.out.printf("\nThe pile size is %d .\n", currentSize);
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
    	}
    	if (playerLast)
    		System.out.print("You lose, computer win.");
    	else
    		System.out.print("Congratulations, you win.");
    }

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int pileSIZE =  (int) (Math.random() * 91) + 10;
    	System.out.printf("The pile generated is %d \n", pileSIZE);
    	int whoStartFirst = (int) (Math.random()*2); // 0 <-- Player, 1 <-- COM
    	int playerChosenNum = 0; //declare
    	int comChosenNum = 0; //declare
    	int comDIFF = (int) (Math.random()*2); // smart or stupid
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


/** 	Test Cases
 * 
 * 
The pile generated is 47 
The computer is stupid.
COM Moves.
COM chosen number : 20 
The pile size is 27 .
Player number : 0
Please don't cheat. Choose at most half of the pile!
Player number : -2
Please don't cheat. Choose at most half of the pile!
Player number : 15
Please don't cheat. Choose at most half of the pile!
Player number : 13

The pile size is 14 .

COM Moves.
COM chosen number : 4 
The pile size is 10 .
Player number : 5

The pile size is 5 .

COM Moves.
COM chosen number : 1 
The pile size is 4 .
Player number : 1

The pile size is 3 .

COM Moves.
COM chosen number : 1 
The pile size is 2 .
Player number : 1

The pile size is 1 .

COM Moves.
COM chosen number : 1 
Congratulations, you win.%     

 */