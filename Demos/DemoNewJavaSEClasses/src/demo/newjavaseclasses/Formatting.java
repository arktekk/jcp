package demo.newjavaseclasses;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

public class Formatting {

	public static void main(String[] args) {
		demoFormatter();
		demoStringFormat();
		
		demoNumberFormatting();
		demoTimeFormatting();
		demoDateFormatting();
	}
	
	private static void demoFormatter() {

		System.out.println("Using the Formatter class:");
		
		// Use a StringBuilder to accumulate output, using the UK locale.
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.UK);
		
		// ----------------------------------------------------------------------------
		// NOTE:
		// 
		// The format specifiers for general, character, and numeric types have the syntax:
		//    %[ArgumentIndex$][Flags][Width][.Precision]Conversion
		//
		// Where:
		//    - ArgumentIndex is 1 for first varargs argument, etc.
		//
		//    - Flags:   -     [result will be left-justified]
		//               +     [result will always include a sign]
	    //               space [result will include a space for positive values]
		//               0     [result will be zero-padded]
		//               ,     [result will include locale-specific grouping separators]
		//               (     [result will be enclosed in parentheses if negative]
		//
		//    - Width is the minimum number of characters.
		//
		//    - Precision is maximum number of characters (for general conversions), 
		//      or max number of digits after decimal point for floating-point conversions. 
		//
		//    - Conversion is s for string, d for decimal integer, etc.
		// ----------------------------------------------------------------------------

		// Simple output, with field-width specifiers.
		formatter.format("%2s %2s %2s %2s\n", "A", "B", "C", "D");
		
		// Reorder items, using explicit indices.
		formatter.format("%4$2s %3$2s %2$2s %1$2s\n", "A", "B", "C", "D");
		
		// Use different locale (One-off).
		formatter.format(Locale.FRANCE, "Here's a big number: %.4f\n", 123456789.1234567);
		
		// Output negative parameter in parentheses.
		formatter.format("Stocks and shares this week: %(,.2f\n", -6217.577);
		
		System.out.println(sb.toString());
	}
	
	
	private static void demoStringFormat() {
		
		System.out.println("\nUsing the String.format() method:");
		
		// Simple output, with field-width specifiers.
		String s1 = String.format("%2s %2s %2s %2s", "A", "B", "C", "D");
		System.out.println(s1);
		
		// Reorder items, using explicit indices.
		String s2 = String.format("%4$2s %3$2s %2$2s %1$2s", "A", "B", "C", "D");
		System.out.println(s2);
		
		// Use different locale (One-off).
		String s3 = String.format(Locale.FRANCE, "Here's a big number: %.4f", 123456789.1234567);
		System.out.println(s3);
		
		// Output negative parameter in parentheses.
		String s4 = String.format("Stocks and shares this week: %(,.2f", -6217.577);
		System.out.println(s4);
	}


	private static void demoNumberFormatting() {
		
		System.out.println("\nFormatting numbers:");
		
		System.out.printf("Booleans:    %b %B %n",  true, false);
		System.out.printf("Hex:         %h %H %n",  867576, 867576);
		System.out.printf("Character:   %c %C %n",  'a',  '\u0068');
		System.out.printf("Decimal int: %d    %n",  63);
		System.out.printf("Octal int:   %o    %n",  63);
		System.out.printf("Hex int:     %x %X %n",  63, 63);
		System.out.printf("Float:       %f    %n",  123456.798);
		System.out.printf("Float (e):   %e %E %n",  123456.798,  0.123456798);
		System.out.printf("Exam score:  %d%%  %n",  99);
	}


	private static void demoTimeFormatting() {
		
		System.out.println("\nFormatting times:");
		
		Calendar calendar = Calendar.getInstance();
		
		System.out.printf("Time (24):     %1$tH:%1$tM:%1$tS       %n", calendar);
		System.out.printf("Time (12):     %1$tr:%1$tM:%1$tS %1$tp %n", calendar);
		
		System.out.printf("HH:MM (24):    %1$tR %n", calendar);
		System.out.printf("HH:MM:SS (24): %1$tT %n", calendar);
		System.out.printf("HH:MM:SS (12): %1$tr %n", calendar);

		System.out.printf("Timezone:      %1$tz %n", calendar);
		System.out.printf("Timezone name: %1$tZ %n", calendar);
	}


	private static void demoDateFormatting() {
		
		System.out.println("\nFormatting dates:");
		
		Calendar calendar = Calendar.getInstance();
		
		System.out.printf("Month name:   %1$tB %1$tb  %n", calendar);
		System.out.printf("Day name:     %1$tA %1$ta  %n", calendar);

		System.out.printf("Year:         %1$tY %1$ty  %n", calendar);
		System.out.printf("Month:        %1$tm        %n", calendar);
		System.out.printf("Day of month: %1$td %1$te  %n", calendar);
		System.out.printf("Day of year:  %1$tj        %n", calendar);

		System.out.printf("MM/DD/YY:     %1$tD %n", calendar);
		System.out.printf("YYYY-MM-DD:   %1$tF %n", calendar);

		System.out.printf("Complete d/t: %1$tc %n", calendar);
	}
}
