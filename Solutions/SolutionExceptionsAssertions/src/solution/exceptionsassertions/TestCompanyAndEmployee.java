package solution.exceptionsassertions;

public class TestCompanyAndEmployee {

	public static void main(String[] args) {
		
		try {
			// Create a company.
			Company aCompany = new Company("Acme Inc.");
	
			// Add some employees.
			aCompany.hireEmployee(new Employee("1", "Amy", 1000));
			aCompany.hireEmployee(new Employee("2", "Ben", 2000));
			aCompany.hireEmployee(new Employee("3", "Cat", 3000));
	
			// Ensure we can get existing employees.
			Employee emp1 = aCompany.getEmployee("1");
			assert (emp1 != null) : "Could not get existing employee.";
			
			// Ensure we can't get non-existent employees.
			Employee noSuchEmp = aCompany.getEmployee("99");
			assert (noSuchEmp == null) : "Spuriously got non-existent employee.";
	
			// Ensure employees can retire.
			aCompany.retireEmployee("2");
			Employee retiredEmp = aCompany.getEmployee("2");
			assert (retiredEmp != null) : "Could not get retired employee.";
			assert (retiredEmp.isRetired()) : "Employee retirement not recorded properly.";
	
			// Ensure employees can be fired.
			aCompany.fireEmployee("3");
			Employee firedEmp = aCompany.getEmployee("3");
			assert (firedEmp == null) : "Spuriously got fired employee.";
	
			// Ensure working employees can have a pay rise.
			aCompany.giveEmployeePayRise("1", 100);
			assert (emp1.getSalary() == 1100) : "Payrise for working employee gave incorrect result.";
			
			// Ensure retired employees can not have a pay rise.
			aCompany.giveEmployeePayRise("2", 200);
			assert (retiredEmp.getSalary() == 2000) : "Payrise for retired employee gave incorrect result.";
		
		} catch (CompanyException ex) {
			System.out.printf("Company exception: %s [id %s].\n", ex.getMessage(), ex.getId());
			if (ex.getCause() != null) {
				System.out.printf("  Cause: %s.\n", ex.getCause());
			}
		}
	}
}
