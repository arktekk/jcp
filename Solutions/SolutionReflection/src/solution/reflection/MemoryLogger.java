package solution.reflection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemoryLogger implements Logger {

	private List<String> messages;

	public MemoryLogger() {
		this.messages = new ArrayList<String>();
	}

	public void logMessage(String message) {
		messages.add(String.format("[%s] %s", new Date(), message));
	}

	public void displayLogMessages() {
		System.out.println("Log messages:");
		for (String message: messages) {
			System.out.println(message);
		}
	}
}
