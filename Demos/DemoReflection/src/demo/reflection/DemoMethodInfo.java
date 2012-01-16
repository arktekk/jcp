package demo.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class DemoMethodInfo {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a fully qualified Java typename: ");
		String typeName = scanner.nextLine();

		try {
			Method[] methods = Class.forName(typeName).getDeclaredMethods();
			for (Method method: methods) {
				displayMethodInfo(method);
				displayModifierInfo(method);
			}
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Exception: class not found");
		}
	}
	
	private static void displayMethodInfo(Method method) {
		System.out.printf("Method name: %s\n",   method.getName());
		System.out.printf("Return type: %s\n",   method.getReturnType().getName());
		System.out.printf("Parameters:  %d\n",   method.getParameterTypes().length);
		System.out.printf("Exceptions:  %d\n",   method.getExceptionTypes().length);
	}
	
	private static void displayModifierInfo(Method method) {
		int mod = method.getModifiers();
		StringBuffer buf = new StringBuffer();
	
		if (Modifier.isPublic(mod)) 
			buf.append("public "); 
		else if (Modifier.isPrivate(mod)) 
			buf.append("private "); 
		else if (Modifier.isProtected(mod)) 
			buf.append("protected "); 
		
		if (Modifier.isAbstract(mod)) 
			buf.append("abstract "); 
		else if (Modifier.isStatic(mod)) 
			buf.append("static"); 
								
		System.out.printf("Modifiers:   %s\n\n",  buf.toString());
	}
}
