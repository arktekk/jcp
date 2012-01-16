package demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class DemoConstructorInfo {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a fully qualified Java typename: ");
		String typeName = scanner.nextLine();

		try {
			Constructor<?>[] ctors = Class.forName(typeName).getDeclaredConstructors();
			for (Constructor<?> ctor: ctors) {
				displayConstructorInfo(ctor);
				displayModifierInfo(ctor);
			}
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Exception: class not found");
		}
	}
	
	private static void displayConstructorInfo(Constructor<?> ctor) {
		System.out.printf("Constructor name: %s\n", ctor.getName());
		System.out.printf("Parameters:  %d\n", ctor.getParameterTypes().length);
		System.out.printf("Exceptions:  %d\n", ctor.getExceptionTypes().length);
	}
	
	private static void displayModifierInfo(Constructor<?> ctor) {
		int mod = ctor.getModifiers();
		StringBuffer buf = new StringBuffer();
	
		if (Modifier.isPublic(mod)) 
			buf.append("public "); 
		else if (Modifier.isPrivate(mod)) 
			buf.append("private "); 
		else if (Modifier.isProtected(mod)) 
			buf.append("protected "); 
		
		System.out.printf("Modifiers:   %s\n\n",  buf.toString());
	}
}
