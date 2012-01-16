package demo.newjavaseclasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

	public static void main(String[] args) {
		demoSimpleRegex();
		demoMatching("Swansea 3-0 Cardiff!!!", "[a-zA-Z][a-zA-Z0-9\\- ]*");
		demoRepeatedFinds("/a/bc/def", "[a-z]+");
		demoGroups("01792 405529", "(0\\d{3,4})[\\s-](\\d{6})");
		demoReplacement("01222-123456 01222-654321 01222-98765", "01222-", "02920-2");
		demoStringRE();
	}
	
	private static void demoSimpleRegex() {
		
		System.out.println("Simple regular expressions:");
		
		// Step 1: Compile a pattern.
		// Step 2: Create a Matcher object, to match the pattern against a string.
		// Step 3: Did the pattern match?
		Pattern p = Pattern.compile("a*b");
		Matcher m = p.matcher("aaaaab");
		boolean result1 = m.matches();
		System.out.printf("Result1: %b %n", result1);

		// Now let's do steps 1, 2, and 3 all in one go.
		// This is handy for one-off regex tests, but inefficient if you want to use the same regex several times
		// because the regex would have to be compiled each time.
		boolean result2 = Pattern.matches("a*b", "aaaaab");
		System.out.printf("Result2: %b %n", result2);
	}


	private static void demoMatching(CharSequence source, String regex) {
		
		System.out.printf("\n\nMatching %s for regex %s:\n", source, regex);
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(source);
	
		// Call matches() to see if there's an exact match on the entire source.
		if (m.matches()) {
			System.out.printf("matches() matches:  %s\n", m.group());
		} else {
			System.out.printf("matches() doesn't match anything.\n");
		}
	
		// Call lookingAt() to see if there's a match from the start of the source.
		if (m.lookingAt()) {
			System.out.printf("lookingAt() matches:  %s\n", m.group());
		} else {
			System.out.printf("lookingAt() doesn't match anything.\n");
		}
	
		// Call find() to see if there's a match somewhere in the source.
		// Note that we reset() the Matcher first, otherwise it would search from where previous match terminated. 
		m.reset();
		if (m.find()) {
			System.out.printf("find() matches:  %s\n", m.group());
		} else {
			System.out.printf("find() doesn't match anything.\n");
		}
	}


	private static void demoRepeatedFinds(CharSequence source, String regex) {
		
		System.out.printf("\n\nPerforming repeated find() calls on %s for regex %s:\n", source, regex);
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(source);
	
		// Find each occurrence of RE in source, in a loop.
		while (m.find()) {
			System.out.printf("find() matches:  %s\n", m.group());
		} 
		
		// Find the 2nd occurrence of RE in source.
		if (m.find(2)) {
			System.out.printf("find(2) matches:  %s\n", m.group());
		}
	}

	
	private static void demoGroups(CharSequence source, String regex) {
		
		System.out.printf("\n\nDefining and accessing capture groups on %s using regex %s:\n", source, regex);
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(source);
	
		// Perform the match.
		if (m.matches()) {
			
			// Iterate through all the capture groups.
			for (int i = 1; i <= m.groupCount(); i++) {
				System.out.printf("Group %d match: %s\n", i, m.group(i));
			}
		} 
	}


	private static void demoReplacement(CharSequence source, String regex, String replacement) {
		
		System.out.printf("\n\nReplacing text in %s using regular expression %s and replacement %s:\n", source, regex, replacement);
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(source);
	
		// Replace first occurrence.
		String result1 = m.replaceFirst(replacement);
		System.out.printf("replaceFirst() gives: %s \tsource: %s\n", result1, source);

		// Replace all occurrences.
		String result2 = m.replaceAll(replacement);
		System.out.printf("replaceAll()   gives: %s \tsource: %s\n", result2, source);
	}


	private static void demoStringRE() {
		
		System.out.printf("\n\nUsing new String methods for regular expressions:\n");
		
		String greeting = "Hello mum";
		boolean result1 = greeting.matches("Hello mum");	// true
		boolean result2 = greeting.matches("Hello");		// false
		System.out.printf("Result1=%b, Result2=%b\n", result1, result2);

		String path = " Hello. How are you? I'm fine! Thanks!";
		String[] pathComponents = path.split("[.?!]");
		for (String pc : pathComponents) {
			System.out.println(pc);
		}
		System.out.println();
	}
}