package demo.interfaces;

public class UseCalculator {

	public static void main(String[] args) {

		Calculator calc = new Calculator();

		calc.freeze();
		doSomeCalculations(calc);
		calc.logBrief();

		calc.unfreeze();
		doSomeCalculations(calc);
		calc.logVerbose();
		
		demoCrossCasting(calc);
	}

	
	public static void doSomeCalculations(Calculator calc) {
		calc.add(100, 200);
		calc.subtract(50, 22);
		calc.multiply(6, 7);
		calc.divide(54, 7);
	}


	public static void demoCrossCasting(Loggable obj) {
	
		if (obj instanceof Freezable) {
			Freezable temp = (Freezable) obj;
			temp.freeze();
			// ...
			temp.unfreeze();
		}
	}
}
