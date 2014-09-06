import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 4, 2014
 * Assignment : P5.26
 * Description : The program will convert barcode to number
 */

/**
 * Pseudo-code:
 * 1) Process the barcode into 2 dimensional arrays of boolean value
 * 2) each row contains 5 integers, next step is to get 5 digits from these arrays as the zipcode
 */
public class barToZip {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String barCode;
	String zipCode;

	String option;
	boolean done = false;
	do {
	    barCode = getBarCodeInput();
	    zipCode = getFullZip(barCode);
	    
	    if(checkValid(getProcessedBarcode(barCode)))
		System.out.println("The number zipCode is : " + zipCode);
	    else
		System.out.println("The barcode is invalid.");

	    System.out.print("are you done (y/n) : ");
	    option = in.next();
	    done = (option.equals("y") ? true : false);
	} while (!done);
	in.close();
	System.out.print("Cosing Program...");
    }

    /**
     * This is the primary function that processed input of full barcode
     *  The function will call sub-function that handles different task
     * @param barCode
     * @return a 5-digit String of number zipcode
     */
    public static String getFullZip(String barCode) {
	String zipCode = "";
	boolean[][] boolBarCode = getProcessedBarcode(barCode);
	for(int i = 0; i < 5; i++)
	    zipCode += getOneZip(boolBarCode[i]);
	 return zipCode;   
    }
    
    
    /**
     * To process the string, we need to know the index of each corresponding zipcode
     * 	start at index 1, end at index 25 , last few barcodes does not matter
     * 	using for loop, we can use multiplicity of five to get the barcode and fill the boolean array
     * @param barCode
     * @return
     */
    public static boolean[][] getProcessedBarcode(String barCode) {
	boolean[][] boolBarCode = new boolean[5][5];
	for (int i = 0; i < 5; i++)
	   for(int j = 0; j < 5; j++)
	       boolBarCode[i][j] = (barCode.charAt(i*5 + j + 1) == '|' ? true : false);
	return boolBarCode;
    }
    
    /**
     * To process one digit of the zipcode, 
     * 	its helpful to have reference the weight of each barcode
     * 	using array of integer makes sense, so that boolean array can be processed faster
     * @param boolBar : array of true or false whether the 5 digit bar is full or half
     * @return one number digit of the zip
     */
    public static int getOneZip(boolean[] boolBar) {
	final int[] weight = {7, 4, 2, 1, 0};
	int theZip = 0;
	for (int i = 0; i < boolBar.length; i++)
	    theZip += (boolBar[i] ? weight[i] : 0);
	return theZip == 11? 0 : theZip;
    }

    /** 
     * A function to easily get input and check if the input is invalid or not
     * @return a string of valid barcode
     */
    public static String getBarCodeInput() {
	Scanner in = new Scanner(System.in);
	System.out.print("Input the full barcode : ");
	String barCode = in.next();
	if(barCode.length() != 32) {
	    System.out.print("Invalid barcode(length).\n");
	    return getBarCodeInput();
	}
	else
	    return barCode;
    }

    /**
     * This function is to check whether a boolBarcode is valid
     *  by looping through the array and increase the counter every time full bar is found
     *  when counter is larger than 2 by the end of scanning one zip, return false
     * @param boolBarCode
     * @return
     */
    public static boolean checkValid(boolean[][] boolBarCode) {
	int counter = 0; // this counter must not exceed 2 and there must be exactly 2 full bar in each zip
	for (boolean[] bs : boolBarCode) {
	    for (boolean b : bs)
		counter += (b ? 1 : 0);
	    if(counter != 2)
		return false;
	    counter = 0;
	}
	return true;
    }
}


/** TEST CASE 

Input the full barcode : ||:|:::|:|:||::::::||:|::|:::|||
The number zipCode is : 95014
are you done (y/n) : n
Input the full barcode : ||:|:::|:|:||:::||:||:|::|:::|||
The barcode is invalid.
are you done (y/n) : y
Cosing Program...

*/