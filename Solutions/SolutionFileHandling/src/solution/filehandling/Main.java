package solution.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

import solution.filehandling.persistence.CompanyPersister;

public class Main {

	public static void main(String[] args) {
		
		Company theCompany = null;
		
		// Uncomment one of the following statements, to read-in company data.
		// 	Company theCompany = loadCompany("Company.txt");
		// 	Company theCompany = deserializeCompany("Company.ser");

		if (theCompany == null) {
			theCompany = new Company("Acme Inc."); 
		}
		
		// Miscellaneous helper variables.
		String id;
		double amount;
		Employee emp;
		Collection<Employee> emps;
		
		// Display menu options in a loop.
		int option = -1;
		do {
			
			try {
				System.out.println();
				System.out.println("---------------------------------------------------------");
				System.out.println("1. Hire employee");
				System.out.println("2. Fire employee");
				System.out.println("3. Retire employee");
				System.out.println("4. Give employee a pay rise");
				System.out.println("5. Get an employee");
				System.out.println("6. Get all employees");
				System.out.println("7. Get working employees");
				System.out.println("8. Get retired employees");
				System.out.println("9. Quit");
				
				option = Helper.getInt("\nEnter option => ");
				
				switch (option) {
				
					case 1:
						emp = Employee.createEmployee();
						theCompany.hireEmployee(emp);
						System.out.printf("Hired %s.\n", emp);
						break;
						
					case 2:
						id  = Helper.getString("Enter id: ");
						theCompany.fireEmployee(id);
						System.out.printf("Fired employee with id %s.\n", id);
						break;
						
					case 3:
						id  = Helper.getString("Enter id: ");
						theCompany.retireEmployee(id);
						System.out.printf("Retired employee with id %s.\n", id);
						break;

					case 4:
						id  = Helper.getString("Enter id: ");
						amount = Helper.getDouble("Enter amount: ");
						theCompany.giveEmployeePayRise(id, amount);
						System.out.printf("Given %.2f pay rise to employee with id %s.\n", amount, id);
						break;

					case 5:
						id  = Helper.getString("Enter id: ");
						emp = theCompany.getEmployee(id);
						if (emp != null) {
							System.out.printf("Employee details: %s.\n", emp);
						} else {
							System.out.printf("No employee with id %s.\n", id);
						}
						break;

					case 6:
						emps = theCompany.getAllEmployees();
						System.out.println("All employees");
						Helper.displayCollection(emps);
						break;

					case 7:
						emps = theCompany.getWorkingEmployees();
						System.out.println("Working employees");
						Helper.displayCollection(emps);
						break;

					case 8:
						emps = theCompany.getRetiredEmployees();
						System.out.println("Retired employees");
						Helper.displayCollection(emps);
						break;

					case 9:
						// This is a valid option, but there's nothing to do here.
						break;
						
					default:
						System.out.println("Invalid option selected.");
				}

			} catch (CompanyException ex) {
				System.out.printf("Company exception: %s [id %s].\n", ex.getMessage(), ex.getId());
				if (ex.getCause() != null) {
					System.out.printf("  Cause: %s.\n", ex.getCause());
				}
			}
					
		} while (option != 9);

		// Uncomment one of the following statements, to write-out company data.
		// saveCompany("Company.txt", theCompany);
		// serializeCompany("Company.ser", theCompany);
	}


	public static Company loadCompany(String filename) {
		
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(filename));
			
			CompanyPersister persister = new CompanyPersister();
			Company company = persister.readFromTextFile(reader);
			
			System.out.println("Loaded company data for " + company.getCompanyName());
			return company;
		}
		catch (IOException ex) {
			System.err.println("loadCompany() exception: " + ex.getMessage());
			return null;
		}
		finally {
			if (reader != null) {
				try { reader.close(); } catch (IOException ex) {}
			}				
		}
	}


	public static void saveCompany(String filename, Company company) {
		
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(filename));
			
			CompanyPersister persister = new CompanyPersister();
			persister.writeToTextFile(writer, company);

			System.out.println("Saved company data for " + company.getCompanyName());
		}
		catch (IOException ex) {
			System.err.println("saveCompany() exception: " + ex.getMessage());
		}
		finally {
			if (writer != null) {
				try { writer.close(); } catch (IOException ex) {}
			}				
		}
	}


	public static Company deserializeCompany(String filename) {
		
		Company company = null;
		try {
			FileInputStream fs = new FileInputStream(filename);
			ObjectInputStream is = new ObjectInputStream(fs);
			company = (Company) is.readObject();
			is.close();
			System.out.println("Deserialized company data for " + company.getCompanyName());

		} catch (Exception ex) {
			System.err.println("deserializeCompany() exception: " + ex.getMessage());
		}
		return company;
	}

	
	public static void serializeCompany(String filename, Company company) {
		
		try {
			FileOutputStream fs = new FileOutputStream(filename);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(company);
			os.close();
			System.out.println("Serialized company data for " + company.getCompanyName());

		} catch (Exception ex) {
			System.err.println("serializeCompany() exception: " + ex.getMessage());
		}
	}
}
