package solution.arrays;

import java.util.Scanner;    // Gives us easy access to the Scanner class.

public class ArrayOfPrimitives {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// Ask user how big they want the array to be.
		System.out.print("How many elements do you want in your integer array? ");
		int numElems = scanner.nextInt();
		
		// Create an integer array of specified size.
		int[] array = new int[numElems];
		
		// Ask user for array values.
		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter value for element " + i + ": ");
			array[i] = scanner.nextInt();
		}
		
		System.out.println("\nArray values: ");
		for (int num: array) {
			System.out.println(num);
		}
		
		int countPositiveValues = 0;
		System.out.println("\nPositive values: ");
		for (int num: array) {
			if (num > 0) {
				System.out.println(num);
				countPositiveValues++;
			}
		}
		System.out.println("Count of positive values: " + countPositiveValues);
	}
}