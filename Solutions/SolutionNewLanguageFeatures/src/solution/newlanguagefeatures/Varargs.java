package solution.newlanguagefeatures;

public class Varargs {

	public static void main(String[] args) {

		// Call sum() with exactly 2 parameters.
		double result1 = sum(100, 200);
		System.out.println("result1 is " + result1);

		// Call sum() with more than 2 parameters.
		double result2 = sum(100, 200, 300, 400);
		System.out.println("result2 is " + result2);

		// Call sum() with fewer than 2 parameters. This won't compile.
		//    double result3 = sum(100);
		//    System.out.println("result3 is " + result3);

		// Call sum() with 2 double parameters, plus some illegal parameter types. This won't compile.
		//    double result4 = sum(100, 200, "Hello", "world");
		//    System.out.println("result1 is " + result1);
	}
	
	private static double sum(double num1, double num2, double... additionalNums) {
		
		double total = num1 + num2;
		
		for(double n: additionalNums) {
			total += n;
		}
		return total;
	}
}
