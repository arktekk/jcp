package solution.arrays;

import java.util.Scanner;    // Gives us easy access to the Scanner class.

public class DateValidation {

	// Month names.
	private static final String[] MONTH_NAMES = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

	// Maximum number of days in each month (in a normal year, and in a leap year).
	private static final int[] MAX_DAYS    = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] MAX_DAYS_LY = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int day, month, year;
		String response;
		String allValidDates = "";
		
		do {
			// Get a date from the user.
			System.out.print("Day: ");
			day = scanner.nextInt();
			
			System.out.print("Month: ");
			month = scanner.nextInt();

			System.out.print("Year: ");
			year = scanner.nextInt();

			boolean isLeapYear = ((year % 4 == 0) && !(year % 100 == 0)) || 
            				      (year % 400 == 0);

			boolean isValid;
			
			if (month < 1 || month > 12) {
				isValid = false;
			} else if (year < 0 || year > 2099) {
				isValid = false;
			} else if (day < 1) {
				isValid = false;
			} else if (isLeapYear) {
				isValid = (day <= MAX_DAYS_LY[month-1]);
			} else {
				isValid = (day <= MAX_DAYS[month-1]);
			}
			

			if (!isValid) {
				System.out.println("Invalid date!");
			
			} else {

				// Pretty-print the date.
				String suffix;
				switch (day) {
					case 1:  
					case 21:
					case 31:
						suffix = "st";
						break;
						
					case 2:  
					case 22:
						suffix = "nd";
						break;
		
					case 3:  
					case 23:
						suffix = "rd";
						break;
						
					default:
						suffix = "th";
						break;
				}

				String formattedDate = "" + day + suffix + " " + MONTH_NAMES[month-1] + ", " + year;
				System.out.println("Valid date: " + formattedDate);
				
				// Append formatted date to a string that contains all valid dates.
				allValidDates += formattedDate + "\n";
			}
			
			// Ask the user whether he/she wants to enter another date.
			System.out.print("\nEnter another date? ");
			response = scanner.next();

		} while (response.toUpperCase().equals("YES"));
		
		// Output all the valid dates entered by the user.
		System.out.println("Here are all the valid dates you entered:");
		System.out.println(allValidDates);
	}
}
