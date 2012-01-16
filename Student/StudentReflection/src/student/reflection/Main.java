package student.reflection;

public class Main {

	public static void main(String[] args) {
		
		// The following method creates either a MemoryLogger object or a FileLogger object, without using reflection.		
		Logger logger = createLoggerStatically();

		if (logger == null) {
			System.err.println("No logger available, application exiting.");
			System.exit(0);
		}

		// Create an Account object and invoke some methods (the methods write log messages using the supplied Logger object).
		Account myAcc = new Account("Laura", logger);
		myAcc.deposit(1000);
		myAcc.withdraw(200);
		myAcc.deposit(500);
		double balance = myAcc.getBalance();
		System.out.printf("Laura's balance: %.2f\n", balance);

		// Display all the log messages.
		logger.displayLogMessages();
	}
	

	// Create a logger object using static typing.
	private static Logger createLoggerStatically() {
		
		// Uncomment one of these statements, depending on which type of logger you want to use.
		return new MemoryLogger();
		// return new FileLogger();
	}
}
