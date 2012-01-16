package demo.innerclasses;

public class Main {

	public static void main(String[] args) {
		demoInnerClasses();
		demoMethodLocalInnerClasses();
		demoAnonymousInnerClasses();
		demoStaticNestedClasses();
	}
	
	
	public static void demoInnerClasses() {
		
		// Error!
		// MyInner inner = new MyInner();

		// Create an instance of the outer class.
		MyOuterWithInnerClass myOuter = new MyOuterWithInnerClass("Hello", "World");
		
		// Use the outer object to create an associated inner object.
		MyOuterWithInnerClass.MyInner myInner1 = myOuter.createInner("I am myInner1");
		System.out.println(myInner1);
		
		// Manually create an inner object, associated with an outer object.
		MyOuterWithInnerClass.MyInner myInner2 = myOuter.new MyInner("I am myInner2");
		System.out.println(myInner2);
		
		// Create an outer object and an inner object "at the same time".
		MyOuterWithInnerClass.MyInner myInner3 = new MyOuterWithInnerClass("Adios", "Amigo").new MyInner("I am myInner3");
		System.out.println(myInner3);
	}


	public static void demoMethodLocalInnerClasses() {
		
		// Error!
		// MyOuterWithMethodLocalInnerClass.MyInner inner = new MyOuterWithMethodLocalInnerClass.MyInner();

		// Create an instance of the outer class.
		MyOuterWithMethodLocalInnerClass myOuter = new MyOuterWithMethodLocalInnerClass("Bonjour", "Le Monde");
		
		// Call a method that instantiates inner object.
		myOuter.hostInner("I am really local!");
	}
	
	
	public static void demoAnonymousInnerClasses() {
		
		// Create an instance of the outer class.
		MyOuterWithAnonymousInnerClass myOuter = new MyOuterWithAnonymousInnerClass("Bonjour", "Le Monde");
		
		// Call a method that instantiates inner object.
		myOuter.hostInner("I am anonymous!");
	}


	public static void demoStaticNestedClasses() {
		
		// Create an instance of the outer class.
		MyOuterWithStaticNestedClass myOuter = new MyOuterWithStaticNestedClass("Hei", "Alle");
		
		// Use the outer object to create an (unrelated) instance of static nested class.
		MyOuterWithStaticNestedClass.MyStaticNested myNested1 = myOuter.createNested("I am myNested1");
		System.out.println(myNested1);
		
		// Manually create an instance of the static nested class (no associated outer object).
		MyOuterWithStaticNestedClass.MyStaticNested myNested2 = new MyOuterWithStaticNestedClass.MyStaticNested("I am myNested2");
		System.out.println(myNested2);
	}
}

