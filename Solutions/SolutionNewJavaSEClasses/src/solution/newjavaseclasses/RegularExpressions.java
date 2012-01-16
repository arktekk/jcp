package solution.newjavaseclasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

	public static void main(String[] args) {

		doMatching();
		doRepeatedFinds();
		doGroups();
		doStringRE();
	}
	
	
	private static void doMatching() {
		
		System.out.println("Simple regular expressions:");
		
		Pattern p = Pattern.compile("(Hello)*");

		Matcher m1 = p.matcher("HelloHelloHello");
		boolean result1 = m1.matches();
		System.out.printf("Result1: %b %n", result1);	// Should be true.
		
		Matcher m2 = p.matcher("HelloHelloHello What's Going On Here Then");
		boolean result2 = m2.matches();
		System.out.printf("Result2: %b %n", result2);	// Should be false.

		Matcher m3 = p.matcher("HelloHelloHello What's Going On Here Then");
		boolean result3 = m3.lookingAt();
		System.out.printf("Result3: %b %n", result3);	// Should be true.
	}


	private static void doRepeatedFinds() {
		
		System.out.println("\nRepeated finds:");
		
		Pattern p = Pattern.compile("[a-z]+");

		Matcher m = p.matcher("testing 12345, god natt og takk for alle fisker!");

		while (m.find()) {
			System.out.printf("Found: %s\n", m.group());
		}
	}


	private static void doGroups() {
		
		System.out.println("\nGroups:");
		
		Pattern p = Pattern.compile("0{0,1}(\\d{3})[\\s-](\\d{3})[\\s-](\\d{3})");
		Matcher m = p.matcher("0123 456-789");
	
		// Perform the match.
		if (m.matches()) {
			
			// Iterate through all the capture groups.
			for (int i = 1; i <= m.groupCount(); i++) {
				System.out.printf("Group %d match: %s\n", i, m.group(i));
			}
		} 
	}


	private static void doStringRE() {
		
		System.out.println("\nString RE support:");
		
		String greeting = "Good night";
		boolean result1 = greeting.matches("Good night");	// true
		boolean result2 = greeting.matches("Good");			// false
		System.out.printf("Result1=%b, Result2=%b\n", result1, result2);

		String path = " This. Is a Message! OK?";
		String[] pathComponents = path.split("[.?!]");
		for (String pc : pathComponents) {
			System.out.println(pc);
		}
		System.out.println();	}
}