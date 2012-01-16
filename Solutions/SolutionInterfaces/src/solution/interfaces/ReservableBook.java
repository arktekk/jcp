package solution.interfaces;

public class ReservableBook 
	extends Book 
	implements Reservable {

	
	// Instance variables.
	private Member reserver;
	
	
	// Constructor.
	public ReservableBook(String title, String author, String isbn, Genre genre) {
		super(title, author, isbn, genre);
	}
	
	
	// Implementation of Reservable interface.
	public boolean isReserved() {
		return (reserver != null);
	}

	public boolean canBeReservedFor(Member member) {
		return canBeBorrowedBy(member);
	}

	public boolean reserveItemFor(Member member) {

		// Is the item currently borrowed (and not already reserved), and is the specified member allowed to reserve it?
		if (isBorrowed() && !isReserved() && canBeReservedFor(member)) {
			reserver = member;
			return true;
		} else {
			return false;
		}
	}
	
	
	// Additional overrides.
	@Override
	public void returnItem() {
		
		// Perform the "normal" business rules for a returned item.
		super.returnItem();
		
		// If this item is currently reserved by a member, immediately instigate a "borrow" operation for that member.
		if (reserver != null) {
			this.borrowItemBy(reserver);
			reserver = null;
		} 
	}
}
