package solution.interfaces;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// DVDs have a classification, of the following type: 
enum Classification {
	Universal, 
	Youth, 
	Adult
}


// A DVD is a kind of item.
public class DVD 
	extends Item 
	implements Reservable {

	// Instance variables.
	private int playingTime;
	private Classification classification;
	private Member[] reservers = new Member[5];
	private int numReservations = 0;
	
	
	// Constructor.
	public DVD(String title, int playingTime, Classification classification) {
		super(title);
		this.playingTime = playingTime;
		this.classification = classification;
	}
	
	
	// Overrides.
	@Override
	public boolean canBeBorrowedBy(Member member) {
		
		if (classification == Classification.Universal) {
			// Universal DVDs can be borrowed by anyone.
			return true;
			
		} else if (classification == Classification.Youth) {
			// Youth DVDs can be borrowed by anyone aged 12 or above.
			return member.getAge() >= 12;
		
		} else {
			// Adult DVDs can be borrowed by anyone aged 18 or above.
			return member.getAge() >= 18;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s\n  Additional DVD details: %d %s.", super.toString(), playingTime, classification);
	}

	
	// Implementations of abstract methods.
	public Date dateDueBack() {
		
		if (dateBorrowed == null) {
			return null;

		} else {
			Calendar cal = new GregorianCalendar();
			cal.setTime(dateBorrowed);
			cal.add(Calendar.DATE, 7);
			return cal.getTime();
		}
	}


	// Implementation of Reservable interface.
	public boolean isReserved() {
		return (numReservations != 0);
	}

	public boolean canBeReservedFor(Member member) {
		return canBeBorrowedBy(member);
	}

	public boolean reserveItemFor(Member member) {

		// Is the item currently borrowed (and not already completely reserved), and is the specified member allowed to reserve it?
		if (isBorrowed() && 
			numReservations != reservers.length && 
			canBeReservedFor(member)) {
			
			reservers[numReservations++] = member;
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
		
		// If this item is currently reserved, immediately instigate a "borrow" operation for the first reserver.
		if (numReservations != 0) {
			
			// Borrow item by first reserver.
			this.borrowItemBy(reservers[0]);
			numReservations--;
			
			// Shuffle array elements, to bump everyone one place up the reservation list.
			for (int i = 0; i < numReservations; i++) {
				reservers[i] = reservers[i+1];
			}
			reservers[numReservations] = null;
		} 
	}
}

