import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 7, 2014
 * Assignment : P6.18
 * Description : The program ask user for 16 numbers and check if those numbers form a magic squares
 */

public class magicSquares {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	int [][] userNumbers = new int[4][4]; //initiate and allocate the numbers
	//first, ask user for 16 numbers
	int fillCol = 0; //count up to 4
	int fillRow = 0; //count up to 4
	
	//Fill the arrays
	for (int i = 0; i < 4; i++) {
	    System.out.printf("Please input 4 numbers for row %d : ", i+1 );
	    for (int j = 0; j < 4; j++) {
		if(in.hasNext())
		    userNumbers[i][j] = in.nextInt();
		else
		    j--; //if user made a mistake, have then reinput
	    }
	}

	//Display them
	System.out.println("Here are your numbers ");
	for (int[] row : userNumbers)
	    System.out.println(Arrays.toString(row));
	
	if(checkMagicSquares(userNumbers))
	    System.out.println("Your matrix is a magic squares.");
	else
	    System.out.println("Your matrix is not a magic squares.");

	in.close(); //closing input stream
    }
    
    /**
     * The function is used to calculate the sum of numbers in one dimensional array
     * @param row : 1 dimensional array of integer
     * @return the sum of all the numbers
     */
    public static int rowSum(int [] row) {
	int sum = 0;
	for (int i : row)
	    sum += i;
	return sum;
    }
    
    /**
     * This is the core function to find out whether a matrix is magicSquares or not
     * Method :
     * 	 1) Verify the sum of the rows first (with the helper function)
     * 	 2) Then, verify the sum of the colomns  (manually adding)
     *   3) If the matrix pass all verification, return true
     * @param matrix : the 4x4 number inputs from user
     * @return true or false that the matrix is magic squares
     */
    public static boolean checkMagicSquares(int [][] matrix) {
	//first, check the sum of the rows
	int checkSum = 0; // sentinel value, this is used to check following calculations
	checkSum = rowSum(matrix[0]); // make first row as the pivot sum
	for (int i = 1; i < 4; i++)
	    if( checkSum != rowSum(matrix[i]) )
	    	return false; //tag as false when encounter first difference
	    
	//now, check the sum of colums
	int colSum = 0; //to calculate sum of columsm, i must calculate manually
	
	//pay attention to i,j order here
	//see that i changes first, then j
	for (int j = 0; j < 4; j++) {
	    colSum = 0; // reset the counter so the sum does not accumulate for next round
	    for (int i = 0; i < 4; i++)
		colSum += matrix[i][j];
	    if(colSum != checkSum)
		return false; // if sum does not match the roe sum, return false}
	}
	return true; //the matrix pass all tests, so return true
    }

}
/**  	-------------TEST CASES ----------
 * @assumptions : input is 16 numbers, or 4x4
 * @preconditions : none
  
Please input 4 numbers for row 1 : 16 3 2 13
Please input 4 numbers for row 2 : 5 10 11 8
Please input 4 numbers for row 3 : 9 6 7 12
Please input 4 numbers for row 4 : 4 15 14 1
Here are your numbers 
[16, 3, 2, 13]
[5, 10, 11, 8]
[9, 6, 7, 12]
[4, 15, 14, 1]
Your matrix is a magic squares.


Please input 4 numbers for row 1 : 1 2 3 4
Please input 4 numbers for row 2 : 5 6 3 1
Please input 4 numbers for row 3 : 2 3 2 1
Please input 4 numbers for row 4 : 1 1 1 1
Here are your numbers 
[1, 2, 3, 4]
[5, 6, 3, 1]
[2, 3, 2, 1]
[1, 1, 1, 1]
Your matrix is not a magic squares.


*/
