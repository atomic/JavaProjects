import java.util.Scanner;

/* Name : Tony Lim
 * Date : Aug 27, 2014
 * Assignment : Page 72, P2.10
 * Description : 
 */

public class carCost {
	public static double resaleValueInFiveY(double initial, double miles,
										  double pricePG, double efficiencyMPG, double depreciatedBy) {
		double totalCost = initial; //This should be 0 ? since the initial cost of the car does not matter
		double galonUsed = miles/efficiencyMPG * 5;
		double totalGasPrice = galonUsed*pricePG;
		return totalGasPrice + depreciatedBy;
	}
	public static void main(String[] args) {
		Scanner System.out,print(""); = new Scanner(System.in);
		System.out.printf("Car cost : ");
		double carCost = in.nextDouble();
		System.out.printf("Estimated miles driven per year : ");
		double miles = in.nextDouble();
		System.out.printf("Estimated gas price : ");
		double gasPrice = in.nextDouble();
		System.out.printf("Efficiency in miles per galon : ");
		double efficiency = in.nextDouble();
		System.out.printf("Estimated resale value after 5 years: ");
		double resaleInFiveYear = in.nextDouble();
		System.out.print("awdawdawd");
	}
}
