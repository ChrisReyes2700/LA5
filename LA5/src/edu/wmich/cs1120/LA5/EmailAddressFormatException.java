package edu.wmich.cs1120.LA5;

public class EmailAddressFormatException extends Exception {
	
	private String email;
	
	/**
	 * creates an EmailFormatException which stores a string parameter
	 * @param email string to be stored as email
	 */
	public EmailAddressFormatException(String email) {
		 this.email = email;
	}
	
	/**
	 * returns the stored email string to be used by the exception handler
	 * @return stored email string
	 */
	public String getEmail() {
		return this.email;
	}
}
