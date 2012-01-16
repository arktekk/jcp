package demo.newlanguagefeatures;

import java.awt.Color;

public class Varargs {

	public static void main(String[] args) {
		testVarargs();
		testMyVarargs();
	}

	private static void testVarargs() {
		// Calling a varargs method using an array.
		Object[] array = { "Andy", 43, 1.68 };
		System.out.printf("Hi %s, you are %d and your height is %sm.\n", array);

		// Calling a varargs method using a series of separate arguments.
		System.out.printf("Hi %s, you are %d and your height is %sm.\n", "Andy", 43, 1.68);
	}
	
	private static void testMyVarargs() {
		// Calling my varargs method using an array.
		Object[] array = { "Jayne", "Emily", "Thomas", "Swansea City", 3, Color.RED };
		myVarargsMethod("Andy", "Olsen", array);

		// Calling my varargs method using a series of separate arguments.
		myVarargsMethod("Andy", "Olsen", "Jayne", "Emily", "Thomas", "Wales", 3, Color.RED);
	}

	private static void myVarargsMethod(String firstName, String lastName, Object... specialThings) {
		System.out.printf("\nHi %s %s, here are your special things:\n", firstName, lastName);
		for (Object obj: specialThings) {
			System.out.println(" -- " + obj.toString());
		}
	}
}
