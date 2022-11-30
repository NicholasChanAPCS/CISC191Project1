import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
 

public class Interface
{

	public static void main(String[] args)
	{
		
		String email;
		String name;
		int DOB = 0;
		String user;
		String password;
		String number = null;
		String address;
		String insurance;
		String answer;
		// TODO Make user interface to set client info
		// options for new user or existing user interface
		// user types 1 for new user. 2 for existing user.
		Scanner input = new Scanner(System.in);
		System.out.println("Type 1 for new user 2 for existing user.");
		boolean correctInput = false; 
		do 
		{
			int userType = 0;
			do 
			{
				try 
				{
				userType = input.nextInt();
				correctInput = true;
				}
				catch(InputMismatchException e)
				{
					System.out.println("invalid input. Type in as shown in example: ");
				    input.next();
				    correctInput = false;
				}
			}while(correctInput == false);
			
			//new user interface
			if(userType == 1) 
			{
				input.nextLine(); 
				correctInput = true;
				System.out.println("Enter email (email@address.com): ");
				boolean correctFormat;
				do				//checks to see if email is written in correct format
				{
					email = input.nextLine();
					String emailPattern = "[a-zA-Z0-9]{3,64}@[a-zA-Z0-9]{3,15}[.][a-zA-Z]{2,5}";
					correctFormat = email.matches(emailPattern);
					if(!correctFormat)
					{
						System.out.println("Wrong format, try again");
					}
					
				}while(!correctFormat);
				
				System.out.println("Enter first and last name: ");
				name = input.nextLine();
				System.out.println("Enter date of birth with no / (ex: 09142003)");
				boolean userInput = false;
				do
				{
					try
					{
					    DOB = input.nextInt();
						userInput = true;
					}
					catch(InputMismatchException e)
					{
						System.out.println("invalid input. Type in as shown in example: ");
					    input.next();
					}		
				}while(userInput == false);
				
				input.nextLine();
				System.out.println("Create username: ");
                boolean exists = true;
                do
                {
                    user = input.nextLine();
                    if(Client.checkUsername(user) == true)
                    {
                    	System.out.println("Username taken, choose a different one");
                    }

                }while(Client.checkUsername(user) == true);
					
				input.nextLine();
				System.out.println("Create password: ");
			    password = input.nextLine();
				System.out.println("Enter address: ");
				address = input.nextLine();
				System.out.println("Enter phone number (xxx-xxx-xxxx): ");
				do
				{
					number = input.nextLine();
					String phonePattern = "\\d{3}-\\d{3}-\\d{4}";			
					correctFormat = number.matches(phonePattern);
					if (!correctFormat) 
						{
						System.out.println("Invalid format");		
						}
				}while(!correctFormat);
				
				System.out.println("Enter insurance. Enter none if you don't have any: ");
				insurance = input.nextLine();
				System.out.println("Please respond to security question: What is your favorite food: ");
				answer = input.nextLine();
				Client newUser = new Client(name, DOB, user, password, email, address, number, insurance, answer);
				Client.toFileIO(newUser);
				input.close();
				
			}
			// existing user interface
			else if(userType == 2)
			{
				//get user input
				do 
				{
//					//open users file to scan for users password and username and debt owed
//					//opens users file
//					Scanner scan = new Scanner (new File("the\\dir\\myFile.extension"));
//					//creats scanner to read from file
//				    Scanner keyboard = new Scanner (System.in);
//					//scans files line for username password
//				    String user = scan.nextLine();
//				    String pass = scan.nextLine(); // looks at selected file in scan
//				    
					correctInput = true;
					//ask user for username
					input.nextLine();
					System.out.println("Type your username");
					//set user input
					user = input.nextLine();
					// find users file by using username.
					// open users file get password and use it for login check
					File userFile = new File("C:\\Users\\nicho\\git\\repository\\ClientPortal\\doc\\text.txt");
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
					//creats scanner to read from file
				    Scanner keyboard = new Scanner (System.in);
					//scans files lines for username password
				    String username = scan.nextLine();
				    String pass = scan.nextLine(); // looks at selected file in scan
				    String moneyOwed = scan.nextLine();
					
					//ask for user password
					System.out.println("Type your password");
					//set password
					password = input.nextLine();
					//check to see if username and password is correct and matches
					if(user.equals(username) && password.equals(pass))
					{
						System.out.println("You owe us " + moneyOwed);
						correctInput = true;
					}
					//tell the user the username and or password doesnt match and try again.
					else
					{
						System.out.println("Username and or Password doesn't match current records. Press enter to continue");
						correctInput = false;
					}
					//loop if user messed up password and or username to make them try again
				}while(correctInput == false);
			}
			// loop
			else
			{
				System.out.println("invalid input.\nPlease enter 1 for new user or 2 for existing user");
				correctInput = false;
				
			}
		}while(correctInput == false);
		
	}

}
