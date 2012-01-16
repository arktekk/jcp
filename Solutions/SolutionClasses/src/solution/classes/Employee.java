package solution.classes;

import java.util.Date;

public class Employee {

	// Instance data.
	private String name;
	private double salary;
	private Date joined = new Date();
	private int id;
	
	
	// Static data.
	private static double minimumSalary = 7000;
	private static int nextEmployeeID;
	

	// Initialization block, for common instance initialization.
	{
		id = nextEmployeeID++;
	}
	
	// Constructors. Note, no default constructor.
	public Employee(String name) {
		this(name, 7000);	// Use constructor chaining.
	}

	public Employee(String name, double salary) {
		this.name = name;
		if (salary < minimumSalary) {
			this.salary = minimumSalary;
		} else {
			this.salary = salary;
		}
	}
	
	
	// Getters and setters for instance data.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoined() {
		return joined;
	}
	public void setJoined(Date joined) {
		this.joined = joined;
	}

	
	// Getters and setters for static data.
	public static double getMinimumSalary() {
		return minimumSalary;
	}
	public static void setMinimumSalary(double min) {
		minimumSalary = min;
	}
	
	
	// Business methods.
	public void payRaise(double amount) {
		salary += amount;
	}
	
	public void payBonus() {
		// Give employee a 1% bonus.
		salary *= 1.01;
	}
	
	public void payBonus(double percentBonus) {
		// Give employee a bonus as specified by parameter.
		salary *= 1 + percentBonus / 100;
	}
	
	public void payBonus(double percentBonus, double min, double max) {
		// Give employee a bonus as specified by percentBonus, if salary is in range.
		if (salary >= min && salary <= max) {
			salary *= 1 + percentBonus / 100;
		}
	}

	
	// toString() method.
	@Override
	public String toString() {
		String str = String.format("[%d] %s earns %.2f, joined %s", id, name, salary, joined);
		return str;
	}
}
