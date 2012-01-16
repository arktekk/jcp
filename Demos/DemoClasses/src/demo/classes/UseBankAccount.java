package demo.classes;

public class UseBankAccount {

	public static void main(String[] args) {
		
		BankAccount acc1 = new BankAccount();
		BankAccount acc2 = new BankAccount("John Smith");
		
		workWithBankAccount(acc1);
		workWithBankAccount(acc2);

		System.out.println("Next account will have ID " + BankAccount.getNextId());
	}

	
	public static void workWithBankAccount(BankAccount acc) {
	
		acc.deposit(100 * Math.random());
		acc.deposit(10, 50);
		System.out.println("\nBalance after deposits: " + acc.getBalance());
		acc.withdraw(30);
		
		System.out.println(acc.toString());	// Or just acc...
		System.out.println("Created: " + acc.getCreationTimestamp());
	}
}
