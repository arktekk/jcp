package demo.innerclasses;

//Base class, will be subclassed by an anonymous inner class.
public abstract class MyBaseClass {

	private String field;
	
	public MyBaseClass(String field) {
		this.field = field;
	}
	
	public void doA() {
		System.out.println("Hello from MyBaseClass DoA().");
	}
	
	public void doB() {
		System.out.println("Hello from MyBaseClass DoB().");
	}
}