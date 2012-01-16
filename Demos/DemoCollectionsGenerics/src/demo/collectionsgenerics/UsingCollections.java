package demo.collectionsgenerics;

import java.util.*;

public class UsingCollections {

	public static void main(String[] args) {
		demoUsingArrayList();
		demoUsingLinkedList();
		demoUsingHashSet();
		demoUsingHashMap();
	}

	public static void demoUsingArrayList() {

		// Create an ArrayList with default capacity (of 10).
		ArrayList<String> cities = new ArrayList<String>();

		// Create an ArrayList with a specific capacity.
		ArrayList<String> countries = new ArrayList<String>(30);
		
		// Add items at end, or add/set at specific positions.
		countries.add("France");
		countries.add("Italy");
		countries.add("Spain");
		countries.add(2, "Wales");
		countries.set(2, "Cymru");

		System.out.println("\nArrayList:");
		for(String country: countries) {
			System.out.println(country);
		}
		System.out.println("In one go: " + countries);

		// Create an ArrayList from another Collection.
		ArrayList<String> countries2 = new ArrayList<String>(countries);
		
		// Retrieve items / info.
		int size = countries.size();
		String item2 = countries.get(2);
		int spainIndex = countries.indexOf("Spain");
		boolean isFranceThere = countries.contains("France");
		boolean isEmpty = countries.isEmpty();
		
		// Remove items.
		String removedItem1 = countries.remove(1);
		boolean isSpainRemoved = countries.remove("Spain");
		
		// General manipulation.
		countries.trimToSize();
		
		return;
	}
	
	public static void demoUsingLinkedList() {

		// Create an empty LinkedList.
		LinkedList<String> countries = new LinkedList<String>();
		
		// Add items at start or end.
		countries.addLast("England");
		countries.addLast("Scotland");
		countries.addLast("Ireland");
		countries.addFirst("Wales");	// :=)

		System.out.println("\nLinkedList in descending order:");
		Iterator<String> iter = countries.descendingIterator();
		while (iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}

		// Retrieve items / info.
		String first = countries.getFirst();
		String last = countries.getLast();
		int lastEnglandIndex = countries.lastIndexOf("England");

		// Peek and poll items.
		String peek = countries.peek();
		String peekFirst = countries.peekFirst();
		String peekLast  = countries.peekLast();
		String poll = countries.poll();
		String pollFirst = countries.pollFirst();
		String pollLast  = countries.pollLast();

		// Push and pop items.
		countries.push("France");
		countries.push("Italy");
		String shouldBeItaly = countries.pop();
		
		// Remove items.
		String shouldBeFrance = countries.removeFirst();
		boolean isFranceRemoved = countries.removeFirstOccurrence("France");
		String shouldBeScotland = countries.removeLast();
		boolean isScotlandRemoved = countries.removeLastOccurrence("Scotland");
		
		return;
	}


	public static void demoUsingHashSet() {

		// Create a HashSet with default capacity (of 16) and load factor (of 0.75).
		HashSet<String> cities = new HashSet<String>();

		// Create a HashSet with a specific capacity, and optionally a load factor.
		HashSet<String> countries = new HashSet<String>(30, 0.5F);

		// Add items to unordered set.
		countries.add("Norway");
		countries.add("Sweden");
		countries.add("Denmark");
		countries.add("Finland");	

		System.out.println("\nHashSet, note it's unordered:");
		for(String country: countries) {
			System.out.println(country);
		}

		// Retrieve items / info.
		int size = countries.size();
		boolean isFinlandThere = countries.contains("Finland");
		boolean isEmpty = countries.isEmpty();

		// Remove items.
		boolean isSwedenRemoved = countries.remove("Sweden");

		return;
	}


	public static void demoUsingHashMap() {

		// Create a HashMap with default capacity (of 16) and load factor (of 0.75).
		HashMap<String, String> cities = new HashMap<String, String>();

		// Create a HashMap with a specific capacity, and optionally a load factor.
		HashMap<String, String> countries = new HashMap<String, String>(30, 0.5F);

		// Put items to unordered map.
		countries.put("UK",      "+44");
		countries.put("Norway",  "+47");
		countries.put("Austria", "+43");
		countries.put("USA",     "+1");
		countries.put("Canada",  "+1");

		System.out.println("\nHashMap, note it's unordered:");
		Set<Map.Entry<String, String>> items = countries.entrySet();
		
		for (Map.Entry<String, String> entry: items) {
			String country      = entry.getKey();
			String diallingCode = entry.getValue();
			
			System.out.println(country + "\t: " + diallingCode);
		}

		// Access all keys / values.
		System.out.println("Keyset: " + countries.keySet());
		System.out.println("Values: " + countries.values());
		
		// Retrieve items / info.
		int size = countries.size();
		boolean isNorwayThere = countries.containsKey("Norway");
		boolean isNorwayDiallingCodeThere = countries.containsKey("+47");
		boolean isEmpty = countries.isEmpty();

		// Remove items.
		String shouldbeAustriaDiallingCode = countries.remove("Austria");

		return;
	}
}
