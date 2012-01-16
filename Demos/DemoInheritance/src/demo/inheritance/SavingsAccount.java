package demo.inheritance;

public class SavingsAccount extends BankAccount {

	// Define additional instance data.
	private boolean premium;
	private boolean goneOverdrawn;

	
	// Define additional class data.
	private static final double BASIC_INTEREST_RATE   = 0.015;	// Represents 1.5%
	private static final double PREMIUM_INTEREST_RATE = 0.030;	// Represents 3.0%
	private static final double GUARANTEED_LIMIT      = 50000;	// The first £50,000 of the balance in guaranteed.

	
	// Constructors.
	public SavingsAccount(String accountHolder, boolean premium) {
		super(accountHolder);
		this.premium = premium;
	}

	
	// Additional methods.
	public void applyInterest() {
		if (balance < 0) {
			// Sorry mate, no interest if you're overdrawn.
		}
		else if (premium && !goneOverdrawn) {
			balance *= (1 + PREMIUM_INTEREST_RATE);
		}
		else {
			balance *= (1 + BASIC_INTEREST_RATE);
		}
		goneOverdrawn = false;
	}

	
	// Overrides of members from superclass.
	@Override
	public double withdraw(double amount) {
		super.withdraw(amount);
		if (balance < 0) {
			goneOverdrawn = true;
		}
		return balance;
	}
	
	
	@Override
	public String toString() {
		String str = String.format("%s [%s, %s]", 
						super.toString(),
						premium ? "Premium" : "Normal",
					    goneOverdrawn ? "gone overdrawn" : "not gone overdrawn");
		return str;
	}
	
	
	// Implementation of abstract members from superclass.
	public String getTermsAndConditions() {
		return "Savings Accounts accrue interest at 3% pa (premium accounts) or 1.5% otherwise. " +
		       "If the account goes overdrawn during the year, the 1.5%  interest rate applies regardless. " + 
		       "Savings Accounts are guaranteed by law for the first £" + GUARANTEED_LIMIT;
	}
	
	
	public double getGuaranteedLimit() {
		return GUARANTEED_LIMIT;
	}	
}
