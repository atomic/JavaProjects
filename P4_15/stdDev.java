import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 3, 2014
 * Assignment : P4.15
 * Description : The program is used to calculate mean and standard deviation from values of inputs
 * 		To calculate the stddev, this program will use the less stable formula (Pg 190)
 */


public class stdDev {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter sets of values in floating numbers and end with alphabet.");
	System.out.print(">>> ");
	float tempValue;
	float sum = 0;
	float squareXSum = 0; // This is \Sigma{x_i^2}
	int n = 0;
	while (in.hasNextFloat()) {
	    tempValue = in.nextFloat();
	    sum += tempValue;
	    squareXSum += Math.pow(tempValue, 2);
	    n++; 
	}
	float average = sum/n;
	double stdDev = Math.sqrt( (squareXSum - Math.pow(sum, 2)/n)/(n-1) ); //this is the full expression of stdDev
	
	System.out.printf("The number of value inputted is %d\n", n);
	System.out.printf("The average is %.2f\n", average);
	System.out.printf("The StdDev is %.2f\n", stdDev);
	in.close();
    }

}

/** TEST CASE
 * 

Please enter sets of values in floating numbers and end with alphabet.
>>> 2 3 4 5 x
The number of value inputted is 4
The average is 3.50
The StdDev is 1.29

Please enter sets of values in floating numbers and end with alphabet.
>>> 3.5 6.7 2.5 9 0.1 -5.5 1.2
x
The number of value inputted is 7
The average is 2.50
The StdDev is 4.70


>>> 2 1 5 99 102 20      x
The number of value inputted is 6
The average is 38.17
The StdDev is 48.77


 */