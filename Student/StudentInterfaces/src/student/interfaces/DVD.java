package student.interfaces;

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
public class DVD extends Item {

	// Instance variables.
	private int playingTime;
	private Classification classification;
	
	
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
}

