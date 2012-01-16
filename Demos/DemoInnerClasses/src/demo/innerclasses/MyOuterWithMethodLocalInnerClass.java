package demo.innerclasses;

public class MyOuterWithMethodLocalInnerClass {
	
	private String outerField1;
	private String outerField2;
	
	public MyOuterWithMethodLocalInnerClass(String outerField1, String outerField2) {
		this.outerField1 = outerField1;
		this.outerField2 = outerField2;
	}
	
	
	public void hostInner(String str) {

		// This local variable CANNOT be accessed by method-local inner class.
		String localVariable = "Local1";

		// This final local variable CAN be accessed by method-local inner class.
		final String finalLocalVariable = "Local2";
		
		// Method-local inner class.
		class MyMethodLocalInner {
			
			private String innerField;
	
			public MyMethodLocalInner(String innerField) {
				this.innerField = innerField;
			}
	
			@Override
			public String toString() {
				return String.format("Outer fields: %s, %s. Outer (final) local variable: %s. Inner field: %s.", outerField1, 
						                                                                                         outerField2, 
						                                                                                         finalLocalVariable, 
						                                                                                         innerField);
			}
		} // End of inner class.

		// Create instance of method-local inner class.
		MyMethodLocalInner myInner = new MyMethodLocalInner(str);
		System.out.println(myInner);
	}
}
