import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/* Name : Tony Lim
 * Date : Aug 27, 2014
 * Assignment : Page 72, P2.10
 * Description : 
 */

public class carCost {

	public static void main(String[] args) {
		/**
		 * From "http://www.kbb.com/new-cars/total-cost-of-ownership/",
		 * the average depreciation value is 44%, so let's make this a constant.
		 */
		final double AVG_DEPRECIATE_VAL = 0.44;
		
		
		// In a separate text file, i will provide an example of info about a Hybrid car and non-hybrid car
		try {
			BufferedReader br = new BufferedReader(new FileReader("carExample.txt"));
			String line = null;
			while ((line = br.readLine()) != null)
				System.out.println(line);
			br.close();
		} catch (Exception e) {
			System.err.println("The file does not exist.");
		}


		Scanner in = new Scanner(System.in);
		System.out.printf("Car cost : ");
		double carCost = in.nextDouble();
		System.out.printf("Estimated miles driven per year : ");
		double miles = in.nextDouble();
		System.out.printf("Estimated gas price : ");
		double gasPrice = in.nextDouble();
		System.out.printf("Efficiency in miles per galon : ");
		double efficiency = in.nextDouble();
		
		
		double deprecVal = AVG_DEPRECIATE_VAL*carCost;
		System.out.printf("Estimated resale value after 5 years (calculated automatically : %.2f", carCost - deprecVal);

		double galonUsed = miles/efficiency* 5;
		double totalGasPrice = galonUsed*gasPrice;
		
		System.out.println();
		System.out.printf("The cost of the car in 5 years is $ %.2f", totalGasPrice + carCost + deprecVal);
		
		in.close();
	}

}
