package demo.reflection;

import java.util.Date;

public class Book {
	
	// Note: these fields are public (to allow reflection to get/set their values)
	public String title;
	public String author;
	public double price;
	
	public static double salesTaxRate = 20.0;

	private Book() { 
		log("Book object created");
	}
	
	public Book(String title, String author, double price) {
		this();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public double increasePrice(double amount) {
		log("increasePrice() invoked");
		price += amount;
		return price;
	}
	
	@Override
	public String toString() {
		log("toString() invoked");
		return "Book [author=" + author + ", price=" + price + ", title=" + title + "]";
	}
	
	private void log(String message) {
		System.out.printf("[Log message at %s]: %s\n", new Date(), message);
	}
}