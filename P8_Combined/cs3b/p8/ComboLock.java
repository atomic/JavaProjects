package cs3b.p8;

import java.util.Arrays;

/**
 * The class works like the combination lock
 * @author Tony Lim
 *
 */
public class ComboLock {
    private int [] combinations = new int[3];
    private int [] combinationsAttemps = {0,0,0};
    private int tracker = 0;

    public void displayComb() {
	System.out.println("The correct combination for the locker is " + Arrays.toString(combinations));
    }
    public void display() {
	System.out.println("Currently rotating digit " + (tracker + 1) );
	System.out.println("Your current combinations are : " + Arrays.toString(combinationsAttemps));
    }
    public void announce() {
	if(tracker == 0 || tracker == 1)
	    System.out.println("Digit " + tracker + " unlocked.");
	else
	    System.out.println("Congratulations, Locker has been unlocked.");
    }

    public ComboLock(int secret1, int secret2, int secret3) {
	combinations[0] = secret1;
	combinations[1] = secret2;
	combinations[2] = secret3;
    }
    
    public ComboLock() { this(0,0,0); } //this constr
    
    public boolean turnLeft(int ticks) {
	combinationsAttemps[tracker] -= ticks;
	while(combinationsAttemps[tracker]< 0)
	    combinationsAttemps[tracker] += 40; //make sure that its always positive

	if(combinations[tracker] == combinationsAttemps[tracker]) {
	    if(tracker == 1) {
		announce();
		tracker++;
	    }
	    // else if the tracker is one, it can only unlocks from turning right
	}
	return tracker == 3 ? true : false;
    }

    public boolean turnRight(int ticks) {
	combinationsAttemps[tracker] += ticks;
	combinationsAttemps[tracker] %= 40; //make sure that the numbers are between 0-39
	if(combinations[tracker] == combinationsAttemps[tracker]) {
	    if(tracker != 1) {
		announce();
		tracker++;
	    }
	}
	return tracker == 3 ? true : false;
    }
}
