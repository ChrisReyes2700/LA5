package edu.wmich.cs1120.LA5;

public class PhoneNumberFormatException extends Exception{
	
	private String phoneNumber;
	
	/**
	 * creates an NameFormatException which stores a string parameter
	 * @param phoneNumber string to be stored as phoneNumber
	 */
	public PhoneNumberFormatException(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * returns the stored name string to be used by the exception handler
	 * @return stored phone number string
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
}
