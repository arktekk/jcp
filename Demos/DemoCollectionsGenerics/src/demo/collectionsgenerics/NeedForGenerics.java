package demo.collectionsgenerics;

import java.util.*;

public class NeedForGenerics {

	public static void main(String[] args) {
		demoRawTypes();
		demoGenericTypes();
		demoGenericTypes2();
	}

	public static void demoRawTypes() {

		System.out.println("\nDemonstrate the use of raw types.");

		Map players = new HashMap();
		players.put(6,  "Ferrie Bodde");
		players.put(8,  "Darren Pratley");
		players.put(22, "Angel Rangel");
				
		Set items = players.entrySet();
		Iterator iter = items.iterator();

		while (iter.hasNext()) {
		    Map.Entry entry = (Map.Entry)iter.next(); 
		    int number  = (Integer)entry.getKey(); 
		    String name = (String)entry.getValue(); 
		    System.out.println(number + "\t: " + name);		
		}
	}


	public static void demoGenericTypes() {

		System.out.println("\nDemonstrate the use of generic types.");

		Map<Integer, String> players = new HashMap<Integer, String>();
		players.put(6,  "Ferrie Bodde");
		players.put(8,  "Darren Pratley");
		players.put(22, "Angel Rangel");
				
		Set<Map.Entry<Integer, String>> items = players.entrySet();
		Iterator<Map.Entry<Integer, String>> iter = items.iterator();

		while (iter.hasNext()) {
		    Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>)iter.next(); 
		    int number  = entry.getKey(); 
		    String name = entry.getValue(); 
		    System.out.println(number + "\t: " + name);		
		}
	}


	public static void demoGenericTypes2() {

		System.out.println("\nDemonstrate the use of generic types and for-each loops.");

		Map<Integer, String> players = new HashMap<Integer, String>();
		players.put(6,  "Ferrie Bodde");
		players.put(8,  "Darren Pratley");
		players.put(22, "Angel Rangel");
				
		Set<Map.Entry<Integer, String>> items = players.entrySet();
		
		for (Map.Entry<Integer, String> entry: items)
		{
			int number = entry.getKey();
			String name = entry.getValue();
			
			System.out.println("Excellent player's number: " + number + "\tname: " + name);
		}
	}
}
