package student.arrays;

import java.util.Scanner;    // Gives us easy access to the Scanner class.

public class DateValidation {

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
			} else {
			
				int maxDay;
				switch (month) {
				case 2:	
					maxDay = (isLeapYear) ? 29 : 28;
					break;
					
				case 4:
				case 6:
				case 9:
				case 11:
					maxDay = 30;
					break;
					
				default:
					maxDay = 31;
					break;
				}
				
				isValid = (day <= maxDay);
			}
			

			if (!isValid) {
				System.out.println("Invalid date!");
			
			} else {

				// Pretty-print the date.
				String monthName;
				switch (month) {
					case 1:  monthName = "January"; 	break;
					case 2:  monthName = "February"; 	break;
					case 3:  monthName = "March"; 		break;
					case 4:  monthName = "April"; 		break;
					case 5:  monthName = "May"; 		break;
					case 6:  monthName = "June"; 		break;
					case 7:  monthName = "July"; 		break;
					case 8:  monthName = "August"; 		break;
					case 9:  monthName = "September"; 	break;
					case 10: monthName = "October"; 	break;
					case 11: monthName = "November"; 	break;
					case 12: monthName = "December"; 	break;
					default: monthName = "Not Known";	break;	// Should never happen
				}

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

				String formattedDate = "" + day + suffix + " " + monthName + ", " + year;
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
