package demo.arrays;

import java.util.Arrays;

public class DemoArraysClass {

	public static void main(String[] args) {
		demoFill();
		demoCopy();
		demoEquals();
		demoSort();
		demoSearch();
	}

	
	public static void demoFill() {

		int[] examMarks = { 89, 56, 82, 99, 72, 79, 64 };

		Arrays.fill(examMarks, 99);
		displayIntArray(examMarks, "Filled array with 99s.");

		Arrays.fill(examMarks, 2, 5, 100);
		displayIntArray(examMarks, "Filled array elements 2,3,4 with 100.");
	}

	
	public static void demoCopy() {

		int[] examMarks = { 89, 56, 82, 99, 72, 79, 64 };

		int[] first3 = Arrays.copyOf(examMarks, 3);
		displayIntArray(first3, "Copy of first 3 elements.");

		int[] tenElems = Arrays.copyOf(examMarks, 10);
		displayIntArray(tenElems, "Copy of 10 elements.");

		int[] middle3Elems = Arrays.copyOfRange(examMarks, 2, 5);
		displayIntArray(middle3Elems, "Copy of middle 3 elements.");
	}

	
	public static void demoEquals() {

		int[] arr1 = { 89, 56, 82, 99, 72, 79, 64 };
		int[] arr2 = { 89, 56, 82, 99, 72, 79, 64 };
		int[] arr3 = { 11, 56, 82, 99, 72, 79, 64 };
		int[] arr4 = { 89, 56, 82, 99, 72, 79 };

		System.out.println("\narr1 equals arr2? " + Arrays.equals(arr1, arr2));
		System.out.println("arr1 equals arr3? " + Arrays.equals(arr1, arr3));
		System.out.println("arr1 equals arr4? " + Arrays.equals(arr1, arr4));

		String[] nephews1 = { "Huey", "Lewey", "Dewey" };
		String[] nephews2 = { "Huey", "Lewey", "Dewey" };

		System.out.println("nephews1 equals nephews2? "
				+ Arrays.equals(nephews1, nephews2));
	}

	
	public static void demoSort() {

		int[] examMarks = { 89, 56, 82, 99, 72, 79, 64 };

		Arrays.sort(examMarks, 2, 5);
		displayIntArray(examMarks, "\nSorted array elements 2,3,4.");

		Arrays.sort(examMarks);
		displayIntArray(examMarks, "Sorted all elements.");
	}

	
	public static void demoSearch() {

		int[] examMarks = { 89, 56, 82, 99, 72, 79, 64 };

		Arrays.sort(examMarks);

		System.out.println("\nIndex of 99: " + Arrays.binarySearch(examMarks, 99));
		System.out.println(  "Index of 22: " + Arrays.binarySearch(examMarks, 22));
	}

	
	private static void displayIntArray(int[] array, String msg) {
		System.out.println("\n" + msg);
		for (int elem : array) {
			System.out.println(elem);
		}
	}
}
