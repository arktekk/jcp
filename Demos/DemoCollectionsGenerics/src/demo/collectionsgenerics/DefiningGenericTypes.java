package demo.collectionsgenerics;

import java.util.ArrayList;

public class DefiningGenericTypes {

	public static void main(String[] args) {
		
		demoCyclicListOfStrings();
		demoCyclicListOfIntegers();
	}
	
	
	public static void demoCyclicListOfStrings() {
		
		System.out.println("\nCreate and use a CyclicList<String>");
		CyclicList<String> dwarfs = new CyclicList<String>(5);
		dwarfs.insert("Happy");
		dwarfs.insert("Sleepy");
		dwarfs.insert("Grumpy");
		dwarfs.insert("Bashful");
		dwarfs.insert("Dopey");
		dwarfs.insert("Doc");
		dwarfs.insert("Sneezy");
		
		String dwarf3 = dwarfs.getItemAt(3);
		System.out.println("Dwarf 3 is: " + dwarf3);
		
		System.out.print("Collection: ");
		dwarfs.display();
	}


	public static void demoCyclicListOfIntegers() {
		
		System.out.println("\n\nCreate and use a CyclicList<Integer>");
		CyclicList<Integer> lotteryNumbers = new CyclicList<Integer>(6);
		lotteryNumbers.insert(19);
		lotteryNumbers.insert(1);
		lotteryNumbers.insert(2);
		lotteryNumbers.insert(7);
		
		int lotteryNumber0 = lotteryNumbers.getItemAt(0);
		System.out.println("Lottery number 0 is: " + lotteryNumber0);
		
		System.out.print("Collection: ");
		lotteryNumbers.display();
		
	}
}


class CyclicList<T> {
	
	private ArrayList<T> elements;
	private int currentPosition;
	private int maxElements;
	
	CyclicList(int size) {
		elements = new ArrayList<T>();
		currentPosition = 0;
		maxElements = size;
		
		// Pre-populate collection with nulls.
		for (int i = 0; i < maxElements; i++) {
			elements.add(null);
		}
	}
	
	public void insert(T item) {
		elements.set(currentPosition, item);
		if (++currentPosition == maxElements) {
			currentPosition = 0;
		}
	}
	
	public T getItemAt(int position) throws IndexOutOfBoundsException {
		if (position >= maxElements) {
			throw new IndexOutOfBoundsException("Indexed beyond end of CyclicList");
		}
		else {
			return elements.get(position);
		}
	}
	
	public void display() {
		for(T item: elements) {
			if (item == null) {
				System.out.print("[Null] ");
			}
			else {
				System.out.print(item.toString() + " ");
			}
		}
	}
}