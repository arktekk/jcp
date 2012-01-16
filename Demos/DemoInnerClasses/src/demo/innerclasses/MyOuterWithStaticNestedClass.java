package demo.innerclasses;

public class MyOuterWithStaticNestedClass {
	
	private String outerField1;
	private String outerField2;
	
	public MyOuterWithStaticNestedClass(String outerField1, String outerField2) {
		this.outerField1 = outerField1;
		this.outerField2 = outerField2;
	}
	
	public MyStaticNested createNested(String str) {
		return new MyStaticNested(str);
	}
	
	
	// Static nested class.
	// Just like a normal class, happens to be defined in a nested scope.
	public static class MyStaticNested {
		
		// Can have any members (instance and/or static).
		private String innerField;
		private static int count;

		public MyStaticNested(String innerField) {
			this.innerField = innerField;
			count++;
		}

		@Override
		public String toString() {
			// Can only access our own members. No access to outer members.			
			return String.format("Inner field: %s, count: %d.", innerField, count);
		}
	}
}
