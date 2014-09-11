import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 10, 2014
 * Assignment : P7.8
 * Description : The program will reverse a text file line by line
 */


public class Reverse {
	public static void main(String[] args) throws FileNotFoundException {
		File inputFile = new File(args[0]); //first argument is the input
		File outputFile = new File(args[1]); //second argument should be the output file

		Scanner in = new Scanner(inputFile);
		PrintWriter out = new PrintWriter(outputFile); //this empty the file
		
		ArrayList<String> stringLines = new ArrayList<>(); 

		//get string of each line to arraylist
		while(in.hasNextLine())
			stringLines.add(in.nextLine()); //note : \n by the end of the line does not get taken

		//debug
		System.out.println("Here are the strings from the file");
		for (String string : stringLines)
			System.out.println(string);

		//reverse the string, using StringBuilder library
		for (int i = 0; i < stringLines.size(); i++)
			stringLines.set(i, new StringBuilder(stringLines.get(i)).reverse().toString());
			
		//this will write the revered strings to outputfiles
		for (String string : stringLines)
			out.println(string);

		in.close();
		out.close();
	}
}
