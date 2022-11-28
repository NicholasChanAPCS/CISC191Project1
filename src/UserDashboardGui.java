import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

import javax.swing.*;

public class UserDashboardGui
{
	private JFrame frame;
	private JPanel panel;
	private JTextField userPaymentText;
	private JLabel moneyOwedLabel, payDebtLabel, moneyAmountOwedLabel;
	private JButton submitPaymentButton;
	private final int WINDOW_WIDTH = 350;
	private final int WINDOW_HEIGHT = 400;
	private final int LABEL_WIDTH = 80;
	private final int LABEL_HEIGHT = 25;
	private final int TEXTFIELD_WIDTH = 165;
	private final int TEXTFIELD_HEIGHT = 25;
	private final int BUTTON_WIDTH = 80;
	private final int BUTTON_HEIGHT = 25;
	private int userDebt = -150;
	private int newUserDebt, userPayment;
	
	private ButtonListener trackButton = new ButtonListener();
	
	public static void main(String[] args) 
	{
		new UserDashboardGui();
	}
	
	public UserDashboardGui() 
	{
		createPanel();
		frame = new JFrame();
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Dashboard");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void createPanel() 
	{
		panel = new JPanel();
		panel.setLayout(null);
		moneyOwedLabel();
		moneyAmountOwedLabel();
		payDebtLabel();
		userPaymentText();
		submitPaymentButton();
	}
	
	private void moneyOwedLabel() 
	{
		moneyOwedLabel = new JLabel("Amount Owed");
		moneyOwedLabel.setBounds(10, 20, LABEL_WIDTH, LABEL_HEIGHT);
		panel.add(moneyOwedLabel);
	}
	
	private void moneyAmountOwedLabel() 
	{
		moneyAmountOwedLabel = new JLabel("$" + userDebt);
		moneyAmountOwedLabel.setBounds(100, 20, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		panel.add(moneyAmountOwedLabel);
	}
	
	private void payDebtLabel() 
	{
		payDebtLabel = new JLabel("Pay");
		payDebtLabel.setBounds(10, 50, LABEL_WIDTH, LABEL_HEIGHT);
		panel.add(payDebtLabel);
	}
	
	private void userPaymentText() 
	{
		userPaymentText = new JTextField("ex: 150");
		userPaymentText.setBounds(100, 50, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		panel.add(userPaymentText);
	}
	
	private void submitPaymentButton() 
	{
		submitPaymentButton = new JButton("Submit Payment");
		submitPaymentButton.setBounds(105, 80, 150, BUTTON_HEIGHT);
		submitPaymentButton.addActionListener(trackButton);
		panel.add(submitPaymentButton);
	}
	
	private void getUsernameFileIO() 
	{
		
	}
	
	private void getFilePassword() 
	{
		
	}
	
	private void getUsersBalanceFileIO() 
	{
		
	}
	
	// updated debt amount from the payment
	public int newUserDebt() 
	{
		newUserDebt = (userDebt + userPayment);
		return newUserDebt;
	}
	
	/*
	//parses string input into int
	public int parsePayment(String usersInput) 
	{
		return Integer.parseInt(usersInput);
	}
	
	public String getInput() 
	{
		
		return null;
	}
	
	
	// trys to parse to int, returns int
	public boolean tryParseToInt() 
	{
		int moneyPayed;
		boolean repeat = false;
		while(repeat) 
		{
			try 
			{
				//moneyPayed = Integer.parseInt(usersInput);
				repeat = true;
			}
			catch(InputMismatchException exception) 
			{
				JOptionPane.showMessageDialog(frame, exception);
				tryParseToInt();
			}
		}
		return true; 
	}
	*/
	
	// returns true if it cant parse string to int, or false if it cant
	public boolean tryParseStringToInt(String userInput) 
	{
		try 
		{
			int i = Integer.parseInt(userInput);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			// if submit payment button is clicked 
			//update users debt amount on gui and fileIO
			if(e.getSource() == submitPaymentButton) 
			{
				if(tryParseStringToInt(userPaymentText.getText()) == false) 
				{
						//if not typed in right format, 
						//make them type again
						//open message saying not right format
						JOptionPane.showMessageDialog(frame, "Incorrect intput of, " + userPaymentText.getText() + "\ntry again");
						userPaymentText.setText(null);

				}
				else if(tryParseStringToInt(userPaymentText.getText()) == true) 
				{
					if(Integer.parseInt(userPaymentText.getText()) > 0)
					{
						// set moneyAmountOwed to the new balance after payment.
						userPayment = Integer.parseInt(userPaymentText.getText());
						userPaymentText.setText(null);
						moneyAmountOwedLabel.setText("$" + newUserDebt());	
						JOptionPane.showMessageDialog(frame, "payment sent successfully of " + userPayment + "\nNew Balance " + newUserDebt);
					}
					else 
					{
						JOptionPane.showMessageDialog(frame, "Incorrect intput of, " + userPaymentText.getText() + "\ntry again");
						userPaymentText.setText(null);
					}
				}
			}
		}
	}
}
