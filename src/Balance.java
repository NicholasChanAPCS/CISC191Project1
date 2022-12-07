
public class Balance extends Client
{
	public void payBill(int number)
	{
		balance = balance - number;
		System.out.println("Thank you, your new balance is: " + balance + ".");		
	}
	public int balanceDue()
	{
		return balance;
	}
	public static void addToBalance(int amount)
	{
		balance += amount;
	}
	public void subtractFromBalance(int amount)
	{
		balance -= amount;
	}

}
