package demo.newlanguagefeatures;

import java.util.ArrayList;

public class AutoBoxingUnboxing {

	public static void main(String[] args) {
		testManualBoxingUnboxing();
		testAutoBoxingUnboxing();
		
		testManualBoxingUnboxingWithGenerics();		// Also see the "Generic" chapter.
		testAutoBoxingUnboxingWithGenerics();		// Also see the "Generic" chapter.
	}

	private static void testManualBoxingUnboxing() {
		System.out.println("Manual boxing/unboxing:");

		ArrayList list = new ArrayList();
		list.add(new Integer(12345));    

		Integer wrappedValue = (Integer) list.get(0);
		int primitiveValue = wrappedValue.intValue();      
		System.out.println("Value is " + primitiveValue);
	}

	private static void testAutoBoxingUnboxing() {
		System.out.println("\nAutoboxing/unboxing:");

		ArrayList list = new ArrayList();
		list.add(12345);    

		int primitiveValue = (Integer) list.get(0);	
		System.out.println("Value is " + primitiveValue);
	}

	private static void testManualBoxingUnboxingWithGenerics() {
		System.out.println("\nManual boxing/unboxing with generics:");

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(12345));    

		Integer wrappedValue = list.get(0);
		int primitiveValue = wrappedValue.intValue();      
		System.out.println("Value is " + primitiveValue);
	}

	private static void testAutoBoxingUnboxingWithGenerics() {
		System.out.println("\nAutoboxing/unboxing with generics:");

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(12345);    

		int primitiveValue = list.get(0);	
		System.out.println("Value is " + primitiveValue);
	}
}
