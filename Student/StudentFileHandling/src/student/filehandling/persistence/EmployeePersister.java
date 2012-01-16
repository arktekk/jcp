package student.filehandling.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

import student.filehandling.Company;
import student.filehandling.Employee;

public class EmployeePersister implements PersistableToTextFile<Employee> {

	@Override
	public Employee readFromTextFile(BufferedReader reader) throws IOException {

		Employee employee = null;
		
		// TODO: Implement this method, to read an employee from the BufferedReader...

		// 1. Read a line of text from the file, which will be an employee.
		//    If there's no line of text, return immediately.

		// 2. Split the line at tab characters, to get at each piece of Employee data separately.

		// 3. Create an Employee object, using data from file.

		
		// Return the Employee object.
		return employee;
	}

	@Override
	public void writeToTextFile(BufferedWriter writer, Employee emp) throws IOException {

		// TODO: Implement this method, to write an employee to the BufferedWriter...

		// 1. Write the Employee's fields on one line, separated by tabs.

		// 2. Write a newline to indicate the end of this Employee's data in the file.

	}
}
