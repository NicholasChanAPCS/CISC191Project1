import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TransitionGUI
{
	private JFrame frame;
	private static String user;

	public TransitionGUI()
	{
		////OPEN BALANCE WINDOW AND CONNECT ALL GUIS TOGETHER
		frame = new JFrame();
		JButton shop = new JButton("Shop");
		JButton pay = new JButton("Pay");
		frame.setLayout(null);
		shop.setBounds(30, 45, 75, 50);
		pay.setBounds(180, 45, 75, 50);
		frame.add(pay);
		frame.add(shop);
		pay.addActionListener(new payWindow());
		shop.addActionListener(new shopWindow());
		frame.setSize(300,175);
		frame.setVisible(true);
		
	}
	public static void setUser(String newUser)
	{
		user = newUser;
	}
	private class payWindow implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent e)
		{				
			frame.dispose();
			UserDashboardGui.setUser(user);
			new UserDashboardGui();			
		}
	}
	private class shopWindow implements ActionListener
	{	
		@Override
		public void actionPerformed(ActionEvent e)
		{				
			frame.dispose();
			ShoppingWindow.setUser(user);
			new ShoppingWindow();			
		}
	}


	public static void main(String[] args)
	{
		TransitionGUI window = new TransitionGUI();
	}
}