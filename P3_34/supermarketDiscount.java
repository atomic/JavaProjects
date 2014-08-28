/**
 * @author Tony Lim
 * Decription : This is problem P3.34 page 132
 */
import java.util.Scanner;


public class supermarketDiscount {
	
    
	// This function is used to calculate the discount percentage based on spending
    public static double getDiscount(double spent) {
    	if (spent > 210.0)
    		return 14.0/100.0;
    	else if (spent > 150)
    		return 12.0/100.0;
    	else if (spent > 60)
    		return 10.0/100.0;
    	else if (spent > 10)
    		return 8.0/100.0;
    	else
    		return 0.0;
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the amount you have spent : ");
		double totalSpent = in.nextDouble();
		System.out.printf("So you spent $%.2f.", totalSpent);
		double discount = getDiscount(totalSpent);
		System.out.printf("Based on your spending, you get discount : %.2f", discount*100);
		double discountPrice = totalSpent*discount;
		System.out.printf("\nSo you get a $ %.2f discount", discountPrice);
	}
}
