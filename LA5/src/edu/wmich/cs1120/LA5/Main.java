package edu.wmich.cs1120.LA5;

/**
 * Project reads 10 text files which contain a name, phone number and email then prints those inputs in the correct format.
 * Correct format for each follows: Name: [A-Z][a-z]+[ ][A-Z][a-z]+ ; Phone Number: ([0-9][0-9][0-9])-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9] ;
 * Email : [a-z]([a-z])*(.[a-z]+)*@[a-z]+.(a-z)+. In case of no file found, prints out that the specific file is not found.
 * 
 * @author Austin W, Chris R
 *
 */
public class Main {

	public static void main(String[] args) {
		
		String[] filePaths = { "testcase1.txt", "testcase2.txt", "testcase3.txt", "testcase4.txt", "testcase5.txt",
				"testcase6.txt", "testcase7.txt", "testcase8.txt", "testcase9.txt", "testcase10.txt" };
		ContactInformationFormatter formatter = new ContactInformationFormatter();
		formatter.readContactInformation(filePaths);

	}

}
