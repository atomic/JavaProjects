import java.io.IOException;
import java.util.Formattable;
import java.util.Formatter;


public class BankAccount implements Formattable{

	private double balance;
	private int accountNumber;
	private static int lastAssignedNumber = 1000; // keep track of BankAccount
	
	public BankAccount() {
		lastAssignedNumber++;
		accountNumber = lastAssignedNumber;
		balance = 0;
	}
	
	public BankAccount(double initialBalance) {
		this();
		balance = initialBalance;
	}
	
	public double getBalance() {
		return balance;
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {
		StringBuilder sb = new StringBuilder();
		String out = ("" + balance);
		
		// apply precision
		int floatStartingPoint = out.indexOf('.'); //To keep track where to start cuttings
        if (precision == -1 || out.substring(floatStartingPoint).length() < precision) {
            sb.append(out);
        } else {
            sb.append(out.substring(0, floatStartingPoint + precision + 1)); //+1 for the dot
        }
        
        // apply width
        if (sb.length() > width && (width != -1))
        	sb.delete(width, sb.length() - 1);
        while(sb.length() < width)
        	sb.append(" ");

		formatter.format(sb.toString());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Account Number : " + accountNumber + "\nBalance : " + balance + "\n";
	}
}
