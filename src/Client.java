import java.io.*;
import java.util.Scanner;
public class Client 
{
	private static String name;
	private static String DOB;
	private static String username;
	private static String password;
	private static String email; 
	private static String address;
	private static String phoneNumber;
	private static String insurance; //code boolean to check if has insurance and different to return insurance has, ask for insurance in scanner?
	private static String securityAnswer;
	public static int balance = 0;
	
	Client()
	{
		
	}
	/* Purpose: Create client object
	 * @param: All values of client class
	 * 
	 * @Output: No output
	 */
	Client(String newName, String newDOB, String newUsername, String newPassword, String newEmail, String newAddress,String newNumber, String newInsurance, String newSecurityAnswer)
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
	public static int getBalance()
	{
		return balance;
	}
	
	/* @Purpose: returns balance due from client
	 * @param: none
	 * 
	 * @Output: balance
	 */
	public static String returnBalance(String newUsername)
	{
		String moneyOwed;
		File userFile = new File(System.getProperty("user.dir")+ "/" + newUsername + ".txt");
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
		moneyOwed = scan.nextLine();		
		return moneyOwed;
	}
	
	// make a file per user named after user. username + ".txt"
	// check if username exisits.
	// File would be from username.
	//Compare user input username and password with file IO username and password.
	public static void toFileIO(Client client)
	{
		try
        {
            PrintWriter outputFile = new PrintWriter(username + ".txt"); 
            outputFile.println(username);
            outputFile.println(password);
            outputFile.println(balance);
            outputFile.println(name);
            outputFile.println(DOB);
            outputFile.println(email);
            outputFile.println(address);
            outputFile.println(phoneNumber);
            outputFile.println(insurance);
            outputFile.println(securityAnswer);
            outputFile.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

	}
	public static String modifyBalance(String newUsername, int newBalance) throws IOException
	{
		String newUserDebt = String.valueOf((Client.getBalance() + newBalance));
		 File input = new File(System.getProperty("user.dir")+ "/" + newUsername + ".txt");	        
	        Scanner scan = new Scanner (input);
			StringBuffer buffer = new StringBuffer();
			while (scan.hasNextLine()) 
			{
		         buffer.append(scan.nextLine()+System.lineSeparator());
			}
			String fileContents = buffer.toString();
			scan.close();
		    String oldLine = String.valueOf(Client.getBalance());
		    String newLine = newUserDebt;
		    fileContents = fileContents.replaceAll(oldLine, newLine);
		    FileWriter writer = new FileWriter(input);
		    writer.append(fileContents);
		    writer.flush();
			return newLine;
	              
	}
	/*
	 * @purpose: checks if username is already taken
	 * @param: username
	 */
	
	public static boolean checkLogin(String user)
    {
        boolean exists;
        File temp = new File(System.getProperty("user.dir")+ "/" + user + ".txt");
        exists = temp.exists();
        return exists;
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

