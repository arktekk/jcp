package solution.filehandling;

import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable {

	// Instance variables.
	private String id;
	private String name;
	private double salary;
	private boolean retired = false;
	
	// Constructor.
	public Employee(String id, String name, double salary, boolean retired) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.retired = retired;
	}

	// Factory method, to create an Employee object directly using console I/O.
	public static Employee createEmployee() {
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Employee id? " );
		String id = scanner.next();
		
		System.out.print("Employee name: " );
		String name = scanner.next();
		
		System.out.print("Employee salary: " );
		double salary = scanner.nextDouble();
		
		return new Employee(id, name, salary, false);
	}
	
	// Getters.
	public String getId() {
		return id;
	}
	
	public String getName() {
		return id;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public boolean isRetired() {
		return retired;
	}
	
	// Retire the employee.
	public void retire() {
		retired = true;
	}
	
	// Give the employee a pay rise.
	public double payRise(double amount) {
		
		if (amount <= 0) {
			String message = String.format("Pay rise %.2f rejected, must be positive.", amount);
			throw new IllegalArgumentException(message);

		} else if (retired) {
			String message = String.format("Pay rise for %s rejected, employee is retired.", name);
			throw new IllegalStateException(message);

		} else {
			salary += amount;
			return salary;
		}
	}
	
	// Return a textual representation of employee's data.
	@Override
	public String toString() {

		if (retired) {
			return String.format("[%s] %s is retired", id, name);
		} else {
			return String.format("[%s] %s earns £%.2f", id, name, salary);
		}			
	}
}
