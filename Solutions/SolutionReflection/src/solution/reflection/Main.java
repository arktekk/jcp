package solution.reflection;

public class Main {

	public static void main(String[] args) {
		
		// Uncomment one of these statements.		
		Logger logger = createLoggerStatically();
		// Logger logger = createLoggerForClassType(MemoryLogger.class);
		// Logger logger = createLoggerForClassName("solution.reflection.FileLogger");

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
	

	// Create a logger object via reflection, for a specified class type.
	private static Logger createLoggerForClassType(Class<?> theClass) {

		Logger logger = null;
		try {
			// If the class implements the Logger interface, create an instance via reflection.
			if (implementsTargetInterface(theClass, Logger.class)) {
				logger = (Logger)theClass.newInstance();			
			}
		}
		catch (IllegalAccessException ex) {
			System.err.println("IllegalAccessException occurred.");
		}
		catch (InstantiationException ex) {
			System.err.println("InstantiationException occurred.");
		}
		return logger;
	}

	
	// Create a logger object via reflection, for a specified class name. This relies entirely on reflection.
	private static Logger createLoggerForClassName(String className) {

		Logger logger = null;
		try {
			// Get the Class object for specified class.
			Class<?> theClass = Class.forName(className);
		
			// Create an instance of the class via reflection.
			logger = createLoggerForClassType(theClass);
		}
		catch (ClassNotFoundException ex) {
			System.err.println("ClassNotFoundException occurred.");
		}
		return logger;
	}

	
	// Test whether the specified class type implements a specified interface type.
	private static boolean implementsTargetInterface(Class<?> theClass, Class<?> targetInterface) {

		// Get all the interfaces implemented by the class.
		Class<?>[] allImplementedInterfaces = theClass.getInterfaces();
		
		// Loop through all the interfaces, to see if one of them is the target interface. 
		boolean implementsInterface = false;
		for (Class<?> anInterface : allImplementedInterfaces) {
			if (anInterface == targetInterface) {
				implementsInterface = true;
			}
		}
		return implementsInterface;
	}
}
