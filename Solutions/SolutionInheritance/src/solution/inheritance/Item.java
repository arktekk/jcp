package solution.inheritance;

import java.util.Date;

public abstract class Item {

	// Instance variables.
	private String title;
	protected Date dateBorrowed = null;
	private Member borrower = null;

	
	// Constructor.
	public Item(String title) {
		this.title = title;
	}
	
	
	// Business methods.
	public boolean isBorrowed() {
		return borrower != null;
	}
	
	public boolean canBeBorrowedBy(Member member) {
		return true;
	}
	
	public boolean borrowItemBy(Member member) {
		
		// Has the item not been borrowed yet, and is the specified member allowed to borrow it?
		if (!isBorrowed() && canBeBorrowedBy(member)) {
		
			// Record the fact that this item is now borrowed by the member.
			borrower = member;
			dateBorrowed = new Date();
			borrower.borrowedItem();

			return true;
		
		} else {
			
			return false;
		}
	}
	
	public void returnItem() {
		
		// Record the fact that this item is no longer borrowed by the member.
		borrower.returnedItem();
		borrower = null;
		dateBorrowed = null;
	}
	
	public abstract Date dateDueBack();
	
	
	// String representation.
	@Override
	public String toString() {
		
		if (borrower != null) {
			return String.format("%s is on loan to %s [borrowed at %tc].", title, borrower.getName(), dateBorrowed);
		} else { 
			return String.format("%s is not on loan.", title);
		}
	}
}
