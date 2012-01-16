package demo.arrays;

import java.io.File;
import java.util.Scanner;

public class DemoCreatingUsingArrays {

	private static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		demoCreatingArrays();
		demoArrayInitializers();
		demoArrayLength();
		demoArrayTraversal();
	}

	
	public static void demoCreatingArrays() {

		// Array of primitives, of well-known size.
		double[] planetMasses = new double[9];
		
		// Array of objects, of well-known size.
		String[] planetNames = new String[9];

		// Array of whatever, whose size is determined dynamically at run time.
		System.out.print("How many exams do you want to take? ");
		int numExams = scanner.nextInt();
		int[] examMarks = new int[numExams];
	}

	
	public static void demoArrayInitializers() {

		final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		File[] logFiles = { 
				  new File("C:\\errors.log"),
				  new File("C:\\access.log"),
				  new File("C:\\audit.log")
				};

		System.out.println("Days in February: " + DAYS_IN_MONTH[2]);

		logFiles[0] = new File("C:\\fatalErrors.log");
		System.out.println("logFile[0]: " + logFiles[0].getAbsolutePath());
	}

	
	public static void demoArrayLength() {
		
		Scanner scanner = new Scanner(System.in);

		final String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

		System.out.print("\nEnter a day number: ");
		int dayNumber = scanner.nextInt();
		if (dayNumber < 0 || dayNumber >= DAYS_OF_WEEK.length) {
			System.out.println("Day is out of range.");
		}
		else {
			System.out.println("Day " + dayNumber + " is " + DAYS_OF_WEEK[dayNumber]);
		}
	}

	
	public static void demoArrayTraversal() {
		
		final String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	
		System.out.println("\nDays of week, using a for loop.");
		for (int i = 0; i < DAYS_OF_WEEK.length; i++) {
			System.out.println("Day " + i + " is " + DAYS_OF_WEEK[i]);
		}
	
		System.out.println("\nDays of week, using a for-each loop.");
		for (String dayOfWeek : DAYS_OF_WEEK) {
			System.out.println("Here's a day: " + dayOfWeek);
		}
	}
}
