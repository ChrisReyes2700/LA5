package edu.wmich.cs1120.LA5;

import java.io.FileNotFoundException;

public class FormatExceptionHandler implements IFormatExceptionHandler{
	
	
	/**
	 * prints a message showing which file is not found and that the system cannot find the file
	 * 
	 * @param e exception passed to this handler
	 */
	public void handleFileNotFoundException(FileNotFoundException e) {
		System.out.println(e.getMessage());
	}
	
	/**
	 * gets the phoneNumber string from PhoneNumberFormatException, removes any non number characters, then prints in the format
	 * ([0-9][0-9][0-9])-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9], using the modified phoneNumber
	 * 
	 * @param e exception passed to this handler, contains necessary string
	 */
	public void handlePhoneNumberFormatException(PhoneNumberFormatException e) {
		String phoneNumber = e.getPhoneNumber();
		phoneNumber = phoneNumber.replaceAll("[^0-9.]", ""); // Removes any non number characters

		System.out.print("(");
		for(int i = 0; i < 3; i++) {
			System.out.print(phoneNumber.charAt(i));
		}
		System.out.print(")-");
		for(int i = 3; i < 6; i++) {
			System.out.print(phoneNumber.charAt(i));
		}
		System.out.print("-");
		for(int i = 6; i < 9; i++) {
			System.out.print(phoneNumber.charAt(i));
		}
		System.out.print("\n");
	}
	
	/**
	 * gets the email string from EmailAddressFormatException, and prints the whole string in lower case
	 * 
	 * @param e exception passed to this handler, contains necessary string
	 */
	public void handleEmailFormatException(EmailAddressFormatException e) {
		String email = e.getEmail();
		System.out.println(email.toLowerCase());
	}

	/**
	 * gets the name string from NameFormatException, splits the string into a string array with the first index as the first name and second index and the last name.
	 * each index value has the first character capitalized and the rest of the string as lower case
	 * 
	 * @param e exception passed to this handler, contains necessary string
	 */
	public void handleNameFormatException(NameFormatException e) {
		String[] nameArr = e.getName().split(" ");
		for(int i = 0; i < nameArr.length; i++) {
				String nameFormat = nameArr[i].substring(0, 1).toUpperCase() + nameArr[i].substring(1, nameArr[i].length()).toLowerCase();
				System.out.print(nameFormat + " ");
		}
		System.out.print("\n");
	}
	
}
