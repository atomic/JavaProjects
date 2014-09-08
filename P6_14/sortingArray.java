import java.util.Arrays;


/* Name : Tony Lim
 * Date : Sep 7, 2014
 * Assignment : P6.14
 * Description : the program demonstrates how to generate random numbers and sort and arrays
 */


public class sortingArray {
    public static void main(String[] args) {
	int [] randomArray = new int[20]; //declare and allocate 20 spaces

	for (int i = 0; i < randomArray.length; i++) //for each element in the array
	    randomArray[i] = (int) (Math.random()*100); // this generate random numbers from 0-99

	System.out.println("Here are unsorted arrayys : " + Arrays.toString(randomArray));

	Arrays.sort(randomArray); // using Java's standard sort method

	System.out.println("Here are sorted arrays : " + Arrays.toString(randomArray));
    }
}

/** TEST CASES 

Here are unsorted arrayys : [39, 1, 30, 67, 44, 71, 19, 83, 83, 3, 37, 19, 8, 68, 55, 11, 1, 98, 46, 64]
Here are sorted arrays : [1, 1, 3, 8, 11, 19, 19, 30, 37, 39, 44, 46, 55, 64, 67, 68, 71, 83, 83, 98]

Here are unsorted arrayys : [39, 16, 87, 38, 74, 4, 2, 17, 44, 34, 89, 82, 91, 14, 27, 52, 4, 20, 37, 37]
Here are sorted arrays : [2, 4, 4, 14, 16, 17, 20, 27, 34, 37, 37, 38, 39, 44, 52, 74, 82, 87, 89, 91]

Here are unsorted arrayys : [71, 47, 91, 43, 75, 80, 23, 46, 52, 99, 91, 25, 17, 39, 89, 77, 85, 83, 1, 64]
Here are sorted arrays : [1, 17, 23, 25, 39, 43, 46, 47, 52, 64, 71, 75, 77, 80, 83, 85, 89, 91, 91, 99]

*/