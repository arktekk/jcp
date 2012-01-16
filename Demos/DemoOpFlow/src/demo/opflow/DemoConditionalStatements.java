package demo.opflow;

public class DemoConditionalStatements {

	public static void main(String[] args) {
		demoIf();
		demoNestedIf();
		demoSwitch();
	}

	
	public static void demoIf() {

		int age = 25;

		// Basic if-test.
		if (age >= 18) {
			System.out.println("You are 18 or older");
		}

		// if-else test.
		if (age >= 30) {
			System.out.println("You are 30 or older");
		} else {
			System.out.println("You are younger than 30");
		}

		// if-else-if test.
		if (age >= 65) {
			System.out.println("You are 65 or older");
		} else if (age >= 50) {
			System.out.println("You are between 50 and 64");
		} else if (age >= 21) {
			System.out.println("You are between 21 and 49");
		} else {
			System.out.println("You are younger than 21");
		}
	}

	
	public static void demoNestedIf() {

		int age = 45;
		String gender = "Male";
		System.out.print("You are a ");

		if (age < 18) {

			if (gender.equals("Male")) {
				System.out.println("boy");
			} else {
				System.out.println("girl");
			}

		} else {

			if (age >= 100) {
				System.out.print("centurion ");
			}

			if (gender.equals("Male")) {
				System.out.println("man");
			} else {
				System.out.println("woman");
			}
		}
	}


	public static void demoSwitch() {

		// Let's say the first day of the week (i.e. day 1) is Monday.
		int dayOfWeek = 6; // Saturday

		// Determine what time a shop closes, depending of day of week.
		int shopClosingTime;
		
		switch (dayOfWeek) {

		case 4:
			shopClosingTime = 20; // Shop closes 2000h (i.e. 8pm) on Thursdays.
			break;

		case 5:
		case 6:
			shopClosingTime = 19; // Shop closes 1900h (i.e. 7pm) on Fridays and Saturdays.
			break;

		case 7:
			shopClosingTime = 16; // Shop closes 1600h (i.e. 4pm) on Sundays.
			break;

		default:
			shopClosingTime = 17; // Shop closes 1700h (i.e. 5pm) on all other days.
			break;
		}
		
		System.out.printf("Today is day %d, and closing time is %d00h\n", dayOfWeek, shopClosingTime);
	}

}
