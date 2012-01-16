package demo.inheritance;

public class CurrentAccount extends BankAccount {

	// Define additional instance data.
	private double[] chequeBook;
	private int chequesWritten;

	
	// Define additional class data.
	private static final double GUARANTEED_LIMIT = 30000;	// The first £30,000 of the balance in guaranteed.


	// Constructors.
	public CurrentAccount(String accountHolder, int chequeBookSize) {
		super(accountHolder);
		chequeBook = new double[chequeBookSize];
	}

	
	// Additional methods.
	public void writeCheque(double amount) {
		if (chequesWritten == chequeBook.length) {
			System.out.println("Can't write cheque for " + amount);
		} 
		else {
			System.out.println("Written cheque for " + amount);
			chequeBook[chequesWritten++] = amount;
			withdraw(amount);
		}
	}

	
	public void displayCheques() {
		for (int i = 0; i < chequesWritten; i++) {
			System.out.println("Cheque " + i + "\t: " + chequeBook[i]);
		}
	}

	
	// Overrides of members from superclass.
	@Override
	public String toString() {
		String str = String.format("%s [%d cheques written]", super.toString(), chequesWritten);
		return str;
	}
	
	
	// Implementation of abstract members from superclass.
	public String getTermsAndConditions() {
		return "Current Accounts do not accrue interest. " +
		       "Account holders can request a cheque book, and they can say how many cheques they're likely to need. " + 
		       "Current Accounts are guaranteed by law for the first £" + GUARANTEED_LIMIT;
	}
	
	public double getGuaranteedLimit() {
		return GUARANTEED_LIMIT;
	}
		
}
