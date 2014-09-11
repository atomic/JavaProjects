import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/* Name : Tony Lin, William Randazzo
 * Date : Sep 11, 2014
 * Assignment : Lab 5, ZipReader
 * Description : Convert zipcode to standard
 */


public class ZipsReader {

	public static void main(String[] args) throws FileNotFoundException {
		
		File inputFile = new File("ziptable.txt");
	    Scanner in = new Scanner(inputFile);
	    ArrayList<String> unformattedLines = new ArrayList<>();
	    while(in.hasNextLine())
	    	unformattedLines.add(in.nextLine());
		
//	    //debug
//	    for (String string : unformattedLines)
//			System.out.println(string); //working
	    
	    formatAllLines(unformattedLines);

	    File outputFile = new File("output.txt");
	    PrintWriter fout = new PrintWriter(outputFile);

	    for (String string : unformattedLines) {
			System.out.println(string); //just debug for console display
			fout.println(string);
	    }
	    
	    //closing files
	    in.close();
	    fout.close();
	}
	
	/**
	 * This function mutates every elements of the ArrayList
	 *  for every string, it is formatted to standard format of zipcode
	 * @param inputLines : arraylist containing each lines of the input from text files
	 */
	public static void formatAllLines(ArrayList<String> inputLines) {
		for (int i = 0; i < inputLines.size(); i++)
			inputLines.set(i, formatOneLine(inputLines.get(i)));
	}
	
	/**
	 * The function will format one line and return the formatted string
	 * @param Line : initial unformatted line
	 * @return formatted line
	 */
	public static String formatOneLine(String Line) {
		Scanner stringStream = new Scanner(Line);
		ArrayList<String> tokens = new ArrayList<>();
		while(stringStream.hasNext())
			tokens.add(stringStream.next());// move every token to the arraylist
		
		String formattedLine = "";

		//this will convert every tokens from the unformatted array of tokens to complete string
		for(int i = 0; i < tokens.size(); i++) {
			if(tokens.get(i).matches("\\d{3}"))
				formattedLine += convertToStandard(tokens.get(i)) + " ";
			else
				formattedLine += tokens.get(i) + " ";
		}
		stringStream.close();
		return formattedLine;
	}
	
	/**
	 * Just convert 3digit to 3-3 digit
	 * @param token
	 * @return converted token
	 */
	public static String convertToStandard(String token) {
		return token + "-" + token;
	}
}


/**  	------------- TEST CASES ----------
 * @assumptions : none
 * @preconditions : none

Test Cases: these are the formatted output from the files


AL Alabama 350-369 
AK Alaska 995-999 
AS American Samoa 967-967 
AZ Arizona 850-865 
AR Arkansas 716-729 755-755 
CA California 900-966 
CO Colorado 800-816 
CT Connecticut 060-069 
DE Delaware 197-199 
DC District of Columbia 200-205 
FM FS of Micronesia 969-969 
FL Florida 320-349 
GA Georgia 300-319 398-399 
GU Guam 969-969 
HI Hawaii 967-968 
ID Idaho 832-838 
IL Illinois 600-629 
IN Indiana 460-479 
IA Iowa 500-528 
KS Kansas 660-679 
KY Kentucky 400-427 
LA Louisiana 700-714 
ME Maine 039-049 
MH Marshall Islands 969-969 
MD Maryland 206-219 
MA Massachusetts 010-027 055-055 
MI Michigan 480-499 
MN Minnesota 550-567 
MS Mississippi 386-397 
MO Missouri 630-658 
MT Montana 590-599 
NE Nebraska 680-693 
NV Nevada 889-898 
NH New Hampshire 030-039 
NJ New Jersey 070-089 
NM New Mexico 870-884 
NY New York 005-005 063-063 090-149 
NC North Carolina 269-289 
ND North Dakota 580-588 
MP N. Mariana Islands 969-969 
OH Ohio 430-459 
OK Oklahoma 730-749 
OR Oregon 970-979 
PW Palau Island 969-969 
PA Pennsylvania 150-196 
PR Puerto Rico 006-009 
RI Rhode Island 028-029 
SC South Carolina 290-299 
SD South Dakota 570-577 
TN Tennessee 370-385 
TX Texas 750-799 885-885 
UT Utah 840-847 
VT Vermont 050-059 
VA Virginia 201-201 220-246 
VI Virgin Islands 008-008 
WA Washington 980-994 
WI Wisconsin 530-549 
WV West Virginia 247-268 
WY Wyoming 820-831 



*/