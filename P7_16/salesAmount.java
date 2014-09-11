import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 10, 2014
 * Assignment : P7.16
 * Description : The program reads input from file and calculate the total sales of certain services
 */


public class salesAmount {

    public static void main(String[] args) throws FileNotFoundException {
	File inputFile;
	String fileName; //if doesnt passed as argument
	if(args.length == 1)
	    inputFile = new File(args[0]); //The program should run with text inputs
	else {
	    Scanner in = new Scanner(System.in);
	    System.out.print("Input the sales files name : I");
	    fileName = in.next();
	    
	    // Automatic resources management in Java 7 (Read page 346)
	    try (Scanner fin = new Scanner(fileName)) {
	    	System.out.println("Open file succeed.");
	    }
	}

    }

}