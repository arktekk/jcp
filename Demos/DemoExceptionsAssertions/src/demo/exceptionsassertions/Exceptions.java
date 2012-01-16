package demo.exceptionsassertions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exceptions {

	public static void main(String[] args) {
		demoSimpleExceptions();
		demoCustomExceptions();
	}

	public static void demoSimpleExceptions() {
	
		PrintWriter out = null;
		try {
			System.out.println("Hello from demoSimpleExceptions()");

			out = new PrintWriter(new BufferedWriter(new FileWriter("Myfile.txt")));
			out.println("Hello world.");
			out.println("Thank you, and goodnight.");

			System.out.println("Written MyFile.txt successfully");
		}
		catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			if (out != null) {
				out.close();
			}				
		}
	}

	public static void demoCustomExceptions() {
		
		try {
			System.out.println("Hello from demoCustomExceptions()");
			throw new MyDomainException("It's gone pear-shaped", 5);
			// System.out.println("I'll never get here");
		}
		catch (MyDomainException ex) {
			System.err.printf("%s at %s, severity %d", ex.getMessage(), ex.getTimestamp(), ex.getSeverity());
		}
	}
}
