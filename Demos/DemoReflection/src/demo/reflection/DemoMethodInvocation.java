package demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoMethodInvocation {

	public static void main(String[] args) {

		try {

			// Get Class object for Book (could also use Class.forName("demo.reflection.Book") here.
			Class<Book> bookClass = Book.class;
			
			// Get Constructor object for the Book constructor we're interested in.
			Constructor<Book> bookCtor = bookClass.getConstructor(String.class, String.class, Double.TYPE);
			
			// Create Book instance.
			Book aBook = bookCtor.newInstance("The Gruffalo", "Julia Donaldson", 6.99);
			
			// Get Method object for the Book method we're interested in.
			Method method = bookClass.getMethod("increasePrice", Double.TYPE);

			// Invoke the method via reflection.
			double newPrice = (Double)method.invoke(aBook, 1.50);
			System.out.printf("New price: %.2f\n", newPrice);
		}
		catch (NoSuchMethodException ex) {
			System.out.println("NoSuchMethodException: " + ex.getMessage());
		}
		catch (IllegalAccessException ex) {
			System.out.println("IllegalAccessException: " + ex.getMessage());
		}
		catch (InstantiationException ex) {
			System.out.println("InstantiationException: " + ex.getMessage());
		}
		catch (InvocationTargetException ex) {
			System.out.println("InvocationTargetException: " + ex.getMessage());
		}
	}
}
