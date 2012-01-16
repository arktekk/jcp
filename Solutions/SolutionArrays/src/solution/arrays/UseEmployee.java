package solution.arrays;

public class UseEmployee {

	public static void main(String[] args) {
		
		// Create employee.
		Employee emp1 = new Employee("Ben", 25000);		

		emp1.addSkill("Java");
		emp1.addSkill("UML");
		emp1.addSkill("C++");
		emp1.addSkill("C#");
		emp1.addSkill("Spring");
		emp1.addSkill("Hibernate");
		emp1.addSkill("SOA");
		emp1.addSkill("JSP");
		emp1.addSkill("Facelets");
		emp1.addSkill("Ruby");
		emp1.addSkill("Visual Basic");
		emp1.addSkill("Cobol");

		emp1.displaySkills();
	}
}
