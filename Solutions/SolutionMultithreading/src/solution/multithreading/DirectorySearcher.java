package solution.multithreading;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DirectorySearcher implements Runnable {

	private String directoryName;
	private List<File> thisResult = new ArrayList<File>();
	private Map<String, List<File>> allResults;
	
	
	// Constructor.
	public DirectorySearcher(String directoryName, Map<String, List<File>> allResults) {
		this.directoryName = directoryName;
		this.allResults = allResults;
	}
	
	
	// This method will execute in a different thread.
	public void run() {
		
		// Search the directory (and all its sub-directories).
		searchDirectory(new File(directoryName));
		
		// When we're done, add this result to the "allResults" collection.
		allResults.put(directoryName, thisResult);
	}
	
	
	// Recursive method, to search a directory for all its entries (files and sub-directories).
	private void searchDirectory(File directory) {

		// Loop through directory, to find all files and sub-directories.
		for (File fileEntry : directory.listFiles()) {
			
			// Add the file entry to this result.
        	thisResult.add(fileEntry);	

        	// If the file entry is a sub-directory, search it recursively.
	        if (fileEntry.isDirectory()) {
	        	searchDirectory(fileEntry);	
	        } 
		}
	}
}