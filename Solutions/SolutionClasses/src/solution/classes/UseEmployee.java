package solution.classes;

public class UseEmployee {

	public static void main(String[] args) {
		
		doTest1();
		
		doTest2();
		
		doTest3();
		
		doTest4();
	}

	
	private static void doTest1() {
	
		System.out.println("In doTest1()...");

		/* For this to work, you must define a default constructor in the Employee class.
		Employee emp = new Employee();
		
		emp.setName("Chris Smith");
		emp.setSalary(20000);
		emp.setJoined(new Date());

		emp.payRaise(500);
		emp.setName("Chris Jones");

		System.out.println("Employee details: " + emp1);
		*/
	}


	private static void doTest2() {
		
		System.out.println("\nIn doTest2()...");

		Employee emp1 = new Employee("John", 10000);
		System.out.println("emp1 details: " + emp1);

		Employee emp2 = new Employee("Jane", 20000);
		System.out.println("emp2 details: " + emp2);
	}


	private static void doTest3() {
		
		System.out.println("\nIn doTest3()...");

		// Increase minimum salary (for all new employees) by 1000, to 8000 now. 
		Employee.setMinimumSalary(Employee.getMinimumSalary() + 1000);
		
		// Create an employee with a salary below the minimum (should set salary to the minimum, 8000).
		Employee emp1 = new Employee("John", 5000);		
		System.out.println("emp1 details: " + emp1);

		// Create an employee with a salary above the minimum (should honour the specified salary).
		Employee emp2 = new Employee("Jane", 10000);
		System.out.println("emp2 details: " + emp2);
	}


	private static void doTest4() {
		
		System.out.println("\nIn doTest4()...");

		// Create employee, and give a default bonus (1%).
		Employee emp1 = new Employee("Siv", 9000);		
		emp1.payBonus();
		System.out.println("emp1 details after bonus: " + emp1);

		// Create employee, and give a 10% bonus.
		Employee emp2 = new Employee("Joe", 9000);		
		emp2.payBonus(10);
		System.out.println("emp2 details after bonus: " + emp2);

		// Create employee, and give a 10% bonus if salary between 8000 and 20000.
		Employee emp3 = new Employee("Adi", 9000);		
		emp3.payBonus(10, 8000, 20000);
		System.out.println("emp3 details after bonus: " + emp3);

		// Create employee, and give a 10% bonus if salary between 10000 and 20000.
		Employee emp4 = new Employee("Ole", 9000);		
		emp4.payBonus(10, 10000, 20000);
		System.out.println("emp4 details after bonus: " + emp4);
	}
}
