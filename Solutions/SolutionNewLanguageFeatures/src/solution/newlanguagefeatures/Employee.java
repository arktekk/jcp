package solution.newlanguagefeatures;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;

enum ContractType {
	FULL_TIME("full-time", 25),
	PART_TIME("part-time", 10), 
	CASUAL("casual", 0);
	
	// Data in each enum instance.
	private String textualRepresentation;
	private int daysLeave;

    // Constructor to initialize enum instance. Can't be used by client.
	ContractType(String textualRepresentation, int daysLeave) {
		this.textualRepresentation = textualRepresentation;
		this.daysLeave = daysLeave;
	}
	
	// Override some methods.
	@Override 
	public String toString() {
		return String.format("%s [%d days leave]", this.textualRepresentation, this.daysLeave);
	}
}

public class Employee {

	// Instance data.
	private String name;
	private double salary;
	private Date joined = new Date();
	private int id;
	
	// Skills for the employee.
	private String[] skills = new String[10];
	private int numSkills = 0;
	
	// Contract details.
	private ContractType contractType;
	
	
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
		this(name, salary, ContractType.FULL_TIME);	// Use constructor chaining.
	}
	
	public Employee(String name, double salary, ContractType contractType) {
		this.name = name;
		if (salary < minimumSalary) {
			this.salary = minimumSalary;
		} else {
			this.salary = salary;
		}
		this.contractType = contractType;
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
		// Give employee a bonus as specfied by parameter.
		salary *= 1 + percentBonus / 100;
	}
	
	public void payBonus(double percentBonus, double min, double max) {
		// Give employee a bonus as specfied by percentBonus, if salary is in range.
		if (salary >= min && salary <= max) {
			salary *= 1 + percentBonus / 100;
		}
	}

	public void addSkill(String skill) {
		if (numSkills == skills.length) {
			System.out.println("In addSkill(), cannot add skill " + skill);
		} else {
			skills[numSkills++] = skill;
			System.out.println("In addSkill(), added skill " + skill);
		}
	}

	public void displaySkills() {
		System.out.println("Skills:");
		for (int i = 0; i < numSkills; i++) {
			System.out.println("  " + skills[i]);
		}
	}
	
	public void displayJoiningDateInfo() {
		
		// Create a Calendar based on the employee's joining date.
		Calendar cal = new GregorianCalendar();
		cal.setTime(joined);
		
		// Get various pieces of date info.
		int dayOfMonth = cal.get(DAY_OF_MONTH);
		int month = cal.get(MONTH);
		int year = cal.get(YEAR);

		// Display dd mm yyyy
		System.out.printf("Date joined: %d %d %d\n", dayOfMonth, month+1, year);
	}
	
	
	// toString() method.
	@Override
	public String toString() {
		String str = String.format("[%d] %s earns %.2f, joined %s, contract type %s", id, name, salary, joined, contractType);
		return str;
	}
}
