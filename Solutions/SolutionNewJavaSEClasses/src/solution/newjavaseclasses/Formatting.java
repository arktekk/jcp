package solution.newjavaseclasses;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Formatting {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose a locale [US|NO|FR|UK]: ");
		String loc = scanner.next().toUpperCase(); 
		
		Locale locale;
		
		if (loc.equals("US")) {
			locale = Locale.US;
		
		} else if (loc.equals("NO")) {
			locale = new Locale("NO");
		
		} else if (loc.equals("FR")) {
			locale = Locale.FRENCH;
		
		} else {
			locale = Locale.UK;
		}
		
		doStringFormatting(locale);
		doNumberFormatting(locale);
		doTimeFormatting(locale);
		doDateFormatting(locale);
	}
	
	
	private static void doStringFormatting(Locale locale) {
		
		System.out.println("\nString formatting");
		
		System.out.printf("Normal strings:\n");
		System.out.printf(locale, "%s %s %s %s %s %s %s %n", "Sleepy", "Doc", "Happy", "Grumpy", "Sneezy", "Bashful", "Dopey");
		
		System.out.printf("\nStrings with specific ordering:\n");
		System.out.printf(locale, "%7$s %6$s %5$s %4$s %3$s %2$s %1$s %n", "Sleepy", "Doc", "Happy", "Grumpy", "Sneezy", "Bashful", "Dopey");
		
		System.out.printf("\nStrings with a width of 10:\n");
		System.out.printf(locale, "%10s %10s %10s %10s %10s %10s %10s %n", "Sleepy", "Doc", "Happy", "Grumpy", "Sneezy", "Bashful", "Dopey");

		System.out.printf("\nStrings with a width of 10, left-aligned:\n");
		System.out.printf(locale, "%-10s %-10s %-10s %-10s %-10s %-10s %-10s %n", "Sleepy", "Doc", "Happy", "Grumpy", "Sneezy", "Bashful", "Dopey");
	}


	private static void doNumberFormatting(Locale locale) {
		
		System.out.println("\n\nNumber formatting");
		
		int num = 255;
		System.out.printf("255 in decimal, hex, HEX, and octal:\n");
		System.out.printf(locale, "%1$d %1$h %1$H %1$o \n", num);
		
		double pi = 3.14159;
		System.out.printf("\n3.14159 as is, to 2DP, to 4DP, and using exponential format:\n");
		System.out.printf(locale, "%1$f %1$.2f %1$.4f %e\n", pi);
	}


	private static void doTimeFormatting(Locale locale) {
		
		System.out.println("\n\nTime formatting");
		
		Calendar calendar = Calendar.getInstance();
		
		System.out.printf("Complete d/t: %1$tc %n", calendar);

		System.out.printf(locale, "24-hr time: %1$tH/%1$tM/%1$tS       %n", calendar);
		System.out.printf(locale, "12-hr time: %1$tk/%1$tM/%1$tS %1$tp %n", calendar);
		
		System.out.printf(locale, "HH:MM (24):    %1$tR %n", calendar);
		System.out.printf(locale, "HH:MM:SS (24): %1$tT %n", calendar);
		System.out.printf(locale, "HH:MM:SS (12): %1$tr %n", calendar);
	}


	private static void doDateFormatting(Locale locale) {
		
		System.out.println("\n\nDate formatting");
		
		Calendar calendar = Calendar.getInstance();
		
		System.out.printf(locale, "Complete d/t: %1$tc %n", calendar);

		System.out.printf(locale, "Today is:     %1$tA %1$tB %1$tY %n", calendar);
		System.out.printf(locale, "Abbreviated:  %1$ta %1$tb %1$ty %n", calendar);

		System.out.printf(locale, "MM/DD/YY:     %1$tD %n", calendar);
		System.out.printf(locale, "YYYY-MM-DD:   %1$tF %n", calendar);
	}
}
