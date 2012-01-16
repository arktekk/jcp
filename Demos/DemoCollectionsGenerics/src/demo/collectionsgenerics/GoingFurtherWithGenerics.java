package demo.collectionsgenerics;

public class GoingFurtherWithGenerics {

	public static void main(String[] args) {
		demoHierarchyArguments();
	}
	
	public static void demoHierarchyArguments() {
		Integer[] ints = new Integer[] {43, 42, 34};
		Statistics<Integer> ages = new Statistics<Integer>(ints);
		System.out.println("Average age: " + ages.calcAverage());
		
		Double[] doubles = new Double[] {1.60, 1.58, 1.56};
		Statistics<Double> heights = new Statistics<Double>(doubles);
		System.out.println("Average height: " + heights.calcAverage());
	}
}

class Statistics<T extends Number> {

	private T[] numbers;

	public Statistics(T[] nos) {
		numbers = nos;
	}
	
	public double calcAverage() {
		double total = 0.0;

	    for (T number: numbers) {
	    	total += number.doubleValue();
	    }
	    return total/numbers.length;
	}
}
