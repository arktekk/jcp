package solution.arrays;

import java.util.Scanner;    // Gives us easy access to the Scanner class.

public class MultiDimArrays {

	public static void main(String[] args) {
		useRectangularArray();
		useJaggedArray();
	}
	
	
	private static void useRectangularArray() {

		System.out.println("Using rectangular arrays...");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Number of rows required? ");
		int numRows = scanner.nextInt();
		
		System.out.print("Number of columns required? ");
		int numCols = scanner.nextInt();

		// Create and initialize 1st matrix.
		int [][] m1 = new int[numRows][numCols];
		System.out.print("\nEnter data for 1st matrix:");
		for (int r = 0; r < m1.length; r++) {
			for (int c = 0; c < m1[r].length; c++) {
				System.out.printf("Enter element [%d][%d]: ", r, c);
				m1[r][c] = scanner.nextInt();
			}
		}
		
		// Create and initialize 2nd matrix.
		int [][] m2 = new int[numRows][numCols];
		System.out.println("\nEnter data for 2nd matrix:");
		for (int r = 0; r < m2.length; r++) {
			for (int c = 0; c < m2[r].length; c++) {
				System.out.printf("Enter element [%d][%d]: ", r, c);
				m2[r][c] = scanner.nextInt();
			}
		}

		// Output sum of matrix elements.
		System.out.println("Sum of matrix elements:");
		for (int r = 0; r < m1.length; r++) {
			for (int c = 0; c < m1[r].length; c++) {
				System.out.printf("%2d ", m1[r][c] + m2[r][c]);
			}
			System.out.println();
		}

		// Output difference of matrix elements.
		System.out.println("Difference of matrix elements:");
		for (int r = 0; r < m1.length; r++) {
			for (int c = 0; c < m1[r].length; c++) {
				System.out.printf("%2d ", m1[r][c] - m2[r][c]);
			}
			System.out.println();
		}
	}


	private static void useJaggedArray() {

		System.out.println("\nUsing jagged arrays...");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Number of rows required? ");
		int numRows = scanner.nextInt();
		
		// Declare jagged array.
		int [][] m1 = new int[numRows][];
		
		// Create each row in the jagged array.
		for (int r = 0; r < m1.length; r++) {
			System.out.printf("Number of columns in row %d? ", r);
			int numCols = scanner.nextInt();
			m1[r] = new int[numCols]; 
		}
		
		// Initialize the jagged array.
		System.out.println("\nEnter data jagged array:");
		for (int r = 0; r < m1.length; r++) {
			for (int c = 0; c < m1[r].length; c++) {
				System.out.printf("Enter element [%d][%d]: ", r, c);
				m1[r][c] = scanner.nextInt();
			}
		}

		// Output the jagged array.
		System.out.println("\nHere's the jagged array:");
		for (int r = 0; r < m1.length; r++) {
			for (int c = 0; c < m1[r].length; c++) {
				System.out.printf("%2d ", m1[r][c]);
			}
			System.out.println();
		}
	}
}
