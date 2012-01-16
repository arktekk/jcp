package demo.javalang;

import java.io.*; // Gives us easy access to all classes/interfaces in java.io package.

public class DemoVariables {

	public static void main(String[] args) {
		demoUsingClasses();
	}

	
	public static void demoUsingClasses() {
		File f = new File("C:\\eclipse\\notice.html");
		long len = f.length();
		System.out.println("File is " + len + " bytes long.");
		f = null;
	}
}
