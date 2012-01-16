package demo.innerclasses;

public class MyOuterWithInnerClass {
	
	private String outerField1;
	private String outerField2;
	
	public MyOuterWithInnerClass(String outerField1, String outerField2) {
		this.outerField1 = outerField1;
		this.outerField2 = outerField2;
	}
	
	public MyInner createInner(String str) {
		return new MyInner(str);
	}
	
	
	// Inner class.
	public class MyInner {
		
		private String innerField;

		public MyInner(String innerField) {
			this.innerField = innerField;
		}

		@Override
		public String toString() {
			// Long-hand:
			return String.format("Outer fields: %s, %s. Inner field: %s.", MyOuterWithInnerClass.this.outerField1,
					                                                         MyOuterWithInnerClass.this.outerField2, 
					                                                         this.innerField);
			
			// Short-hand:
			// return String.format("Outer fields: %s, %s. Inner field: %s.", outerField1, outerField2, innerField);
		}
	}
}
