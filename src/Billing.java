
public class Billing extends Client
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

}
