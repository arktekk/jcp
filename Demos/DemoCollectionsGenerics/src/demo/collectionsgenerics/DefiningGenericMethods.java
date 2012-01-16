package demo.collectionsgenerics;

import java.util.*;

public class DefiningGenericMethods {

	public static void main(String[] args) {
		
		MyUtilityClass.displayType(new Date());
		
		Integer[] array = new Integer[] {10, 20, 30};
		MyUtilityClass.displayType(array[0]);
		MyUtilityClass.displayType(array);
		MyUtilityClass.displayArray(array);
	}
}

class MyUtilityClass {
	
	public static <T> void displayType(T obj) {
		System.out.println("Object type: " + obj.getClass().getName());
	}
	
	public static <T> void displayArray(T[] array) {
		System.out.print("Array items: ");
		for(T item: array) {
			System.out.print(item.toString() + " ");
		}
	}
}