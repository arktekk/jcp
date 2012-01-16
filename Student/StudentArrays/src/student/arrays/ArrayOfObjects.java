package student.arrays;

//Product class, just used in this file.
class Product {

	private String name;
	private double unitPrice;
	
	public Product(String name, double unitPrice) {
		this.name = name;
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return String.format("%s %.2f", name, unitPrice);
	}
}

public class ArrayOfObjects {

	public static void main(String[] args) {

		// Write code here, to create and use an array of Product objects.
		
		
	}
}