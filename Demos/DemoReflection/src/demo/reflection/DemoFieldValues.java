package demo.reflection;

import java.lang.reflect.Field;
import java.util.Scanner;

public class DemoFieldValues {

	public static void main(String[] args) {

		Book aBook = new Book("Hitch-hikers Guide to the Galaxy", "Douglas Adams", 6.99);

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the name of an accessible field in the Book class: ");
			String fieldName = scanner.nextLine();

			Class<Book> bookClass = Book.class;
			Field field = bookClass.getField(fieldName);
			System.out.printf("Value of %s field: %s", fieldName, field.get(aBook));
		}
		catch (NoSuchFieldException ex) {
			System.out.println("Exception: no such field");
		}
		catch (IllegalAccessException ex) {
			System.out.println("Exception: illegal access");
		}
	}
}
