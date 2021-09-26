package com.rohith.proj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.rohith.proj.lockmeApp;

public class selectoption {
	//lockmeApp user = new lockmeApp();
	private static Scanner keyboard = new Scanner(System.in);
	private static Scanner input = new Scanner(System.in);
	private static Scanner lockerInput = new Scanner(System.in);
	private static String filename = null;
	private static String filename1 = null;
	//output data 
		private static PrintWriter output=new PrintWriter(System.out);
		private static PrintWriter lockerOutput = new PrintWriter(System.out);
		static String option;
		//model to store data.
		//private static Users users;
		//private static UserCredentials userCredentials;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lockmeApp user = new lockmeApp();
		String userID = null;
		String confpass = null;
		
		do {
			System.out.println("<------------------------------->");
			System.out.println("!!WELCOME to the lockme app!!!!");
			System.out.println("<--------------------------------->");
			System.out.println("please choose the below options!!");
			System.out.println("1. Registration");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			
			Scanner input = new Scanner(System.in);
			 String option = input.nextLine();
			if(option.equals("1")) {
				System.out.println("ENTER YOUR FIRST NAME:");
				String Name = user.setFirstName(input.next());
				System.out.println("ENTER YOUR LAST NAME:");
				String last = user.setLastName(input.next());
				System.out.println("ENTER YOUR MAIL ID:");
				String email =  user.setEmailID(input.next());
				System.out.println("ENTER YOUR USER ID:");
				 userID = user.setUserName(input.next());
				System.out.println("ENTER YOUR PASSWORD:");
				String newpass = (String) user.setNewpassword(input.next());
				System.out.println("CONFIRM YOUR PASSWORD:");
				 confpass = user.setConpassword(input.next());
				 
				filename = Name;
				
				if(newpass.equals(confpass)) {
					System.out.println("<--------------------------------------------------->");
					System.out.println("!!!!!CONGRATS YOUR REGISTRATION IS SUCCESSFULL!!!!!");
					System.out.println("<--------------------------------------------------->");
				}else {
					System.out.println("<--------------------------------------------------->");
					System.out.println("SORRY PASSWORD MISS MATCH :((");
					System.out.println("<--------------------------------------------------->");
				}
			}
			else if(option.equals("2")) {
				System.out.println("ENTER YOUR USER ID:");
				String ID = user.setUserName(input.next());
				
				System.out.println("ENTER YOUR PASSWORD:");
				String pass = user.setPassword(input.next());
				
				if(pass.equals(confpass) && ID.equals(userID)) {
					System.out.println("!!!!YOUR LOGIN SUCCESS!!!");
					lockerOptions(ID);
					
				}else {
					System.out.println("INVALID USER ID OR PASSWORD :((");
				}
			}
			else if(option.equals("3")) {
				System.out.println("THANK YOU FOR VISITING US !!");
				System.exit(0);
			}
			else {
				System.out.println("please choose the correct option");
			}
		}while(true);
	}
			public static void lockerOptions(String inpUsername) {
				System.out.println("1 . FETCH ALL STORED CREDENTIALS ");
				System.out.println("2 . STORED CREDENTIALS ");
				System.out.println("3.  DELETE CREDENTIALS");
				int option = keyboard.nextInt();
				switch(option) {
					case 1 : 
						fetchCredentials(inpUsername);
						break;
					case 2 :
						storeCredentials(inpUsername);
						break;
					case 3:
						deleteCredentials(inpUsername);
						break;
					default :
						System.out.println("Please select 1 Or 2 or 3");
						break;
				}
				//lockerInput.close();
			
		}
			
			
			public static void storeCredentials(String loggedInUser) {
				System.out.println("==========================================");
				System.out.println("*					*");
				System.out.println("*   WELCOME TO DIGITAL LOCKER STORE YOUR CREDS HERE	 *");
				System.out.println("*					*");
				System.out.println("==========================================");
				
                 UserCredentials.setLoggedInUser(loggedInUser);
				
				System.out.println("Enter Site Name :");
				String siteName = keyboard.next();
				UserCredentials.setSiteName(siteName);
				
				System.out.println("Enter Username :");
				String username = keyboard.next();
				UserCredentials.setUsername(username);
				
				System.out.println("Enter Password :");
				String password = keyboard.next();
				UserCredentials.setPassword(password);
				
				lockerOutput.println(UserCredentials.getLoggedInUser());
				lockerOutput.println(UserCredentials.getSiteName());
				lockerOutput.println(UserCredentials.getUsername());
				lockerOutput.println(UserCredentials.getPassword());
				//lockerOutput.close();
				List<String> list = new ArrayList<String>();
				Map<String, String> map = new HashMap<>();
				list.add(loggedInUser);
				list.add(username);
				list.add(siteName);
				list.add(password);
				
				map.put("USER NAME", loggedInUser);
				map.put("Site Name", siteName);
				map.put("Site password", password);
				map.put("Site userName", username);
				
				System.out.println(map);
				String f = filename.concat("-");
				filename1 = f.concat(siteName);
				FileOutputStream file = null;
				try {
					 file = new FileOutputStream(filename1);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ObjectOutputStream out = null;
				try {
					out = new ObjectOutputStream(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					out.writeObject(list);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("<***********************************>");
				
				System.out.println("YOUR CREDS ARE PUSHED INTO FILE!!!");
				System.out.println("YOUR CREDS ARE STORED AND SECURED!");
				System.out.println("<***********************************>");
				
				
				
				
				lockerOptions(loggedInUser);
				
			}
			private static void deleteCredentials(String inpUsername) {
				// TODO Auto-generated method stub
				
				File myObj = new File(filename1); 
			    if (myObj.delete()) { 
			      System.out.println("Deleted the file: " + myObj.getName());
			      //lockerOptions(inpUsername);
			    } else {
			      System.out.println("Failed to delete the file.");
			    } 
			  } 
				
			//fetch credentials
			public static void fetchCredentials(String inpUsername) {
				System.out.println("==========================================");
				System.out.println("*					*");
				System.out.println("*   WELCOME TO DIGITAL LOCKER 	 *");
				System.out.println("*   YOUR CREDS ARE 	 *");
				System.out.println("*					*");
				System.out.println("==========================================");
				System.out.println(inpUsername);
				
				System.out.println("Site Name: "+ UserCredentials.getSiteName());
				System.out.println("User Name: "+ UserCredentials.getUsername());
				System.out.println("User Password: "+ UserCredentials.getPassword());
				
				
				 
						
					
				}
				
			


}
