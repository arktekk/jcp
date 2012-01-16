package demo.newjavaseclasses;

import java.util.Date;
import java.io.Console;

public class UsingConsole {

	public static void main(String[] args) {

		Console console = System.console();
		if (console != null) {

			console.printf("Hello at %s. Please tell me your name: ", new Date());
		    
		    String name = console.readLine();
		    String nat = console.readLine("Thanks %s, now tell me your nationality: ", name);
		    char[] pwChars = console.readPassword("Great %s, you're %s! Password? ", name, nat);
		    
		    String password = new String(pwChars);
		    console.printf("Thanks. Your password is: %s", password);
		    
		} else {
		    System.out.println("Sorry, console unavailable.");
		}
	}
}
