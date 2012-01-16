package demo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class DemoFieldInfo {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a fully qualified Java typename: ");
		String typeName = scanner.nextLine();

		try {
			Field[] fields = Class.forName(typeName).getDeclaredFields();
			for (Field field: fields) {
				displayFieldInfo(field);
				displayModifierInfo(field);
			}
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Exception: class not found");
		}
	}
	
	private static void displayFieldInfo(Field field) {
		System.out.printf("Field name: %s\n", field.getName());
		System.out.printf("Field type: %s\n", field.getType());
	}
	
	private static void displayModifierInfo(Field field) {
		int mod = field.getModifiers();
		StringBuffer buf = new StringBuffer();
	
		if (Modifier.isPublic(mod)) 
			buf.append("public "); 
		else if (Modifier.isPrivate(mod)) 
			buf.append("private "); 
		else if (Modifier.isProtected(mod)) 
			buf.append("protected "); 
		
		if (Modifier.isStatic(mod)) 
			buf.append("static"); 
								
		System.out.printf("Modifiers: %s\n\n",  buf.toString());
	}
}
