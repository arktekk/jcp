package student.reflection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger implements Logger {

	private static final String LOG_FILE_NAME = "log.txt";
	
	public void logMessage(String message) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE_NAME, true));
			bw.append(String.format("[%s] %s", new Date(), message));
			bw.newLine();
			bw.close();
		} 
		catch (IOException ex) {
			System.err.println("IOException occurred: " + ex.getMessage());
		}
	}

	public void displayLogMessages() {
		System.out.println("Log messages:");
		try {
			BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_NAME));
			
			String message;
			while ((message = br.readLine()) != null) {
				System.out.println(message);
			}
		} 
		catch (IOException ex) {
			System.err.println("IOException occurred: " + ex.getMessage());
		}
	}
}
