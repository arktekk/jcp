package demo.inheritance;

import java.util.Date;

public abstract class BankAccount {

	// Instance data.
	private String accountHolder;
	private int id;
	protected double balance = 0.0;
	private Date creationTimestamp = new Date();
	
	// Class data.
	private static int nextId = 1;
	public static final double OVERDRAFT_LIMIT = -1000;
	
	// Constructors.
	public BankAccount() {
		this("Anonymous"); 
	}
	
	public BankAccount(String accountHolder) {
		this.accountHolder = accountHolder;
		id = nextId++;
	}
	
	static 
	{
		// Place non-trivial static initialization here. 
	}

	// Getters/setters.
	public String getAccountHolder() {
		return accountHolder;
	}
	
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public final int getId() {
		return id;
	}

	public final double getBalance() {
		return balance;
	}

	public final Date getCreationTimestamp() {
		return creationTimestamp;
	}
	
	// Business methods.
	public double deposit(double amount) {
		balance += amount;
		return balance;
	}
	
	public double deposit(int dollars, int cents) {
		double amount = dollars + cents/100;
		return this.deposit(amount);
	}
	
	public double withdraw(double amount) {
		double newBalance = balance - amount;
		if (newBalance < OVERDRAFT_LIMIT) {
			System.err.println("Insufficient funds to withdraw " + amount);
		}
		else {
			balance = newBalance;
		}
		return balance;
	}
	
	public double withdraw(int dollars, int cents) {
		double amount = dollars + cents/100;
		return this.withdraw(amount);
	}

	// toString() method.
	@Override
	public String toString() {
		String str = String.format("[%d] %s, %.2f", id, accountHolder, balance);
		return str;
	}
	
	// Abstract methods.
	public abstract String getTermsAndConditions();
	public abstract double getGuaranteedLimit();
	
	// Static methods.
	public static int getNextId() {
		return nextId;
	}
}
