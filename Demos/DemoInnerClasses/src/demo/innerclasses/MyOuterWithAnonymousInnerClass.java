package demo.innerclasses;

public class MyOuterWithAnonymousInnerClass {
	
	private String outerField1;
	private String outerField2;
	
	public MyOuterWithAnonymousInnerClass(String outerField1, String outerField2) {
		this.outerField1 = outerField1;
		this.outerField2 = outerField2;
	}
	
	
	public void hostInner(String str) {
		
		// Create an instance of an anonymous class, which subclasses MyBaseClass.
		MyBaseClass var1 = new MyBaseClass(str) {
			
			// Override method(s), if we like.
			public void doA() {
				System.out.println("Hello from anonymous subclass's DoA().");
			}
		};
		var1.doA();
		var1.doB();
		
		// Create an instance of an anonymous class, which implements MyInterfacce.
		MyInterface var2 = new MyInterface() {
			
			// Must implement methods.
			public void doC() {
				System.out.println("Hello from anonymous subclass's DoC().");
			}
			public void doD() {
				System.out.println("Hello from anonymous subclass's DoD().");
			}		
		};
		var2.doC();
		var2.doD();
	}
}
