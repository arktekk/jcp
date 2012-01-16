package demo.filehandling;

import java.io.Serializable;
import java.util.Date;

public class BankAccount implements Serializable {

	// Instance data.
	private String accountHolder;
	private int id;
	private double balance = 0.0;
	private Date creationTimestamp = new Date();

	// Transient data.
	transient private int numOpsInSession = 0;
	
	// Class data.
	public static final double OVERDRAFT_LIMIT = -1000;

	// Constructor.
	public BankAccount(String accountHolder, int id) {
		this.accountHolder = accountHolder;
		this.id = id;;
	}

	// Getters/setters.
	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public int getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	// Business methods.
	public double deposit(double amount) {
		balance += amount;
		numOpsInSession++;
		return balance;
	}

	public double withdraw(double amount) {
		balance -= amount;
		numOpsInSession++;
		return balance;
	}

	// toString() method.
	@Override
	public String toString() {
		String str = String.format("[%d] %s, %.2f (%d ops in this session)", id, accountHolder, balance, numOpsInSession);
		return str;
	}
}
