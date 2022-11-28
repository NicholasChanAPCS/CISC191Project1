import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable
{
	private String name;
	private int DOB;
	private static String username;
	private static String password;
	private String email; 
	private String address;
	private String phoneNumber;
	private String insurance; //code boolean to check if has insurance and different to return insurance has, ask for insurance in scanner?
	private String securityQuestion = " "; //maybe have one common question for everyone and save their answer
	private String securityAnswer;
	public int balance = 0;
	public static ArrayList<String> appointments = new ArrayList<String>();
	public static ArrayList<String> usernames  = new ArrayList<String>();
	
	Client()
	{
		
	}
	/* Purpose: Create client object
	 * @param: All values of client class
	 * 
	 * @Output: No output
	 */
	Client(String newName, int newDOB, String newUsername, String newPassword, String newEmail, String newAddress,String newNumber, String newInsurance, String newSecurityAnswer)
	{
		name = newName;
		DOB = newDOB;
		username = newUsername;
		password = newPassword;
		email = newEmail;
		address = newAddress;
		phoneNumber = newNumber;
		insurance = newInsurance;
		securityAnswer = newSecurityAnswer;
		balance = 0;
	}
	
	//Existing Clients
	/* @Purpose: get clients new Username and set it in client
	 * @Param: users new name
	 * 
	 * @Output: No output
	 */
 
	public void setUsername(String newUsername)
	{
		this.username = newUsername;
	}
	public static String getUsername() 
	{
		return username;
	}
	
	/* @Purpose: set client password
	 * @Param: clients new password
	 * @OutPut: no output
	 * 
	 */
	public void setPassword(String newPassword)
	{
		this.password = newPassword;
	}
	public static String getPassword()
	{
		return password;
	}
	public String getSecurityAnswer()
	{
		return securityAnswer;
	}
	
	/* @Purpose: returns balance due from client
	 * @param: none
	 * 
	 * @Output: balance
	 */
	public int returnBalance()
	{
		return balance;
	}
	
	// make a file per user named after user. username + ".txt"
	// check if username exisits.
	// File would be from username.
	//Compare user input username and password with file IO username and password.
	public static void toFileIO(Client client)
	{
		try
		{
			FileOutputStream f = new FileOutputStream(new File(username + ".txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(client);
			o.flush();
			o.close();
			f.close();
		}	
		catch(IOException e)
		{
			e.printStackTrace();
		}
		

	}
	/*
	 * @purpose: checks if username is already taken
	 * @param: username
	 */
	
	public static boolean checkUsername(String newUsername)
	{
		boolean taken = true;
		for(int i = 0; i < usernames.size(); i++)
		{
			if(usernames.get(i) == newUsername)
			{
				return taken;
			}
			else
			{
				taken = false;
				usernames.add(newUsername);
			}
		}		
		return taken;
	}

	/* @Purpose: Have all values of client class printed out to console for user to read
	 * @param: None
	 * @OutPut: All fields in a string
	 */
	public String toString()
	{
		return ""; //prints all client information
	}
	
	
	
	
	// searches for name in file
//	final Scanner scanner = new Scanner(file);
//	while (scanner.hasNextLine()) {
//	   final String lineFromFile = scanner.nextLine();
//	   if(lineFromFile.contains(name)) { 
//	       // a match!
//	       System.out.println("I found " +name+ " in file " +file.getName());
//	       break;
//	   }
//	}
}

