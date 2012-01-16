package solution.arrays;

import java.util.Scanner;    // Gives us easy access to the Scanner class.

// Product class, just used in this file.
class Product {

	private String name;
	private double unitPrice;
	
	public Product(String name, double unitPrice) {
		this.name = name;
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return String.format("%s %.2f", name, unitPrice);
	}
}


// Main entry-point.
public class ArrayOfObjects {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		// Ask user how big they want the array to be.
		System.out.print("How many elements do you want in your product array? ");
		int numElems = scanner.nextInt();
		
		// Create a product array of specified size.
		Product[] array = new Product[numElems];
		
		// Ask user for array values.
		for (int i = 0; i < array.length; i++) {
			System.out.print("Enter name and unit price for product " + i + ": ");
			String name = scanner.next();
			double unitPrice = scanner.nextDouble();
			
			array[i] = new Product(name, unitPrice);
		}
		
		System.out.println("\nProducts: ");
		for (Product prod: array) {
			System.out.println(prod);
		}
	}
}
