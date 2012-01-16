package solution.interfaces;

public class MainProgram {

	public static void main(String[] args) {

		// Create some members.
		Member member1 = new Member("Ben", 10);
		Member member2 = new Member("Zak", 15);
		Member member3 = new Member("Joe", 30);
		Member member4 = new Member("Don", 50);
		Member member5 = new Member("Jan", 65);
		Member member6 = new Member("Zoe", 75);
		Member member7 = new Member("Tim", 120);
		
		// Create an array to hold items, and add various items to it.
		Item[] items = new Item[6];
		items[0] = new ReservableBook("Great Expectations", "Charles Dickens", "978-0141439563", Genre.Fiction);
		items[1] = new ReservableBook("The First Moon Landing", "Gillian Clements", "978-0749649333", Genre.NonFiction);
		items[2] = new Book("The Griffalo", "Julia Donaldson", "B001TIBX3K", Genre.Children);
		items[3] = new DVD("Shrek 3", 90, Classification.Universal);
		items[4] = new DVD("The Bourne Ultimatum", 100, Classification.Youth);
		items[5] = new DVD("The Sopranos", 420, Classification.Adult);
		
		// Create an array to hold any items that are reservable.
		Reservable[] reservableItems = new Reservable[items.length];
		
		// Populate Reservable array with all the items that are reservable.
		int pos = 0;
		for (Item item: items) {
			if (item instanceof Reservable) {
				reservableItems[pos++] = (Reservable)item;
			}
		}

		
		// Test 1: Try to reserve a ReservableBook that isn't yet borrowed. Should fail.
		boolean result1 = reservableItems[0].reserveItemFor(member1);
		System.out.println("Can we reserve a ReservableBook that isn't yet borrowed? " + result1);
		
		
		// Test 2: Try to reserve a ReservableBook that has been borrowed. Should succeed.
		items[0].borrowItemBy(member1);
		System.out.println("\nJust borrowed item: " + items[0]);
		
		boolean result2 = reservableItems[0].reserveItemFor(member2);
		System.out.println("Can we reserve a ReservableBook that has been borrowed? " + result2);
		
		items[0].returnItem();
		System.out.println("\nJust returned item: " + items[0]);
		
		items[0].returnItem();
		System.out.println("\nJust returned item again: " + items[0]);


		// Test 3: Borrow a DVD and then reserve it lots of time.
		items[3].borrowItemBy(member1);
		reservableItems[2].reserveItemFor(member2);
		reservableItems[2].reserveItemFor(member3);
		reservableItems[2].reserveItemFor(member4);
		reservableItems[2].reserveItemFor(member5);
		reservableItems[2].reserveItemFor(member6);
		reservableItems[2].reserveItemFor(member7);		// Should not be allowed to reserve.
		
		items[3].returnItem();
		System.out.println("\nJust returned item: " + items[3]);

		items[3].returnItem();
		System.out.println("\nJust returned item: " + items[3]);

		items[3].returnItem();
		System.out.println("\nJust returned item: " + items[3]);
		
		items[3].returnItem();
		System.out.println("\nJust returned item: " + items[3]);
		
		items[3].returnItem();
		System.out.println("\nJust returned item: " + items[3]);
		
		items[3].returnItem();
		System.out.println("\nJust returned item: " + items[3]);
	}
}
