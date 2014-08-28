import java.util.Scanner;


/**
 * 
 * @author Tony LIm
 * @description Calculating tip for restaurant
 *
 */
public class calcTip {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please input your satisfaction rating : ");
		int rating = in.nextInt();
		System.out.print("Please input your meal price : ");
		double price= in.nextDouble();
		
		//debug
		System.out.println(price);
		System.out.println(rating);

		double percentTip = 0.0;
		switch (rating) {
		case 1:
			percentTip = 20.0/100.0;
			break;
		case 2:
			percentTip = 15/100.0;
			break;
		case 3:
			percentTip = 10/100.0;
			break;
		default:
			break;
		}
		
		double tip = price*percentTip;
		System.out.printf("Your satisfaction rating is %d .", rating);
		System.out.printf("You should pay %.2f for the tip.", tip);
	}

}
