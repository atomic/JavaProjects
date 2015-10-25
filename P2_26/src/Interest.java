/* Name: Joseph Park, Tony Salim, Group 11
 * Date: August 26, 2014
 * Assignment: Lab 1
 * Description: Calculates the final amount of a bank balance
 */

import java.util.Scanner; //Import Scanner
public class Interest {
	static Scanner in = new Scanner(System.in); //Object to read inputs
	static final int COMPOUND = 12; //constant for compounded 
	static final int TOTAL_MONTHS = 12; //constant for total time
	public static void main(String[] args){
		CalculateInterest();
	}
	
	public static double GetInitialAmount(){ //Get Initial Amount
		System.out.print("Enter Initial Amount: ");
		return in.nextDouble();
	}
	
	public static double GetInterestRate(){ //Get Interest Rate
		System.out.print("Enter Interest Rate: ");
		return in.nextDouble();
	}
	//Calculates the Final Amount using A = P(1 + r/n)^nt on a per month basis
	public static double CalculateFinal(double initialAmount, double interestRate, int timesPerYear, int numOfMonths){
		double interestRateFixed = interestRate / 100.0;	//Convert Interest Rate to decimal	
		return initialAmount * Math.pow((1 + (interestRateFixed / timesPerYear)), timesPerYear * (1 / 12.0) * numOfMonths);
	}
	//Stores the amounts in an array for easy access and storage. 
	public static double[] StoreArray(double initialAmount, double interestRate, int timesPerYear, int totalMonths){
		double[] FinalAmounts = new double[totalMonths];//Allocating dynamic memory
		for(int i = 0; i < totalMonths; i++){//Calculates the final amount after each month
			FinalAmounts[i] = CalculateFinal(initialAmount,interestRate,timesPerYear,i + 1);
		}
		return FinalAmounts;
	}
	//Prints the final amounts after each month
	public static void Print(double[] FinalAmounts, double initialAmount, double interestRate, int timesPerYear, int totalMonths){
		System.out.printf("Initial Balance: %.2f\nAnnual Interest Rate: %.2f\nNumber of Times Compounded Per Year: %d\nNumber Of Months: %d\n\n",initialAmount,interestRate,timesPerYear,totalMonths);
		for(int i = 0; i < totalMonths; i++){
			System.out.printf("After Month %d: $%.2f\n",i + 1,FinalAmounts[i]);
		}
	}
	//Main function that calculates interest
	public static void CalculateInterest(){
		double initial = GetInitialAmount();
		double interest = GetInterestRate();
		double[] amountList = StoreArray(initial,interest,COMPOUND,TOTAL_MONTHS);
		Print(amountList,initial,interest,COMPOUND,TOTAL_MONTHS);
	}
}
/*
Enter Initial Amount: 1000
Enter Interest Rate: 6
Initial Balance: 1000.00
Annual Interest Rate: 6.00
Number of Times Compounded Per Year: 12
Number Of Months: 12

After Month 1: $1005.00
After Month 2: $1010.02
After Month 3: $1015.08
After Month 4: $1020.15
After Month 5: $1025.25
After Month 6: $1030.38
After Month 7: $1035.53
After Month 8: $1040.71
After Month 9: $1045.91
After Month 10: $1051.14
After Month 11: $1056.40
After Month 12: $1061.68
*/