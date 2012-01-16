package demo.filehandling.additionaltechniques;

import java.io.*;
import java.util.Properties;
import java.util.Date;

public class UsingPropertiesFiles {

	private static final String PROPERTIES_FILE_NAME = "Wiley.properties";

	public static void main(String[] args) {

		Properties properties = new Properties();
		
		try {
		    properties.load(new FileInputStream(PROPERTIES_FILE_NAME));
		
		    String name = (String)properties.get("email");
		    String iq = (String)properties.get("iq");
		    System.out.printf("%s has an iq of %s", name, iq);
		    
		    properties.setProperty("iq", "25");
		    properties.put("pethate", "Road Runner");
		    
		    properties.store(new FileOutputStream(PROPERTIES_FILE_NAME), "Modified at " + new Date());
		} 
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
