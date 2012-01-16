package solution.collectionsgenerics;

import java.util.*;

public class UsingCollections {

	public static void main(String[] args) {
		
		// Work with a list of Strings.
		manageFootballTeams();
		
		// Work with a LinkedList of Doubles.
		// manageSalaries();
		
		// Work with a TreeMap of Employees.
		// manageEmployees();
	}

	
	// Work with a list of Strings.
	public static void manageFootballTeams() {

		// Declare a list to hold football teams (i.e. Strings).
		List<String> teamList = new ArrayList<String>();
		
		// Miscellaneous helper variables.
		String team;
		int index;
		
		// Display menu options in a loop.
		int option = -1;
		do {
			
			try {
				System.out.println();
				System.out.println("---------------------------------------------------------");
				System.out.println("Options for managing a list of football teams (Strings)"  );
				System.out.println("---------------------------------------------------------");
				System.out.println("1. Append team");
				System.out.println("2. Add team at index");
				System.out.println("3. Set team at index");
				System.out.println("4. Remove team at index");
				System.out.println("5. Remove specified team");
				System.out.println("6. List all teams");
				System.out.println("7. Quit");
				
				option = Helper.getInt("\nEnter option => ");
				
				switch (option) {
				
					case 1:
						team = Helper.getString("Enter team: ");
						boolean added = teamList.add(team);
						if (added) {
							System.out.printf("Successfully appended %s.\n", team);
						} else {
							System.out.printf("Could not append %s.\n", team);
						}
						break;
						
					case 2:
						team  = Helper.getString("Enter team: ");
						index = Helper.getInt("Enter index: ");
						if (index <= teamList.size()) {
							teamList.add(index, team);
							System.out.printf("Successfully added %s at index %d.\n", team, index);
						} else {
							System.out.printf("Sorry, max index is %d.\n", teamList.size());
						}
						break;
						
					case 3:
						team  = Helper.getString("Enter team: ");
						index = Helper.getInt("Enter index: ");
						if (index < teamList.size()) {
							String origTeam = teamList.set(index, team);
							System.out.printf("Successfully set %s at index %d, replacing %s.\n", team, index, origTeam);
						} else {
							System.out.printf("Sorry, max index is %d.\n", teamList.size()-1);
						}
						break;
					
					case 4:
						index = Helper.getInt("Enter index: ");
						if (index < teamList.size()) {
							String removedTeam = teamList.remove(index);
							System.out.printf("Successfully removed %s at index %d.\n", removedTeam, index);
						} else {
							System.out.printf("Sorry, max index is %d.\n", teamList.size()-1);
						}
						break;
						
					case 5:
						team = Helper.getString("Enter team: ");
						boolean removed = teamList.remove(team);
						if (removed) {
							System.out.printf("Successfully removed %s.\n", team);
						} else {
							System.out.printf("Could not remove %s, not found.\n", team);
						}
						break;
						
					case 6:
						Helper.displayCollection(teamList);
						break;

					case 7:
						// This is a valid option, but there's nothing to do here.
						break;
						
					default:
						System.out.println("Invalid option selected.");
				}

			} catch (Exception ex) {
				System.out.printf("Exception occurred: %s.\n", ex.getMessage());
			}
					
		} while (option != 7);
	}


	// Work with a LinkedList of Doubles.
	public static void manageSalaries() {

		// Declare a LinkedList to hold salaries (i.e. Doubles).
		LinkedList<Double> salaryList = new LinkedList<Double>();
		
		// Miscellaneous helper variables.
		double salary;
		
		// Display menu options in a loop.
		int option = -1;
		do {
			
			try {
				System.out.println();
				System.out.println("---------------------------------------------------------");
				System.out.println("Options for managing a LinkedList of salaries (Doubles)  ");
				System.out.println("---------------------------------------------------------");
				System.out.println("1. Push salary");
				System.out.println("2. Pop salary");
				System.out.println("3. Add first ");
				System.out.println("4. Add last");
				System.out.println("5. Peek first and last");
				System.out.println("6. List all salaries");
				System.out.println("7. Quit");
				
				option = Helper.getInt("\nEnter option => ");
				
				switch (option) {
				
					case 1:
						salary = Helper.getDouble("Enter salary: ");
						salaryList.push(salary);
						System.out.printf("Successfully pushed %.2f.\n", salary);
						break;
						
					case 2:
						System.out.printf("Popped salary is %.2f.\n", salaryList.pop());
						break;
						
					case 3:
						salary = Helper.getDouble("Enter salary: ");
						salaryList.addFirst(salary);
						System.out.printf("Successfully added %.2f at start of list.\n", salary);
						break;
					
					case 4:
						salary = Helper.getDouble("Enter salary: ");
						salaryList.addLast(salary);
						System.out.printf("Successfully added %.2f at end of list.\n", salary);
						break;
						
					case 5:
						if (salaryList.size() != 0) {
							System.out.printf("Peek first gives: %.2f.\n", salaryList.peekFirst());
							System.out.printf("Peek last gives:  %.2f.\n", salaryList.peekLast());
						} else {
							System.out.printf("Sorry, there are no elements at the moment.\n");
						}
						break;
						
					case 6:
						Helper.displayCollection(salaryList);
						break;

					case 7:
						// This is a valid option, but there's nothing to do here.
						break;
						
					default:
						System.out.println("Invalid option selected.");
				}

			} catch (Exception ex) {
				System.out.printf("Exception occurred: %s.\n", ex.getMessage());
			}
					
		} while (option != 7);
	}


	// Work with a TreeMap of Employees.
	public static void manageEmployees() {

		// Declare a TreeMap to hold Employees (keyed by employee id).
		TreeMap<String, Employee> empMap = new TreeMap<String, Employee>(); 
		
		// Miscellaneous helper variables.
		Employee emp;
		String id;
		
		// Display menu options in a loop.
		int option = -1;
		do {
			
			try {
				System.out.println();
				System.out.println("---------------------------------------------------------");
				System.out.println("Options for managing a TreeMap of Employees (keyed by ID)");
				System.out.println("---------------------------------------------------------");
				System.out.println("1. Put employee");
				System.out.println("2. Remove employee for id");
				System.out.println("3. Is id present?");
				System.out.println("4. Is employee present?");
				System.out.println("5. Display first and last entries");
				System.out.println("6. Display all employees");
				System.out.println("7. Quit");
				
				option = Helper.getInt("\nEnter option => ");
				
				switch (option) {
				
					case 1:
						emp = Employee.createEmployee();
						Employee putEmp = empMap.put(emp.getId(), emp);
						System.out.printf("Successfully put %s.\n", putEmp);
						break;
						
					case 2:
						id  = Helper.getString("Enter id: ");
						emp = empMap.remove(id);
						if (emp != null) {
							System.out.printf("Successfully removed employee %s.\n", emp);
						} else {
							System.out.printf("Could not remove employee with id %s, id not found.\n", id);
						}
						break;
						
					case 3:
						id = Helper.getString("Enter id: ");
						boolean keyFound = empMap.containsKey(id);
						if (keyFound) {
							System.out.printf("id %s was found.\n", id);
						} else {
							System.out.printf("id %s was not found.\n", id);
						}
						break;

					case 4:
						emp = Employee.createEmployee();
						boolean empFound = empMap.containsValue(emp);
						if (empFound) {
							System.out.printf("Employee %s was found.\n", emp);
						} else {
							System.out.printf("Employee %s was not found.\n", emp);
						}
						break;

					case 5:
						if (empMap.size() != 0) {
							System.out.printf("First entry is: %s %s.\n", empMap.firstEntry().getKey(), empMap.firstEntry().getValue());
							System.out.printf("Last entry is:  %s %s.\n",  empMap.lastEntry().getKey(),  empMap.lastEntry().getValue());
						} else {
							System.out.printf("Sorry, there are no entries at the moment.\n");
						}
						break;

					case 6:
						Helper.displayCollection(empMap.values());
						break;

					case 7:
						// This is a valid option, but there's nothing to do here.
						break;
						
					default:
						System.out.println("Invalid option selected.");
				}

			} catch (Exception ex) {
				System.out.printf("Exception occurred: %s.\n", ex.getMessage());
			}
					
		} while (option != 7);
	}
}
