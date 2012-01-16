package demo.filehandling;

import java.io.*;

public class UsingFileClass {

	public static void main(String[] args) {

		try {
			demoCreatingDirectory();
			demoCreatingFile();
			demoDisplayingFileInfo();
			demoDisplayingDirectoryInfo();
			
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

	
	public static void demoCreatingDirectory() {
		
		String dirName = "c:/MyNewFolder/MyNewSubFolder";
		File dir = new File(dirName);

		if (dir.exists()) {
			System.out.printf("Directory %s already exists.\n", dirName);
		}
		else {
		    dir.mkdirs();
			System.out.printf("Created directory %s.\n", dirName);
		}		    
	}


	public static void demoCreatingFile() throws IOException {
		
		String dirName = "c:/MyNewFolder/MyNewSubFolder/";
		String fileName = "Customers.txt";
		File customersFile = new File(dirName + fileName);
		
		if (customersFile.exists()) {
			System.out.printf("File %s already exists.\n", customersFile);
		}
		else {
			customersFile.createNewFile();
			System.out.printf("Created file %s.\n", customersFile );
		}
	}


	public static void demoDisplayingFileInfo() {
		
		String dirName = "c:/MyNewFolder/MyNewSubFolder/";
		String fileName = "Customers.txt";
		File customersFile = new File(dirName + fileName);
		
		System.out.printf("\nName:          %s\n", customersFile.getName());
		System.out.printf(  "Absolute path: %s\n", customersFile.getAbsolutePath());
		System.out.printf(  "Is file?       %b\n", customersFile.isFile());
		System.out.printf(  "Is directory?  %b\n", customersFile.isDirectory());
		System.out.printf(  "Can read?      %b\n", customersFile.canRead());
		System.out.printf(  "Can write?     %b\n", customersFile.canWrite());
		System.out.printf(  "Length:        %d\n", customersFile.length());
	}


	public static void demoDisplayingDirectoryInfo() {
		
		String dirName = "c:/MyNewFolder/MyNewSubFolder/";
		File dir = new File(dirName);
	
		if (dir.exists() && dir.isDirectory()) {
			
			System.out.printf("\nAbsolute path: %s\n", dir.getAbsolutePath());
			System.out.printf(  "Is file?       %b\n", dir.isFile());
			System.out.printf(  "Is directory?  %b\n", dir.isDirectory());
			System.out.printf(  "Can read?      %b\n", dir.canRead());
			System.out.printf(  "Can write?     %b\n", dir.canWrite());
			System.out.printf(  "Length:        %d\n", dir.length());
	
		    System.out.println("Files: ");
		    for (String filename : dir.list())
		        System.out.println("\t" + filename);
		}
	}
}
