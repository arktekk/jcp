package solution.inheritance;

public class MainProgram {

	public static void main(String[] args) {

		// Create some members.
		Member[] members = new Member[3];
		members[0] = new Member("Ben", 10);
		members[1] = new Member("Zak", 15);
		members[2]  = new Member("Joe", 30);
		
		// Create an array to hold all items.
		Item[] items = new Item[6];
		
		// Create some books.
		items[0] = new Book("Great Expectations",     "Charles Dickens",  "978-0141439563", Genre.Fiction);
		items[1] = new Book("The First Moon Landing", "Gillian Clements", "978-0749649333", Genre.NonFiction);
		items[2] = new Book("The Griffalo",           "Julia Donaldson",  "B001TIBX3K",     Genre.Children);

		// Create some DVDs.
		items[3] = new DVD("Shrek 3",              90,  Classification.Universal);
		items[4] = new DVD("The Bourne Ultimatum", 100, Classification.Youth);
		items[5] = new DVD("The Sopranos",         420, Classification.Adult);
		
		// See if a member can borrow many items.
		items[0].borrowItemBy(members[0]);
		items[3].borrowItemBy(members[0]);
		System.out.println("member[0]: "  + members[0]);
		System.out.println("\nitem[0]: "  + items[0]);
		System.out.println("  Due back: " + items[0].dateDueBack());
		System.out.println("\nitem[3]: "  + items[3]);
		System.out.println("  Due back: " + items[3].dateDueBack());
		
		// Make sure an item can't be borrowed if it's already on loan.
		boolean result = items[0].borrowItemBy(members[1]);
		System.out.println("\nCould member borrow item that was already on loan? " + result);

		// Return items.
		items[0].returnItem();
		items[3].returnItem();
		
		// Try to borrow each item by each member (and return it immediately).
		for (Item item : items) {
			
			for (Member member : members) {
				
				if (item.borrowItemBy(member)) {
					System.out.printf("\nSuccessful borrow!\n  %s\n  %s\n", item, member);
					item.returnItem();
				} else {
					System.out.printf("\nUnsuccessful attempt to borrow!\n  %s\n  %s\n", item, member);
				}
			}
		}
	}
}
