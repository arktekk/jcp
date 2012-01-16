package solution.exceptionsassertions;

import java.util.Scanner;

public class Employee {

	// Instance variables.
	private String id;
	private String name;
	private double salary;
	private boolean retired = false;
	
	// Static Scanner, for simple console I/O.
	private static Scanner scanner = new Scanner(System.in);

	// Constructor.
	public Employee(String id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	// Factory method, to create an Employee object directly using console I/O.
	public static Employee createEmployee() {
	
		System.out.print("Employee id? " );
		String id = scanner.next();
		
		System.out.print("Employee name: " );
		String name = scanner.next();
		
		System.out.print("Employee salary: " );
		double salary = scanner.nextDouble();
		
		return new Employee(id, name, salary);
	}
	
	// Get the employee's id.
	public String getId() {
		return id;
	}
	
	// Get the employee's salary.
	public double getSalary() {
		return salary;
	}
	
	// Get the employee's retirement status.
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
