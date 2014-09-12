import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* Name : Tony Lim
 * Date : Sep 10, 2014
 * Assignment : P7.16
 * Description : The program reads input from file and calculate the total sales of certain services
 */


public class salesAmount {

    public static void main(String[] args) {
    	
	String fileName = "";
	if(args.length == 1)
	    fileName = args[0]; //The program should run with text inputs
	else
		fileName = getFileName(); //if no argument is passed in

	ArrayList<String[]> salesDatabase = new ArrayList<>(); //making a table that stores the data
	//this will get the inputs from the files, and store each elements to the table accordingly
	try (Scanner fin = new Scanner(new File(fileName))) { //Java 7
		System.out.println("Open file succeed.");  //if open files succeed
		while(fin.hasNextLine())
			salesDatabase.add(fin.nextLine().split(":")); //splitting the text to discrete information

		for (String[] entry : salesDatabase) //Checking if the input format is not correct
			if(entry.length < 4)
				throw new NumberFormatException("Format incorrect : " + Arrays.toString(entry));
		}
	catch (FileNotFoundException e) { //if not found, do this
		System.out.println("Invalid file.\n" + "The file name is sales_data.dat"); 
		}
	catch (NumberFormatException e) {
		System.out.println(e.getMessage());
	}
	
	//Now, calculate the amount of sales for each category using extracted data in "salesDatabase"
	//first, extract the lists of category that exists in the database
	ArrayList<String> categories = getCategories(salesDatabase);
	double[] salesAmount = fillAmounts(categories, salesDatabase);
	
	//now display the result
	for(int i = 0; i < categories.size(); i++)
		System.out.println(categories.get(i) + " has a total sale of $" + salesAmount[i]);
    }

    /**
     * The function will generate an array of integers that is filled with value corresponding to specific categories
     * The algorithm will be: (NOTE: this is very inefficient, use hashmap in the future)
     *  for every category -> find occurance of this category in database 
     *  				   -> add its value to corresponding index in integer array
     *  Note: alternatively -> use " Map<String, Integer> = new HashMap<String, Integer>();
     *  
     * @param categories : the list of collected category from database
     * @param database : big database containing the informations from the text input
     * @return integer array with the full amounts of amounts corresponding to categories
     */
    public static double[] fillAmounts(ArrayList<String> categories, ArrayList<String[]> database) {
    	double[] totalSales = new double[categories.size()]; //NOTE : default value of integer in array is 0
    	for (int i = 0; i < categories.size(); i++) // complexity : ~n^2
    		for (String[] entry : database)
				if(entry[1].equals(categories.get(i)))
					totalSales[i] += Double.parseDouble(entry[2]);
    	return totalSales;
	}
    	
    /**
     * This will get all the category that exist in a database
     * @param database
     * @return ArrayList of string containing the name of each category
     */
    public static ArrayList<String> getCategories(ArrayList<String[]> database) {
    	ArrayList<String> categories = new ArrayList<>();
    	for (String[] entry : database) {
    		if(!categories.contains(entry[1])) //if a category does exist in the arrayList
    			categories.add(entry[1]);		// add to arraylist, else move on
		}
    	return categories;
    }

    /**
     * The function will ask user to get the correct file name
     * @return filename in string
     */
    public static String getFileName() {
		Scanner in = new Scanner(System.in);
	    System.out.print("Input the sales files name : ");
	    if(in.hasNext())
	    	return in.next();
	    else
	    	return getFileName();
    }
}

/**  	------------- TEST CASES ----------
 * @assumptions : formatofinput exist
 * @preconditions : none

Test Cases:

Here are the textfile sample

Tom:Lodging:2388.00:10/2/14
Charles:Dinner:2340.00:10/2/14
Hank:Lodging:2511.00:10/3/14
Arguna:Conference:1000.0:21/3/14
Olala:Dinner:1111.5:25/2/13
Denise:Workshop:100:23/1/29

Here are the result

Open file succeed.
Lodging has a total sale of $4899.0
Dinner has a total sale of $3451.5
Conference has a total sale of $1000.0
Workshop has a total sale of $100.0

*/