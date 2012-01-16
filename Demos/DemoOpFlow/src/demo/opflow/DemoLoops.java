package demo.opflow;

import java.util.Scanner;

public class DemoLoops {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		demoWhile();
		demoDoWhile(); 
		demoFor();
		demoUnconditionalJumps();
	}

	
	public static void demoWhile() {

		// Display 1 – 5.
		int i = 1;
		while (i <= 5) {
			System.out.printf("%d ", i);
			i++;
		}
		System.out.println();
		
		// Display the first 5 odd numbers.
		i = 1;
		int oddNumber = 1;
		while (i <= 5) {
			System.out.printf("%d ", oddNumber);
			i++;
			oddNumber += 2;
		}
		System.out.println();

		// Read 5 strings from the console, and output in uppercase.
		i = 1;
		String str;
		while (i <= 5) {
			System.out.printf("Enter string %d: ", i);
			str = scanner.next().toUpperCase();
			System.out.printf("In uppercase... %s\n", str);
			i++;
		}
		System.out.println();
	}

	
	public static void demoDoWhile() {
		
		String input;
		String ucInput;
		
		do {
			System.out.print("Enter a Norwegian city: ");
			input = scanner.next();
			ucInput = input.toUpperCase();
			
		} while (!(ucInput.equals("OSLO") || ucInput.equals("BERGEN") || ucInput.equals("TRONDHEIM")));
		
		System.out.printf("Thanks, you entered %s\n", input);
	}


	public static void demoFor() {

		// Display the first 5 odd numbers.
		for (int i = 1, oddNumber = 1; i <= 5; i++, oddNumber += 2) {
			System.out.printf("%d ", oddNumber);
		}
		System.out.println();

		// Display 100 – 50, in downward steps of 10.
		for (int i = 100; i >= 50; i -= 10) {
			System.out.printf("%d ", i);
		}
		System.out.println();

		// Loop indefinitely. Uncomment this code to test it.
		/* 
		int i = 0;
		for (;;) {
			System.out.printf("%d\n", i++);
		}
		*/
	}
	
	
	public static void demoUnconditionalJumps() {
		
		// Display some numbers that are not multiples of 3, until we get to a number that has ten factors (or we get to 100).
		outerScope:
		for (int num = 1; num <= 100; num++) {
			
			// Stop if the number has ten factors;
			for (int i = 1, factorCount = 0; i <= num; i++) {
				if (num % i == 0) {
					factorCount++;
					if (factorCount == 10) {
						System.out.printf("%d has ten factors, so we'll stop now\n", i);
						break outerScope;
					}
				}
			}
			
			// Skip the number if it is a multiple of 3.
			if (num % 3 == 0) {
				continue;
			}
			System.out.printf("%d\n", num);
		}
		System.out.println();
	}


}
