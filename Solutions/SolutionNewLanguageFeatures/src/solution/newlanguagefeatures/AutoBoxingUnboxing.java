package solution.newlanguagefeatures;

import java.util.ArrayList;

public class AutoBoxingUnboxing {

	public static void main(String[] args) {

		// Declare an Integer variable.
		Integer anInteger = new Integer(42);
		System.out.println("Integer: " + anInteger);
		
		// Automatically unbox Integer to int.
		int anInt = anInteger + 10;	// Implicit unboxing.
		System.out.println("int: " + anInt);
		
		// Create an ArrayList containing an Integer and a (boxed) int.
		ArrayList list = new ArrayList();
		list.add(anInteger);
		list.add(anInt);			// Implicit boxing.

		System.out.println("Here are the items in the ArrayList...");
		for (int i = 0; i < list.size(); i++) {
			
			// Try to access item as an Integer. This gives us a direct reference to heap-based object.
			Integer theInteger = (Integer)list.get(i);
			
			// Try to access item as an int. This gives us an unboxed copy of heap-based object.
			int theInt = (Integer)list.get(i);		// Implicit unboxing.

			System.out.printf("  Item %d as Integer: %d, as int: %d\n", i, theInteger, theInt);
		}
	}
}
