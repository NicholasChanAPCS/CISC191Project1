import java.util.ArrayList;

public class Purchase extends Balance
{
	static ArrayList<Integer> cart = new ArrayList<Integer>();
	
	public static void addToCart(int item)
	{
		cart.add(item);
	}
	public static void checkOut()
	{
		for(int i = 0; i < cart.size(); i++)
		{
			addToBalance(cart.get(i));
		}
	}
	public static int cartTotal()
	{
		int total = 0;
		for(int i = 0; i < cart.size(); i++)
		{
			total += cart.get(i);
		}
		return total;
	}

}
