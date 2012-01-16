package demo.reflection;

import java.util.Date;

public class DemoClassInfo {

	public static void main(String[] args) {

		String name = "John";
		Date now = new Date();
		int num = 42;

		// Get a Class<?> via getClass(), can also use Class.forName() or ClassName.class
		displayClassInfo(name.getClass());
		displayClassInfo(now.getClass());
		displayClassInfo(new Integer(num).getClass());
		displayClassInfo(args.getClass());
	}
	
	private static void displayClassInfo(Class<?> classInfo) {
		System.out.printf("Class name:  %s\n",   classInfo.getName());
		System.out.printf("Simple name: %s\n\n", classInfo.getSimpleName());
	}
}
