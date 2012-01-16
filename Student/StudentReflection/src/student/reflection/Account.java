package student.reflection;

public class Account {

	private String holder;
	private Logger logger;
	private double balance = 0.0;
	
	public Account(String holder, Logger logger) {
		this.holder = holder;
		this.logger = logger;
	}
	
	public void deposit(double amount) {
		logger.logMessage(String.format("Account: %s, depositing %.2f.", holder, amount));
		balance += amount;
	}

	public void withdraw(double amount) {
		logger.logMessage(String.format("Account: %s, withdrawing %.2f.", holder, amount));
		balance += amount;
	}
	
	public double getBalance() {
		logger.logMessage(String.format("Account: %s, balance is %.2f", holder, balance));
		return balance;
	}
}
