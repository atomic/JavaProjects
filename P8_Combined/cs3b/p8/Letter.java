package cs3b.p8;

import java.util.ArrayList;

/**
 * The class will implement a letter that construct sender and receiver and costum content of the letter
 */
public class Letter {

	private String sender = null;
	private String receiver = null;
	private String body = "";

	public Letter(String from, String to) {
		sender = from;
		receiver = to;
	}
	
	public void addLine(String line) {
		body += (line + '\n');
	}
	
	public String getText()  {
		return "Dear " + receiver 
				+ ":\n\n" + body 
				+ "\nSincerely,\n\n" 
				+ sender; 
	}
}
