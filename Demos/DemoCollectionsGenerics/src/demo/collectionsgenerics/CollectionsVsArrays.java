package demo.collectionsgenerics;

import java.util.*;

public class CollectionsVsArrays {

	public static void main(String[] args) {
		demoUsingArrays();
		demoUsingCollections();
	}

	
	public static void demoUsingArrays() {
		String[] countries = new String[3];
		countries[0] = "Norway";
		countries[1] = "Sweden";
		countries[2] = "Denmark";

		System.out.println("\nCountries (using arrays):");
		for (String country : countries)
			System.out.println(country);
	}

	
	public static void demoUsingCollections() {
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("Norway");
		countries.add("Sweden");
		countries.add("Denmark");

		System.out.println("\nCountries (using collections):");
		for (String country : countries)
			System.out.println(country);
	}
}
