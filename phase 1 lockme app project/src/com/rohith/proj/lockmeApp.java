package com.rohith.proj;

public class lockmeApp {
	
	
	
	private String firstName;
	private String lastName;
	public  String emailID;
	public  String password;
	public  String userName;
	public  String newpassword = new String();
	public  String conpassword = new String();
	
	
	
	
	public lockmeApp() {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.password = password;
		this.newpassword = newpassword;
		this.conpassword = conpassword;
		this.userName = userName;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public String setUserName(String userName) {
		return this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}
	public String setFirstName(String firstName) {
		 return this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String setLastName(String lastName) {
		return this.lastName = lastName;
	}
	public String getEmailID(String emailID) {
		return emailID;
	}
	public String setEmailID(String emailID) {
		return this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		return this.password = password;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public String setNewpassword(String newpassword) {
		return this.newpassword = newpassword;
	}
	public String getConpassword() {
		return conpassword;
	}
	public String setConpassword(String conpassword) {
		return this.conpassword = conpassword;
	}
	@Override
	public String toString() {
		return "lockmeApp [firstName=" + firstName + ", lastName=" + lastName + ", emailID=" + emailID + ", password="
				+ password + ", userName=" + userName + ", newpassword=" + newpassword + ", conpassword=" + conpassword
				+ "]";
	}


	
	
	
	
	
	
}
