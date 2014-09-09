import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 9, 2014
 * Assignment : P6.7
 * Description : Method to reverse an array
 */


public class reverseArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> intArray = new ArrayList<>();
		
		String option;
		boolean done = false;
		do {
			System.out.print("Please enter a list of integer(end it with non integer) : ");
			while(in.hasNextInt())
				intArray.add(in.nextInt());
			in.next(); // to flush the extra inputs
			System.out.println("Inputs : " + intArray.toString());
			reverseArrayList(intArray);
			System.out.println("After reversed : " + intArray.toString());

			intArray.clear();
			System.out.print("are you done (y/n) : ");
			option = in.next();
			done = (option.equals("y") ? true : false);
		} while (!done);
		in.close();
		System.out.print("Cosing Program...");
	}

	/**
	 * The function will reverse an ArrayList (a mutator function)
	 * @param L : the ArrayList to be reversed
	 */
	public static void reverseArrayList(ArrayList<Integer> L) {
		if(L.size() < 2)
			return;
		int temp = 0;
		int frontIndex = 0;
		int lastIndex = L.size() - 1;

		while(frontIndex < lastIndex) { //these marker will meet in the middle of the array
			temp = L.get(frontIndex);
			L.set(frontIndex, L.get(lastIndex));
			L.set(lastIndex, temp);
			frontIndex++;
			lastIndex--;
		}
	}
}

/**  	------------- TEST CASES ----------
 * @assumptions : the inputs of the array is integer
 * @preconditions : none

Test Cases:

Please enter a list of integer(end it with non integer) : 1 2 3 4 5 a
Inputs : [1, 2, 3, 4, 5]
After reversed : [5, 4, 3, 2, 1]
are you done (y/n) : n
Please enter a list of integer(end it with non integer) : 1 -2 23 92 199 1223 123 asjfsf
Inputs : [1, -2, 23, 92, 199, 1223, 123]
After reversed : [123, 1223, 199, 92, 23, -2, 1]
are you done (y/n) : y
Cosing Program...



*/