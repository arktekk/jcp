package solution.filehandling.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

import solution.filehandling.Company;
import solution.filehandling.Employee;

public class CompanyPersister implements PersistableToTextFile<Company> {

	@Override
	public Company readFromTextFile(BufferedReader reader) throws IOException {

		String line = reader.readLine();
		if (line == null) {
			return null;
		}
		
		Company company = new Company(line);

		EmployeePersister empPersister = new EmployeePersister();
		Employee emp;
		while ((emp = empPersister.readFromTextFile(reader)) != null) {
			company.getEmployees().put(emp.getId(),emp);
		}

		return company;
	}

	@Override
	public void writeToTextFile(BufferedWriter writer, Company company) throws IOException {

		PrintWriter out = new PrintWriter(writer);
		
		// Output company name, on its own line.
		out.println(company.getCompanyName());
		
		// Output company employees, one per line.
		EmployeePersister empPersister = new EmployeePersister();
		for (Employee emp: company.getAllEmployees()) {
			empPersister.writeToTextFile(writer, emp);
		}	
	}
}
