package student.interfaces;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// Books have a genre, of the following type: 
enum Genre {
	Children, 
	Fiction, 
	NonFiction
}


// A book is a kind of item.
public class Book extends Item {

	// Instance variables.
	private String author;
	private String isbn;
	private Genre genre;
	
	
	// Constructor.
	public Book(String title, String author, String isbn, Genre genre) {
		super(title);
		this.author = author;
		this.isbn = isbn;
		this.genre = genre;
	}
	
	
	// Overrides.
	@Override
	public boolean canBeBorrowedBy(Member member) {
		
		if (genre == Genre.Children) {
			// Children's books can only be borrowed by children.
			return member.getAge() <= 16;
		} else {
			// Other books can be borrowed by anyone.
			return true;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s\n  Additional book details: %s %s %s.", super.toString(), author, isbn, genre);
	}


	// Implementations of abstract methods.
	public Date dateDueBack() {
		
		if (dateBorrowed == null) {
			return null;

		} else {
			Calendar cal = new GregorianCalendar();
			cal.setTime(dateBorrowed);
			cal.add(Calendar.DATE, 21);
			return cal.getTime();
		}
	}
}

