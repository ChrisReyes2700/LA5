package edu.wmich.cs1120.LA5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {

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
			e.printStackTrace();
		}

	}

	public void formatEmail(String email) throws EmailAddressFormatException {
		if (email.compareTo(email.toLowerCase()) == 0) // email is already in lowercase and does not need to be
														// formatted
			System.out.println(email);
		else
			throw new EmailAddressFormatException();
	}

	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		if (phoneNumber.matches("([0-9][0-9][0-9])-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]")) // equal true if matched
																							// regex
			System.out.println(phoneNumber);
		else {
			phoneNumber = phoneNumber.replaceAll("[^0-9.]", ""); // Removes any non number characters
			phoneNumber = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d4)", "($1)-$2-$3"); // Formats it into
																							// phonenumber

			throw new PhoneNumberFormatException(); // Are the exceptions supposed to handle and format it?
		}
	}

	public void formatName(String name) throws NameFormatException {

		if (name.matches("[A-Z][a-z]+[ ][A-Z][a-z]+")) // return true if matches regex

			System.out.println(name);
		else {
			name.toLowerCase();
			char buf = ' ';
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < name.length(); i++) {
				if (buf == ' ' && name.charAt(i) != ' ')
					sb.append(Character.toUpperCase(name.charAt(i)));
				else
					sb.append(name.charAt(i));
				buf = name.charAt(i);
			}
		}
		throw new NameFormatException();
	}

}
