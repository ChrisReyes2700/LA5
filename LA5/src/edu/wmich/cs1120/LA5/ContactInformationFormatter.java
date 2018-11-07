package edu.wmich.cs1120.LA5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {
	
	private FormatExceptionHandler f = new FormatExceptionHandler();

	/**
	 * calls formatContactInformation at each element in passed array
	 * 
	 * @param filePaths array of file path names
	 */
	public void readContactInformation(String[] filePaths) {
		for (int i = 0; i < filePaths.length; i++) {
			formatContactInformation(filePaths[i]);
		}
	}
	
	/**
	 * scans file and saves first three lines if the exist to format
	 * name,phone number,and email
	 * 
	 * @param fileName file path name string
	 */
	public void formatContactInformation(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);

			if(scan.hasNext())
				formatName(scan.nextLine());
			if(scan.hasNext())
				formatPhoneNumber(scan.nextLine());
			if(scan.hasNext())
				formatEmail(scan.nextLine());

			scan.close();
		} catch (EmailAddressFormatException | PhoneNumberFormatException | NameFormatException
				| FileNotFoundException e) {
			f.handleFileNotFoundException((FileNotFoundException) e);
		}
	}

	/**
	 * prints email if already in correct format if not will throw formatexception
	 * to format it
	 * 
	 * @param email email string to be formatted from file
	 */
	public void formatEmail(String email) throws EmailAddressFormatException {
		try {
			if (email.compareTo(email.toLowerCase()) == 0) // email is already in lowercase and does not need to be
														   // formatted
				System.out.println(email);
			else
				throw new EmailAddressFormatException(email);
		}
		catch (EmailAddressFormatException e){
			f.handleEmailFormatException(e);
		}
		
	}

	/**
	 * prints PhoneNumber if already in correct format if not will throw
	 * formatexception to format it
	 * 
	 * @param phoneNumber PhoneNumber string to be formatted from file
	 */
	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		try {
			if (phoneNumber.matches("([0-9][0-9][0-9])-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]")) // equal true if matched
																							   // regex
				System.out.println(phoneNumber);
			else 
				throw new PhoneNumberFormatException(phoneNumber);
		}
		catch (PhoneNumberFormatException e) {
			f.handlePhoneNumberFormatException(e);
		}
	}

	/**
	 * prints Name if already in correct format if not will throw formatexception to
	 * format it
	 * 
	 * @param name name string to be formatted from file
	 */
	public void formatName(String name) throws NameFormatException {
		try {
			if (name.matches("[A-Z][a-z]+[ ][A-Z][a-z]+")) // return true if matches regex

				System.out.println(name);
			else
				throw new NameFormatException(name);
		}
		catch(NameFormatException e) {
			f.handleNameFormatException(e);
		}

	}

}