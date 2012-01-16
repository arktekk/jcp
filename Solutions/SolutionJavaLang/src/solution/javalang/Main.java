package solution.javalang;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Create a Scanner object to read from the "standard input" device.
		Scanner scanner = new Scanner(System.in);
		
		// Ask the user for details of first employee.
		System.out.print("Enter the name of the first employee: ");
		String name1 = scanner.nextLine();
		System.out.print("What is the salary of " + name1 + "? ");
		double salary1 = scanner.nextDouble();

		// Output details for first employee.
		System.out.println("Employee " + name1 + " earns " + salary1);
		
		
		// Ask the user for details of second employee.
		System.out.print("\nEnter the name of the second employee: ");
		String name2 = scanner.nextLine();
		System.out.print("What is the salary of " + name2 + "? ");
		double salary2 = scanner.nextDouble();

		// Output details for second employee.
		System.out.println("Employee " + name2 + " earns " + salary2);
		
		// Calculate and print the average salary.
		double averageSalary = (salary1 + salary2) / 2;
		System.out.println("\nAverage salary: " + averageSalary);
		
		
		// Optional extra bit: Use Math classes.
		double minSalary = Math.min(salary1, salary2);
		double maxSalary = Math.max(salary1, salary2);
		System.out.println("Minimum salary: " + minSalary + ", Maximum salary: " + maxSalary);
		

		// Optional extra bit: Use StringBuilder class.
		StringBuilder sb = new StringBuilder();
		sb.append("Employee 1: ");
		sb.append(name1);
		sb.append(" earns ");
		sb.append(salary1);
		System.out.println(sb.toString());
	}
}
