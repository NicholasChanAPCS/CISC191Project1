
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.*;
//import javax.swing.text.JTextComponent;
//import javax.swing.SpringLayout;

public class SignUpGui
{ 
	private JFrame frame;
	private JPanel panel;
	//nameText = first and last name
	//private String[] JTextField; {"userNameText", "emailText", "nameText", "dobText", "addressText", "insuranceText"};
	private JTextField userNameText, emailText, nameText, dobText, addressText, insuranceText, numberText;
	private JLabel usernameLabel, passwordLabel, successLabel, emailLabel, nameLabel, dobLabel, addressLabel, insuranceLabel, securityLabel,  securityAnswerLabel, availabilityLabel, numberLabel;
	private JPasswordField passwordPassword, securityAnswerPassword;
	private JButton signUpButton, returnToMainButton;
	private final int WINDOW_WIDTH = 350;
	private final int WINDOW_HEIGHT = 490;
	private final int TEXTFIELD_WIDTH = 165;
	private final int TEXTFIELD_HEIGHT = 25;
	private final int LABEL_WIDTH = 80;
	private final int LABEL_HEIGHT = 25;
	private final int BUTTON_WIDTH = 80;
	private final int BUTTON_HEIGHT = 25;
	private ButtonListener trackButton = new ButtonListener();
	
	public SignUpGui() 
	{
		createPanel();
		frame = new JFrame();
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Portal");
		frame.setLocationRelativeTo(null);
		//frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.setVisible(true);
	}
		
	private void createPanel() 
	{
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		//Lay out the panel.

		usernameLabel();
		usernameText();
		passwordLabel();
		passwordPassword();
		//make sure to add money owed in line 3 for txt file when its being made and saved
		nameLabel();
		nameText();
		emailLabel();
		emailText();
		dobLabel();
		dobText();
		addressLabel();
		addressText();
		insuranceLabel();
		insuranceText();
		securityLabel();
		//securityAnswerLabel();
		securityAnswerPassword();
		availabilityLabel();
		numberLabel();
		numberText();
		
		signUpButton();
		returnToMainButton();
		successLabel();
	}
	
	public void usernameLabel() 
	{
		usernameLabel = new JLabel("User Name");
		usernameLabel.setBounds(10, 20, LABEL_WIDTH, LABEL_HEIGHT);
		panel.add(usernameLabel);
	}
	
	public void usernameText() 
	{
		// for user to type
		userNameText = new JTextField(20);
		//bounds(x, y, width, height)
		userNameText.setBounds(100, 20, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		panel.add(userNameText);
	}
	
	public void passwordLabel() 
	{
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 50, LABEL_WIDTH, LABEL_HEIGHT);
		panel.add(passwordLabel);
	}
	
	public void passwordPassword() 
	{
		passwordPassword = new JPasswordField();
		passwordPassword.setBounds(100, 50, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		panel.add(passwordPassword);
	}
	
	public void nameLabel()
	{
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(10, 80, LABEL_WIDTH, LABEL_HEIGHT);
		panel.add(nameLabel);
	}
	
	public void nameText() 
	{
		nameText = new JTextField("ex: John Doe");
		nameText.setBounds(100, 80, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		panel.add(nameText);
	}
	
	public void emailLabel() 
	{
		emailLabel = new JLabel("Email");
		emailLabel.setBounds(10, 110, LABEL_WIDTH, LABEL_HEIGHT);
		panel.add(emailLabel, BorderLayout.WEST);
	}
	
	public void emailText() 
	{
		emailText = new JTextField("ex: email@address.com");
		emailText.setBounds(100, 110, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		panel.add(emailText);
	}
	
	public void dobLabel() 
	{
		dobLabel = new JLabel("Date Of Birth");
		dobLabel.setBounds(10, 140, LABEL_WIDTH, LABEL_HEIGHT);
		panel.add(dobLabel);
	}
	
	public void dobText() 
	{
		dobText = new JTextField("ex: 09142003");
		dobText.setBounds(100, 140, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		panel.add(dobText);
	}
	
	public void addressLabel() 
	{
		addressLabel = new JLabel("Address");
		addressLabel.setBounds(10, 170, LABEL_WIDTH, LABEL_HEIGHT);
		panel.add(addressLabel);
	}
	
	public void addressText() 
	{
		addressText = new JTextField("");
		addressText.setBounds(100, 170, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		panel.add(addressText);
	}
	
	public void numberLabel() 
	{
		numberLabel = new JLabel("Number");
		numberLabel.setBounds(10, 200, LABEL_WIDTH, LABEL_HEIGHT);
		panel.add(numberLabel);
	}
	
	public void numberText() 
	{
		numberText = new JTextField("ex: xxx-xxx-xxxx");
		numberText.setBounds(100, 200, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		panel.add(numberText);
	}
	
	public void insuranceLabel() 
	{
		insuranceLabel = new JLabel("Insurance");
		insuranceLabel.setBounds(10, 230, LABEL_WIDTH, LABEL_HEIGHT);
		panel.add(insuranceLabel);
	}
	
	public void insuranceText() 
	{
		insuranceText = new JTextField();
		insuranceText.setBounds(100, 230, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		panel.add(insuranceText);
	}
	
	public void securityLabel() 
	{
		securityLabel = new JLabel("Security Question: Whats your favorite food?");
		securityLabel.setBounds(50, 260, 300, LABEL_HEIGHT);
		panel.add(securityLabel);
	}
	
//	public void securityAnswerLabel() 
//	{
//		securityAnswerLabel = new JLabel("Security Answer");
//		securityAnswerLabel.setBounds(10, 260, LABEL_WIDTH, LABEL_HEIGHT);
//		panel.add(securityAnswerLabel);
//	}
	
	public void securityAnswerPassword() 
	{
		securityAnswerPassword = new JPasswordField();
		securityAnswerPassword.setBounds(100, 290, TEXTFIELD_WIDTH, TEXTFIELD_HEIGHT);
		panel.add(securityAnswerPassword);
	}
	
	public void availabilityLabel() 
	{
		availabilityLabel = new JLabel();
		availabilityLabel.setBounds(10, 320, LABEL_WIDTH, LABEL_HEIGHT);
		panel.add(availabilityLabel);
	}
	
	// Signs up user
	public void signUpButton() 
	{
		signUpButton = new JButton("Sign Up");
		signUpButton.setBounds(140, 320, BUTTON_WIDTH, BUTTON_HEIGHT);
		signUpButton.addActionListener(trackButton);
		panel.add(signUpButton);
	}
	/**
	 * closes signUp GUI, opens Login GUI
	 */
	public void returnToMainButton() 
	{
		returnToMainButton = new JButton("Sign In");
		returnToMainButton.setBounds(140, 360, BUTTON_WIDTH, BUTTON_HEIGHT);
		returnToMainButton.addActionListener(trackButton);
		panel.add(returnToMainButton);
	}
	
	/**
	 * displays success window
	 */
	public void successLabel() 
	{
		successLabel = new JLabel("");
		successLabel.setBounds(80, 110, 300, 25);
		panel.add(successLabel);
	}	
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == signUpButton) 
			{
				//get username and password
				String user = userNameText.getText();
				String password = passwordPassword.getText();
				//print out in console user and password values
				System.out.println(user + ", " + password);
				//if username and password both match a file with them then success and log them in
				if(user.equals("Nick") && password.equals("notnick")) 
				{
					userNameText.setText(null);
					passwordPassword.setText(null);
					JOptionPane.showMessageDialog(frame, "Login Successful");
					//Close SignUp Open user's dash-board GUI
				}
				// if user name and or password dont match records wipe text field, tell them its wrong, and make them try again
				else 
				{
					userNameText.setText(null);
					passwordPassword.setText(null);
					JOptionPane.showMessageDialog(frame, "Incorrect Password and or Username");
				}
			}
			else if(e.getSource() == returnToMainButton) 
			{
				frame.dispose();
				new MainSignInGui();
				//JOptionPane.showMessageDialog(frame, "Main Sign in");
			}
		}
	}
}




/*
//public Gui() 
//{
//	// TRYING TO GET IT SO FRAME AND PANEL STAY IN MAIN CLASS
//	
////	//use the frame from main class to keep window size the same.
////	MainFrameGui mainGui = new MainFrameGui();
////	//use the frame from main class to keep window size the same.
////	mainGui.guiFrame();
//	panel = new JPanel();
//	panel.setLayout(null);
//	//mainGui.frame.add(panel);
//	//panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
//	//panel.setLayout(new GridLayout(0,1));
//	frame = new JFrame();
//	frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//	frame.add(panel);
//	//frame.add(panel, BorderLayout.CENTER);
//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	frame.setTitle("Portal");
//	//frame.pack();
//	frame.setLocationRelativeTo(null);
//	
//	
//	usernameLabel = new JLabel("User Name");
//	usernameLabel.setBounds(10, 20, 80, 25);
//	panel.add(usernameLabel);
//	
//	// for user to type
//	userNameText = new JTextField(20);
//	//bounds(x, y, width, height)
//	userNameText.setBounds(100, 20, 165, 25);
//	panel.add(userNameText);
//	
//	
//	passwordLabel = new JLabel("Password");
//	passwordLabel.setBounds(10, 50, 80, 25);
//	panel.add(passwordLabel);
//	
//	passwordPassword = new JPasswordField();
//	passwordPassword.setBounds(100, 50, 165, 25);
//	panel.add(passwordPassword);
//	//add money owed in line 3 for txt file
//	
//	nameText = new JTextField();
//	nameText.setBounds(10, 80, 80, 25);
//	panel.add(nameText);
//	
//	// Login button 
//	signUpButton = new JButton("Sign Up");
//	signUpButton.setBounds(140, 80, 80, 25);
//	signUpButton.addActionListener(this);
//	panel.add(signUpButton);
//	
//	successLabel = new JLabel("");
//	successLabel.setBounds(80, 110, 300, 25);
//	panel.add(successLabel);
//	
////	button = new JButton("click me");
////	button.addActionListener(this);
////	panel.add(button);
////		
////	label = new JLabel("Number of clicks: 0");
////	label.setBounds(10,20, 80, 25);
////	panel.add(label);
//	
//	frame.setVisible(true);
//
//}
*/








/*
 * 
 * public class Gui
{
	private JFrame frame;
	private JPanel panel;
	//nameText = first and last name
	private JTextField userNameText, emailText, nameText, dobText, addressText, insuranceText;
	private JLabel usernameLabel, passwordLabel, successLabel, emailLabel, nameLabel, dobLabel, addressLabel, insuranceLabel, securityLabel,  securityAnswerLabel, availabilityLabel;
	private JPasswordField passwordPassword, securityAnswerPassword;
	private JButton signUpButton;
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 400;
	
	public Gui() 
	{
		createPanel();
		frame = new JFrame();
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Portal");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
		
	private void createPanel() 
	{
		ButtonListener trackButton = new ButtonListener();
		panel = new JPanel();
		panel.setLayout(null);
		
//		usernameLabel = new JLabel("User Name");
//		usernameLabel.setBounds(10, 20, 80, 25);
//		panel.add(usernameLabel);
		usernameLabel();
		
		// for user to type
		userNameText = new JTextField(20);
		//bounds(x, y, width, height)
		userNameText.setBounds(100, 20, 165, 25);
		panel.add(userNameText);
		
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordPassword = new JPasswordField();
		passwordPassword.setBounds(100, 50, 165, 25);
		panel.add(passwordPassword);
		
		//add money owed in line 3 for txt file
		
		nameText = new JTextField();
		nameText.setBounds(10, 80, 80, 25);
		panel.add(nameText);
		
		// Login button 
		signUpButton = new JButton("Sign Up");
		signUpButton.setBounds(140, 80, 80, 25);
		signUpButton.addActionListener(trackButton);
		panel.add(signUpButton);
		
		successLabel = new JLabel("");
		successLabel.setBounds(80, 110, 300, 25);
		panel.add(successLabel);
	}
	public void usernameLabel() 
	{
	usernameLabel = new JLabel("User Name");
	usernameLabel.setBounds(10, 20, 80, 25);
	panel.add(usernameLabel);
	}
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			//get username and password
			String user = userNameText.getText();
			String password = passwordPassword.getText();
			//print out in console user and password values
			System.out.println(user + ", " + password);
			
			//if username and password both match a file with them then success and log them in
			if(user.equals("Nick") && password.equals("notnick")) 
			{
				successLabel.setText("Login Successful");
			}
			// if username and or password dont match records wipe text field, tell them its wrong, and make them try again
			else 
			{
				userNameText.setText(null);
				passwordPassword.setText(null);
				JOptionPane.showMessageDialog(frame, "Incorrect Password and or Username");
			}
		}
	}
	
//	private class JTextField extends JTextComponent
//	{
//		public void actionPerformed(ActionEvent e) 
//		{
//			
//		}
//	}
}
 */



