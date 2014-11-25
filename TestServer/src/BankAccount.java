import javafx.scene.AmbientLight;


public class BankAccount
{
	private double balance;
	private int accountNumber;
	private static int lastAssignedNumber = 1000;
	
	public BankAccount()
	{
		lastAssignedNumber++;
		accountNumber = lastAssignedNumber;
	}
	
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	public void withdraw(double amount)
	{
		balance -= amount;
	}
	
	public double getBalance()
	{
		return balance;
	}
}