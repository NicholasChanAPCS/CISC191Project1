import java.io.*;
import java.util.*;

public class UserFileIO
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
	
	UserFileIO()
	{
		
	}
	 
	UserFileIO(String newName, int newDOB, String newUsername, String newPassword, String newEmail, String newAddress,String newNumber, String newInsurance, String newSecurityAnswer)
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
	
	public void getUsernameFileIO()
	{
		
	}
	
	// make a file per user named after user. username + ".txt"
	// check if username exisits.
	// File would be from username.
	// Compare user input username and password with file IO username and password.
	public void writeToFileIO(Client client) 
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
	
	// open file 
	public void openUserFile(String username) 
	{
		File userFile = new File(username + ".txt");
		Scanner scan;
		try
		{
			scan = new Scanner (userFile);
		}
		catch (FileNotFoundException e)
		{
			// file not found
			e.printStackTrace();
		}
	}
	
	/*
	 * @purpose: checks if username is already taken if not c
	 * @param: username
	 */
	public static boolean checkUsername(String newUsername) 
	{
		for(int i =0; i < usernames.size(); i++) 
		{
			if(usernames.get(i).equals(newUsername)) 
			{
				return true;
			}
		}
		usernames.add(newUsername);
		return false;
		
		
//		System.out.println("Create username: ");
//        boolean exists = true;
//        do
//        {
//            user = input.nextLine();
//            File temp = new File(System.getProperty("user.dir")+ "/" + user + ".txt");
//            exists = temp.exists();
//            if(exists == true)
//            {
//                System.out.println("Username taken, choose a different one");
//            }
//        }while(exists == true);
	}
	
//	public static boolean checkUsername(String newUsername)
//    {
//        boolean exists;
//        File temp = new File(System.getProperty("user.dir")+ "/" + newUsername + ".txt");
//        exists = temp.exists();
//        return exists;
//    }

}




























