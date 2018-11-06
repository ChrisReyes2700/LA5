package edu.wmich.cs1120.LA5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {
	
	private FormatExceptionHandler f = new FormatExceptionHandler();

	public void readContactInformation(String[] filePaths) {
		for (int i = 0; i < filePaths.length; i++) {
			formatContactInformation(filePaths[i]);
		}
	}
	

	public void formatContactInformation(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);

			formatName(scan.nextLine());
			formatPhoneNumber(scan.nextLine());
			formatEmail(scan.nextLine());

			scan.close();
		} catch (EmailAddressFormatException | PhoneNumberFormatException | NameFormatException
				| FileNotFoundException e) {
			f.handleFileNotFoundException((FileNotFoundException) e);
		}

	}

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