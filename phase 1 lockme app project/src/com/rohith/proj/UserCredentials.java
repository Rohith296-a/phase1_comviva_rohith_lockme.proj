package com.rohith.proj;


public class UserCredentials {
	
	 static String siteName = null;
	private static  String  loggedInUser = null;
	private static String username=null;
	private static String password=null;
	
	//public UserCredentials() {}

	public UserCredentials(String siteName, String loggedInUser, String username, String password) {
		this.siteName = siteName;
		this.loggedInUser = loggedInUser;
		this.username = username;
		this.password = password;
	}

	public static String getSiteName() {
		return siteName;
	}

	public static String setSiteName(String siteName) {
		return UserCredentials.siteName = siteName;
	}

	public static String getLoggedInUser() {
		return loggedInUser;
	}

	public static String setLoggedInUser(String loggedInUser) {
		return UserCredentials.loggedInUser = loggedInUser;
	}

	public static String getUsername() {
		return username;
	}

	public static String setUsername(String username) {
		return UserCredentials.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static String setPassword(String password) {
		return UserCredentials.password = password;
	}

	@Override
	public String toString() {
		return "UserCredentials [siteName=" + siteName + 
				", loggedInUser=" + loggedInUser + 
				", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
	
	
	
	

}