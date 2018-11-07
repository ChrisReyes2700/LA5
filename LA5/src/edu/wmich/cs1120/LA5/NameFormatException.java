package edu.wmich.cs1120.LA5;

public class NameFormatException extends Exception {
	
	private String name;
	
	/**
	 * creates an NameFormatException which stores a string parameter
	 * @param name string to be stored as name
	 */
	public NameFormatException(String name) {
		 this.name = name;
	}
	
	/**
	 * returns the stored name string to be used by the exception handler
	 * @return stored name string
	 */
	public String getName() {
		return this.name;
	}

}
