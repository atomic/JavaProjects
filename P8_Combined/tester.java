import java.util.Scanner;

import cs3b.p8.*; //import every class from this package
/* Name : Tony Lim
 * Date : Sep 17, 2014
 * Assignment : P8.9, P8.11, P8.13, P8.27
 * Description : Definition of each class is in each class file
 */


public class tester {

    public static void main(String[] args) {
	//test comboLock;
	testComboLock();
    }

    public static void testComboLock() {
	Scanner in = new Scanner(System.in);
	System.out.println("Choose 3 number to be used as the combinations : ");
	ComboLock testLock = new ComboLock(in.nextInt(), in.nextInt(), in.nextInt());

	testLock.displayComb();
	int steps = 0;
	String option;
	boolean done = false;
	do {
	    testLock.display();
	    System.out.print("choose to rotate left or right by a number (ex : L 3 or R 12) : ");
	    option = in.next();
	    steps = in.nextInt();
	    
	    done = option.equals("L") ? testLock.turnLeft(steps) : testLock.turnRight(steps);
	} while (!done);
	in.close();
	System.out.print("Test Combo Lock completed . . .");
    }
    //test case Below
}

/**  	------------- TEST CASES ----------

        ------------- Test Cases: for "ComboLock"
Choose 3 number to be used as the combinations : 
2 3 4
The correct combination for the locker is [2, 3, 4]
Currently rotating digit 1
Your current combinations are : [0, 0, 0]
choose to rotate left or right by a number (ex : L 3 or R 12) : R 1
Currently rotating digit 1
Your current combinations are : [1, 0, 0]
choose to rotate left or right by a number (ex : L 3 or R 12) : R 1
Digit 0 unlocked.
Currently rotating digit 2
Your current combinations are : [2, 0, 0]
choose to rotate left or right by a number (ex : L 3 or R 12) : R 2
Currently rotating digit 2
Your current combinations are : [2, 2, 0]
choose to rotate left or right by a number (ex : L 3 or R 12) : R 1
Currently rotating digit 2
Your current combinations are : [2, 3, 0]
choose to rotate left or right by a number (ex : L 3 or R 12) : R 4
Currently rotating digit 2
Your current combinations are : [2, 7, 0]
choose to rotate left or right by a number (ex : L 3 or R 12) : R 2
Currently rotating digit 2
Your current combinations are : [2, 9, 0]
choose to rotate left or right by a number (ex : L 3 or R 12) : L 5
Currently rotating digit 2
Your current combinations are : [2, 4, 0]
choose to rotate left or right by a number (ex : L 3 or R 12) : L 5
Currently rotating digit 2
Your current combinations are : [2, 39, 0]
choose to rotate left or right by a number (ex : L 3 or R 12) : R 6
Currently rotating digit 2
Your current combinations are : [2, 5, 0]
choose to rotate left or right by a number (ex : L 3 or R 12) : L 2
Digit 1 unlocked.
Currently rotating digit 3
Your current combinations are : [2, 3, 0]
choose to rotate left or right by a number (ex : L 3 or R 12) : R 5
Currently rotating digit 3
Your current combinations are : [2, 3, 5]
choose to rotate left or right by a number (ex : L 3 or R 12) : L 1
Currently rotating digit 3
Your current combinations are : [2, 3, 4]
choose to rotate left or right by a number (ex : L 3 or R 12) : L 1
Currently rotating digit 3
Your current combinations are : [2, 3, 5]
choose to rotate left or right by a number (ex : L 3 or R 12) : L 2
Currently rotating digit 3
Your current combinations are : [2, 3, 3]
choose to rotate left or right by a number (ex : L 3 or R 12) : L 2
Currently rotating digit 3
Your current combinations are : [2, 3, 1]
choose to rotate left or right by a number (ex : L 3 or R 12) : R 3
Congratulations, Locker has been unlocked.
Test Combo Lock completed . . .


*/