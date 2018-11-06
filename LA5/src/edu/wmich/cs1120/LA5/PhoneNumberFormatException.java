package edu.wmich.cs1120.LA5;

public class PhoneNumberFormatException extends Exception{
	
	private String phoneNumber;
	
	public PhoneNumberFormatException(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
}
