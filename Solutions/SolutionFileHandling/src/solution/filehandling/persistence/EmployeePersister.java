package solution.filehandling.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

import solution.filehandling.Employee;

public class EmployeePersister implements PersistableToTextFile<Employee> {

	@Override
	public Employee readFromTextFile(BufferedReader reader) throws IOException {

		String line = reader.readLine();
		if (line == null) {
			// No Employee data read from file.
			return null;
		}
		
		// Split the line at tab characters, to get at each piece of Employee data separately.
		String[] columns = line.split("\t");

		// Create an Employee object, using data from file.
		return new Employee(columns[0], 
				            columns[1], 
				            Double.parseDouble(columns[2]),
				            Boolean.parseBoolean(columns[3]));
	}

	@Override
	public void writeToTextFile(BufferedWriter writer, Employee emp) throws IOException {

		PrintWriter out = new PrintWriter(writer);
			
		// Output the Employee's fields on one line, separated by tabs.
		out.print(emp.getId() + "\t");
		out.print(emp.getName() + "\t");
		out.print(emp.getSalary() + "\t");
		out.print(emp.isRetired());
		
		// Output a newline to indicate the end of this Employee's data in the file.
		out.println();
	}
}
