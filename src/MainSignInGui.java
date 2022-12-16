import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class MainSignInGui implements ActionListener
{
	 
	public static void main(String[] args) 
	{
		new MainSignInGui();
	}
	private String user;
	private JPanel panel;
	private JFrame frame;
	private JTextField userNameText;
	private JLabel usernameLabel, passwordLabel, successLabel, newUserLabel;
	private JPasswordField passwordText;
	private JButton loginButton, newUserButton;
	

	public MainSignInGui()
	{
//		panel = new JPanel();
//		panel.setLayout(null);
		guiPanel();
		guiFrame();
		usernameLabel = new JLabel("User Name");
		usernameLabel.setBounds(10, 20, 80, 25);
		panel.add(usernameLabel);
		
		userNameText = new JTextField(20);
		//bounds(x, y, width, height)
		userNameText.setBounds(100, 20, 165, 25);
		panel.add(userNameText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		// Login button 
		loginButton = new JButton("Login");
		loginButton.setBounds(140, 80, 80, 25);
		loginButton.addActionListener(this);
		panel.add(loginButton);
		
//		successLabel = new JLabel("");
//		successLabel.setBounds(80, 110, 300, 25);
//		panel.add(successLabel);
		
		newUserLabel = new JLabel("New User?");
		newUserLabel.setBounds(150, 110, 80, 25);
		panel.add(newUserLabel);
		
		newUserButton = new JButton("Sign Up");
		newUserButton.setBounds(140, 140, 80, 25);
		newUserButton.addActionListener(this);
		panel.add(newUserButton);
		// swingConstants is A collection of constants generally used 
		// for positioning and orienting components on the screen
//		frame = new JFrame();
//		frame.setSize(350, 200);
//		frame.add(panel);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("Main");
		frame.setVisible(true);
	}
	//gui frame 
	public void guiFrame() 
	{
		frame = new JFrame();
		frame.setSize(350, 300);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main");
		// sets the GUI application to open in the middle of your computer screen
		frame.setLocationRelativeTo(null);
		
	}
	public JTextField getUsernameText()
	{
		return userNameText;
	}
	
	// gui panel
	public void guiPanel() 
	{
		panel = new JPanel();
		panel.setLayout(null);
	}
	//public void 
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == loginButton) 
		{
			// TODO Auto-generated method stub
			//get username and password
			user = userNameText.getText();
			String password = passwordText.getText();
			//print out in console user and password values
			System.out.println(user + ", " + password);
		
			//if username and password both match a file with them then success and log them in
			File userFile = new File(System.getProperty("user.dir")+ "/" + user + ".txt");
			Scanner scan = null;
			try
			{
				scan = new Scanner (userFile);
			}
			catch (FileNotFoundException ex)
			{
				// file not found
				ex.printStackTrace();
			}
			//scans files lines for username password
		    String username = scan.nextLine();
		    String pass = scan.nextLine(); // looks at selected file in scan
			if(user.equals(username) && password.equals(pass)) 
			{
				//successLabel.setText("Login Successful");
				JOptionPane.showMessageDialog(frame, "Login successful");
				frame.dispose();
				TransitionGUI.setUser(user);
				new TransitionGUI();
			}
			// if username and or password dont match records wipe text field, tell them its wrong, and make them try again
			else 
			{
				userNameText.setText(null);
				passwordText.setText(null);
				//successLabel.setText("Incorrect Password and or Username");
				JOptionPane.showMessageDialog(frame, "Inccorrect Password and or Username");
			}
		}
		//close Sign in GUI. open new user sign up GUI
		else if(e.getSource() == newUserButton)
		{
			
			frame.dispose();
			new SignUpGui();
		}
	}
}
