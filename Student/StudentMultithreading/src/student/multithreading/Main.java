package student.multithreading;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	
	// This map will hold the result of all directory scans.
	private static Map<String, List<File>> allResults = new HashMap<String, List<File>>();

	
	// Application entry-point.
	public static void main(String[] args) {

		// Display the menu. 
		while (true) {
			System.out.println("\nChoose an option from the menu: ");
			System.out.println("  1. Search a directory");
			System.out.println("  2. List completed searches");
			System.out.println("  3. Show search results");
			System.out.println("  4. Quit");
			System.out.print("\n==> ");
	
			String option = scanner.nextLine();
			if (option.equals("1")) {
				doSearch();
			} 
			else if (option.equals("2")) {
				doListCompletedSearches();
			} 
			else if (option.equals("3")) {
				doShowSearchResult();
			} 
			else if (option.equals("4")) {
				doQuit();
				break;
			}
		}
		System.out.println("Goodbye!");
	}
	

	// Search a directory for its contents.
	private static void doSearch() {
		
		System.out.print("Enter a directory name: ");
		String directoryName = scanner.nextLine().toLowerCase();

		File file = new File(directoryName);
		if (!file.isDirectory()) {
			System.out.println("Directory does not exist!");
		}
		else {

			System.out.println("Starting search of " + directoryName);

			// TODO: Refactor this "search" code to run in a separate thread.
			List<File> thisResult = new ArrayList<File>();
			searchDirectory(new File(directoryName), thisResult);
			
			// When we're done, add this result to the "allResults" collection.
			allResults.put(directoryName, thisResult);
		}
	}
	
	
	// Recursive method, to search a particular directory for all its entries (files and sub-directories).
	private static void searchDirectory(File directory, List<File> thisResult) {

		// Loop through directory, to find all files and sub-directories.
		for (File fileEntry : directory.listFiles()) {
			
			// Add the file entry to this result.
        	thisResult.add(fileEntry);	

        	// If the file entry is a sub-directory, search it recursively.
	        if (fileEntry.isDirectory()) {
	        	searchDirectory(fileEntry, thisResult);	
	        } 
		}
	}

	
	// List all the search operations that have completed so far.
	private static void doListCompletedSearches() {
	
		System.out.println("Here is a list of all completed searches:");
		for (String directoryName : allResults.keySet()) {
			System.out.println("  " + directoryName);
		}
	}
	
	
	// Show the results for a particular search.
	private static void doShowSearchResult() {
		
		System.out.print("Enter a directory name: ");
		String directoryName = scanner.nextLine();

		List<File> files = allResults.get(directoryName.toLowerCase());
		if (files == null) {
			System.out.println("No search results available for " + directoryName);
		} 
		else {
			System.out.println("Entries in directory " + directoryName);
			for (File file : files) {
				System.out.println("  " + (file.isDirectory() ? "[D] " : "[F] ") + file);
			}
		}
	}
	
	
	// Tidy-up before the application quits.
	private static void doQuit() {

		// TODO (if time permits): Give each thread 3 seconds to finish.

	}
}
