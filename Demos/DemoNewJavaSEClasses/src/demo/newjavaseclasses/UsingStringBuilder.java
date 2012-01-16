package demo.newjavaseclasses;

public class UsingStringBuilder {

	public static void main(String[] args) {
		demoStringBuilder();
		demoStringBuffer();
	}
	
	
	public static void demoStringBuilder() {
		
		StringBuilder sb1 = new StringBuilder("Hello");
		
		sb1.append(" world");
		sb1.append('!');
		
		sb1.insert(5,  " Andy and the rest of the");
		sb1.insert(10, 43);
		
		String str1 = sb1.toString();
		System.out.println(str1);
		
		StringBuilder sb2 = sb1;
		sb2.replace(6, 9, "Fred");
		sb2.reverse();
		
		String str2 = sb2.toString();
		System.out.println(str2);
	}


	// Just for old time's sake, here's the same code using StringBuffer.
	public static void demoStringBuffer() {
		
		StringBuffer sb1 = new StringBuffer("Hello");
		
		sb1.append(" world");
		sb1.append('!');
		
		sb1.insert(5,  " Andy and the rest of the");
		sb1.insert(10, 43);
		
		String str1 = sb1.toString();
		System.out.println(str1);
		
		StringBuffer sb2 = sb1;
		sb2.replace(6, 9, "Fred");
		sb2.reverse();
		
		String str2 = sb2.toString();
		System.out.println(str2);
	}
}
