import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ShoppingWindow extends JFrame
{
	/////ADD BALANCE TO THE BOTTOM CORNER AND UPDATE BALANCE IN FILES
	private int advilCount, medCount, rubbingCount, inhalerCount, epipenCount, bandaidCount, cartBal;
	private JFrame frame;
	private JLabel advilDisplay, medicalTapeDisplay, rubbingAlcoholDisplay, inhalerDisplay, cartBalance, 
	epipenDisplay, bandAidsDisplay, price, quantity, quantity2, quantity3, quantity4, quantity5, quantity6;
	private ImageIcon advil, medicalTape, rubbingAlcohol, inhaler, epipen, bandAids;
	private JLabel Advil, MedicalTape, RubbingAlcohol, Inhaler, Epipen, BandAids;
	private JButton addCart, increase, decrease, cart;
	private static String user, userDebt;
		public ShoppingWindow()
		{		
		frame = new JFrame("Shopping");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{
			increase = new JButton("ʌ");
			decrease = new JButton("v");
			increase.addActionListener(new increaseAdvil());
			decrease.addActionListener(new decreaseAdvil());
			increase.setBounds(160, 200, 41, 41);
			decrease.setBounds(65, 200, 41, 41);
			quantity = new JLabel("0");
			quantity.setBounds(132, 180 ,75,75);
			advil = new ImageIcon(getClass().getResource("advil.jpg"));
			advilDisplay = new JLabel(advil);	
			price = new JLabel("$10.00");
			price.setBounds(115, 165 , 75,75);
			advilDisplay.setBounds(50, 0, 175, 175);
			Advil = new JLabel("Advil");
			Advil.setBounds(120, 140, 100, 100);
			addCart = new JButton("Add to cart");
			addCart.setBounds(86, 255, 100, 30);
			addCart.addActionListener(new addAdvil());
			frame.add(Advil);
			frame.add(advilDisplay);
			frame.add(price);
			frame.add(increase);
			frame.add(quantity);
			frame.add(decrease);	
			frame.add(addCart);
			
			increase = new JButton("ʌ");
			decrease = new JButton("v");
			increase.addActionListener(new increaseMed());
			decrease.addActionListener(new decreaseMed());
			increase.setBounds(160, 500, 41, 41);
			decrease.setBounds(65, 500, 41, 41);
			quantity2 = new JLabel("0");
			quantity2.setBounds(130, 480, 75, 75);
			medicalTape = new ImageIcon(getClass().getResource("MedTape.jpg"));
			medicalTapeDisplay =  new JLabel(medicalTape);
			price = new JLabel("$5.00");
			price.setBounds(120, 465, 75,75);
			medicalTapeDisplay.setBounds(50, 300, 175, 175);
			frame.add(medicalTapeDisplay);
			MedicalTape = new JLabel("Medical Tape");
			MedicalTape.setBounds(100, 440, 100, 100);
			addCart = new JButton("Add to cart");
			addCart.setBounds(86, 560, 100, 30);
			addCart.addActionListener(new addMedTap());
			frame.add(MedicalTape);
			frame.add(price);
			frame.add(increase);
			frame.add(quantity2);
			frame.add(decrease);
			frame.add(addCart);
			
			increase = new JButton("ʌ");
			decrease = new JButton("v");
			increase.addActionListener(new increaseRubbing());
			decrease.addActionListener(new decreaseRubbing());
			increase.setBounds(395, 200, 41, 41);
			decrease.setBounds(290, 200, 41, 41);
			quantity3 = new JLabel("0");
			quantity3.setBounds(360, 180 ,75,75);
			price = new JLabel("$8.00");
			price.setBounds(350, 165, 75,75);
			rubbingAlcohol = new ImageIcon(getClass().getResource("rubbingAL.jpg"));
			rubbingAlcoholDisplay = new JLabel(rubbingAlcohol);
			rubbingAlcoholDisplay.setBounds(275, 0, 175, 175);
			frame.add(rubbingAlcoholDisplay);
			RubbingAlcohol = new JLabel("Rubbbing Alcohol");
			RubbingAlcohol.setBounds(320, 140, 100, 100);
			addCart = new JButton("Add to cart");
			addCart.setBounds(315, 255, 100, 30);
			addCart.addActionListener(new addRubbing());
			frame.add(RubbingAlcohol);
			frame.add(price);
			frame.add(increase);
			frame.add(quantity3);
			frame.add(decrease);
			frame.add(addCart);

			increase = new JButton("ʌ");
			decrease = new JButton("v");
			increase.addActionListener(new increaseInhaler());
			decrease.addActionListener(new decreaseInhaler());
			increase.setBounds(395, 500, 41, 41);
			decrease.setBounds(290, 500, 41, 41);
			quantity4 = new JLabel("0");
			quantity4.setBounds(360, 480, 75, 75);
			price = new JLabel("$150.00");
			price.setBounds(343, 465, 75,75);
			inhaler = new ImageIcon(getClass().getResource("inhaler.jpg"));
			inhalerDisplay = new JLabel(inhaler);
			inhalerDisplay.setBounds(275, 300, 175, 175);
			frame.add(inhalerDisplay);
			Inhaler = new JLabel("Inhaler");
			Inhaler.setBounds(345, 440, 100, 100);
			addCart = new JButton("Add to cart");
			addCart.setBounds(315, 560, 100, 30);
			addCart.addActionListener(new addInhaler());
			frame.add(Inhaler);	
			frame.add(price);
			frame.add(increase);
			frame.add(quantity4);
			frame.add(decrease);
			frame.add(addCart);
			
			increase = new JButton("ʌ");
			decrease = new JButton("v");
			increase.addActionListener(new increaseEpipen());
			decrease.addActionListener(new decreaseEpipen());
			increase.setBounds(635, 200, 41, 41);
			decrease.setBounds(545, 200, 41, 41);
			quantity5 = new JLabel("0");
			quantity5.setBounds(610, 180, 75, 75);
			price = new JLabel("$650.00");
			price.setBounds(588, 165, 75,75);
			epipen = new ImageIcon(getClass().getResource("epipen.jpg"));
			epipenDisplay = new JLabel(epipen);
			epipenDisplay.setBounds(525, 0, 175, 175);
			frame.add(epipenDisplay);
			Epipen = new JLabel("Epipen");
			Epipen.setBounds(590, 140, 100, 100);
			addCart = new JButton("Add to cart");
			addCart.setBounds(565, 255, 100, 30);
			addCart.addActionListener(new addEpipen());
			frame.add(Epipen);
			frame.add(price);
			frame.add(increase);
			frame.add(quantity5);
			frame.add(decrease);
			frame.add(addCart);
			
			increase = new JButton("ʌ");
			decrease = new JButton("v");
			increase.addActionListener(new increaseBandAid());
			decrease.addActionListener(new decreaseBandAid());
			increase.setBounds(635, 500, 41, 41);
			decrease.setBounds(545, 500, 41, 41);
			quantity6 = new JLabel("0");
			quantity6.setBounds(610, 480, 75, 75);
			price = new JLabel("$5.00");
			price.setBounds(595, 465, 75,75);
			bandAids = new ImageIcon(getClass().getResource("bandaid.jpg"));	
			bandAidsDisplay = new JLabel(bandAids);			
			bandAidsDisplay.setBounds(525, 300, 175, 175);			
			frame.add(bandAidsDisplay);		
			BandAids = new JLabel("Band Aids");
			BandAids.setBounds(580, 440, 100, 100);
			addCart = new JButton("Add to cart");
			addCart.setBounds(565, 560, 100, 30);
			addCart.addActionListener(new addBandaid());
			frame.add(BandAids);
			frame.add(price);
			frame.add(increase);
			frame.add(quantity6);
			frame.add(decrease);
			frame.add(addCart);
			
			
		}catch(Exception e)
		{
			System.out.println("Image cannot be found");
		}
		cart = new JButton("Cart");
		cart.setBounds(750, 530, 60, 60);
		cartBalance = new JLabel("Balance: $" + cartBal);
		cartBalance.setBounds(745, 460, 100, 100);
		cart.addActionListener(new checkout());
		frame.add(cart);
		frame.add(cartBalance);
		frame.setSize(850,650);
		frame.setVisible(true);
	
		
	
	}
		public static void setUser(String newUser)
		{
			user = newUser;
		}
	private class increaseAdvil implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			advilCount++;
			quantity.setText(String.valueOf(advilCount));
		}
	}
	private class decreaseAdvil implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(advilCount > 0)
			{
				advilCount--;
				quantity.setText(String.valueOf(advilCount));
			}
		}
	}
	private class increaseMed implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			medCount++;
			quantity2.setText(String.valueOf(medCount));
		}
	}
	private class decreaseMed implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(medCount > 0)
			{
				medCount--;
				quantity2.setText(String.valueOf(medCount));
			}
		}
	}
	private class increaseRubbing implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			rubbingCount++;
			quantity3.setText(String.valueOf(rubbingCount));
		}
	}
	private class decreaseRubbing implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(rubbingCount > 0)
			{
				rubbingCount--;
				quantity3.setText(String.valueOf(rubbingCount));
			}
		}
	}
	private class increaseInhaler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			inhalerCount++;
			quantity4.setText(String.valueOf(inhalerCount));
		}
	}
	private class decreaseInhaler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(inhalerCount > 0)
			{
				inhalerCount--;
				quantity4.setText(String.valueOf(inhalerCount));
			}
		}
	}
	private class increaseEpipen implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			epipenCount++;
			quantity5.setText(String.valueOf(epipenCount));
		}
	}
	private class decreaseEpipen implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(epipenCount > 0)
			{
				epipenCount--;
				quantity5.setText(String.valueOf(epipenCount));
			}
		}
	}
	private class increaseBandAid implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			bandaidCount++;
			quantity6.setText(String.valueOf(bandaidCount));
		}
	}
	private class decreaseBandAid implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(bandaidCount > 0)
			{
				bandaidCount--;
				quantity6.setText(String.valueOf(bandaidCount));
			}
		}
	}
	private class addAdvil implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			int balance = advilCount * 10;
			cartBal += balance;
			cartBalance.setText("Balance: $" + (cartBal));
		}
	}
	private class addMedTap implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			int balance = medCount * 5;
			cartBal += balance;
			cartBalance.setText("Balance: $" + (cartBal));
		}
	}
	private class addRubbing implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			int balance = rubbingCount * 8;
			cartBal += balance;
			cartBalance.setText("Balance: $" + (cartBal));
		}
	}
	private class addInhaler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			int balance = inhalerCount * 150;
			cartBal += balance;
			cartBalance.setText("Balance: $" + (cartBal));		}
	}
	private class addEpipen implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			int balance = epipenCount * 650;
			cartBal += balance;
			cartBalance.setText("Balance: $" + (cartBal));		}
	}
	private class addBandaid implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			int balance = bandaidCount * 5;
			cartBal += balance;
			cartBalance.setText("Balance: $" + (cartBal));		}
	}
	private class checkout implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			File userFile = new File(System.getProperty("user.dir")+ "/" + user + ".txt");
			Scanner scan = null;
			try
			{
				scan = new Scanner (userFile);
				StringBuffer buffer = new StringBuffer();
				while (scan.hasNextLine()) 
				{
			         buffer.append(scan.nextLine()+System.lineSeparator());
				}
				String fileContents = buffer.toString();
				scan.close();
			    fileContents = fileContents.replaceAll(getUserDebt(), String.valueOf(userTotalDebt()));
			    FileWriter writer = new FileWriter(userFile);
			    writer.append(fileContents);
			    writer.flush();
				
			}
			catch (IOException e2)
			{
				// file not found
				e2.printStackTrace();
			}
			JOptionPane.showMessageDialog(frame, "Balance added to Debt");
			frame.dispose();
			UserDashboardGui.setUser(user);
			new UserDashboardGui();
		
		}
	}
	
	private int userTotalDebt()
	{
		int newUserDebt = cartBal + (Integer.valueOf(getUserDebt()));
	
		return newUserDebt;
	
	}

		private String getUserDebt() 
		{
			File userFile = new File(System.getProperty("user.dir")+ "/" + user + ".txt");
			Scanner scan = null;
			try
			{
				scan = new Scanner (userFile);
			}
			catch (FileNotFoundException e)
			{
				// file not found
				e.printStackTrace();
			}
		    scan.nextLine();
		    scan.nextLine(); 
		    userDebt = scan.nextLine();
		    return userDebt;
		}


	
	public static void main(String[] args)
	{
		ShoppingWindow window = new ShoppingWindow();
		
	}

}
