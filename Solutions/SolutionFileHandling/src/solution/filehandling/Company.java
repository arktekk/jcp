package solution.filehandling;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

public class Company implements Serializable {

	// Instance variables.
	private String companyName;
	private TreeMap<String, Employee> employees = new TreeMap<String, Employee>();
	
	
	// Constructor.
	public Company(String companyName) {
		this.companyName = companyName;
	}
	

	// Getters.
	public String getCompanyName() {
		return companyName;
	}
	
	public TreeMap<String, Employee> getEmployees() {
		return employees;
	}

	
	// Hire employee (i.e. add to company).
	public void hireEmployee(Employee emp) throws CompanyException {
		
		String id = emp.getId();
		
		if (employees.containsKey(id)) {
			throw new CompanyException("Cannot add employee, duplicate id.", id);
		} else {
			employees.put(id, emp);
		}
	}


	// Fire employee (i.e. remove employee from company).
	public void fireEmployee(String id) throws CompanyException {
		
		if (!employees.containsKey(id)) {
			throw new CompanyException("Cannot remove employee, id not recognized.", id);
		} else {
			employees.remove(id);
		}
	}


	// Retire employee (but keep their info).
	public void retireEmployee(String id) throws CompanyException {
		
		Employee emp = employees.get(id);
		
		if (emp == null){
			throw new CompanyException("Cannot retire employee, id not recognized.", id);
		} else {
			emp.retire();
		}
	}


	// Give employee a pay rise.
	public void giveEmployeePayRise(String id, double amount) throws CompanyException {
		
		Employee emp = employees.get(id);
		
		if (emp == null){
			throw new CompanyException("Cannot give employee a pay rise, id not recognized.", id);
		
		} else {
			
			try {
				emp.payRise(amount);
		
			} catch (IllegalArgumentException ex) {
				throw new CompanyException("Cannot give employee a payrise.", ex, id);
			} catch (IllegalStateException ex) {
				throw new CompanyException("Cannot give employee a payrise.", ex, id);
			}
		}
	}


	// Get an employee. Returns null if employee not found.
	public Employee getEmployee(String id) {
		return employees.get(id);
	}

	
	// Get all employees (including retired employees).
	public Collection<Employee> getAllEmployees() {
		return employees.values();
	}

	
	// Get working employees.
	public Collection<Employee> getWorkingEmployees() {
		
		Collection<Employee> workingEmployees = new ArrayList<Employee>();
		
		for (Employee emp: employees.values()) {
			if (!emp.isRetired()) {
				workingEmployees.add(emp);
			}
		}
		return workingEmployees;
	}

	
	// Get retired employees.
	public Collection<Employee> getRetiredEmployees() {
		
		Collection<Employee> retiredEmployees = new ArrayList<Employee>();
		
		for (Employee emp: employees.values()) {
			if (emp.isRetired()) {
				retiredEmployees.add(emp);
			}
		}
		return retiredEmployees;
	}

	
	// Return a textual representation of company's data.
	@Override
	public String toString() {
		return String.format("Company [%s] has/had %d registered employee.", companyName, employees.size());
	}
}
