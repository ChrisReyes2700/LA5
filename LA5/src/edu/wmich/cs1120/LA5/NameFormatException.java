package edu.wmich.cs1120.LA5;

public class NameFormatException extends Exception {
	
	private String name;
	
	public NameFormatException(String name) {
		 this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
