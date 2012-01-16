package student.filehandling.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

import student.filehandling.Company;
import student.filehandling.Employee;

public class CompanyPersister implements PersistableToTextFile<Company> {

	@Override
	public Company readFromTextFile(BufferedReader reader) throws IOException {

		Company company = null;
		
		// TODO: Implement this method, to read a company (and all its employees) from the BufferedReader...

		// 1. Read the first line of text from the file, which will be the company name.
		//    If there's no line of text, return immediately.

		// 2. Create a new Company object, using the company name you just read in.
		
		// 3. Create an EmployeePersister object, which you'll use to read employees.
		
		// 4. Set up a loop to read each employee from the text file,
		//    using the EmployeePersister to read one employee at a time.
		//    Add each employee to the company.


		// Return the Company object.
		return company;
	}

	@Override
	public void writeToTextFile(BufferedWriter writer, Company company) throws IOException {

		// TODO: Implement this method, to write a company (and all its employees) to the BufferedWriter...

		// 1. Write the company name, on its own line.

		// 2. Create an EmployeePersister object, which you'll use to write employees.
		
		// 3. Set up a loop to write employees (one per line),
		//    using the EmployeePersister to write one employee at a time.
	}
}
