import java.util.Scanner;

/* Name : Tony LIm
 * Date : Aug 29, 2014
 * Assignment : Page 72, P2.25
 * Description : the program process the changes in dollars, quarters , dimes ,nickels, and pennies
 */

public class givingChange {

	public static int getChanges(Double changes, int inWhat) {
		int changesInt = (int)(changes*100);

		switch (inWhat) {
			case 1   : return (((changesInt % 100) % 25) % 10) % 5 ;
			case 5   : return (((changesInt % 100) % 25) % 10) / 5 ;
			case 10  : return ((changesInt % 100) % 25) / 10       ;
			case 25  : return (changesInt % 100) / 25              ;
			case 100 : return changesInt / 100                     ;
			default: return 0;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Amount due : ");
		double amountDue = in.nextDouble();
		
		System.out.print("Costumer paid : ");
		double amountPaid = in.nextDouble();

		double changes = amountPaid - amountDue;
		System.out.printf("The total changes is %.2f dollars", changes);
		System.out.printf("\nChange in pennies : %d", getChanges(changes, 1));
		System.out.printf("\nChange in nickels : %d", getChanges(changes, 5));
		System.out.printf("\nChange in dimes   : %d", getChanges(changes, 10));
		System.out.printf("\nChange in quarters: %d", getChanges(changes, 25));
		System.out.printf("\nChange in dollars : %d", getChanges(changes, 100));
		
		in.close();
	}

}
