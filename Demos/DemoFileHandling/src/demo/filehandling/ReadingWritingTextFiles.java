package demo.filehandling;

import java.io.*;
import java.util.*;

public class ReadingWritingTextFiles {

	private static final String CUSTOMERS_FILE_NAME = "Customers.txt";


	public static void main(String[] args) {
		demoWritingTextFiles();
		demoReadingTextFiles();
	}


	public static void demoWritingTextFiles() {
		
		// Create some Customer objects.
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1, "John Smith", "London", false));
		customers.add(new Customer(2, "Mary Evans", "Exeter", true));
		customers.add(new Customer(3, "Bill White", "Dundee", false));
		customers.add(new Customer(4, "Claire Fin", "Dublin", true));
		
		PrintWriter out = null;

		try {
			
			// Create a PrintWriter (overwrites file if it exists).
			out = new PrintWriter(new BufferedWriter(new FileWriter(CUSTOMERS_FILE_NAME)));
			
			// Loop through the collection of customers.
			for(Customer cust : customers) {
				
				// Output the properties for a customer on one line, separated by tabs.
				out.print(cust.getId() + "\t");
				out.print(cust.getName() + "\t");
				out.print(cust.getAddress() + "\t");
				out.print(cust.isPremiumCustomer());
				
				// Output a newline to indicate the end of this customer's data in the file.
				out.println();
			}
			System.out.printf("Successfully written text file %s.\n", CUSTOMERS_FILE_NAME);

		}
		catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			if (out != null) {
				out.close();
			}				
		}
	}


	public static void demoReadingTextFiles() {
		
		// Create a collection, ready to hold Customer objects created from file.
		List<Customer> customers = new ArrayList<Customer>();
		
		BufferedReader in = null;

		try {
			
			// Create a BufferedReader.
			in = new BufferedReader(new FileReader(CUSTOMERS_FILE_NAME));
			
			// Read all lines from file (each line holds data for one customer).
			String line;
			while ((line = in.readLine()) != null) {
				
				// Split the line at tab characters, to get at each piece of data separately.
				String[] columns = line.split("\t");

				int id = Integer.parseInt(columns[0]);
				String name = columns[1];
				String address = columns[2];
				boolean premiumCustomer = Boolean.parseBoolean(columns[3]);
				
				// Create a new Customer object from the data, and insert it into the collection.
				Customer cust = new Customer(id, name, address, premiumCustomer);
				customers.add(cust);
			}
		}
		catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			if (in != null) {
				try { in.close(); } catch (IOException ex) {}
			}				
		}
		
		System.out.println("\nCustomers read from text file:");
		for(Customer cust : customers) {
			System.out.printf("\t%d %s %s %b\n", cust.getId(), cust.getName(), cust.getAddress(), cust.isPremiumCustomer());
		}
	}


	static class Customer {
		
		private int id;
		private String name;
		private String address;
		private boolean premiumCustomer;
		
		public Customer(int id, String name, String address, boolean premiumCustomer) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
			this.premiumCustomer = premiumCustomer;
		}
		
		@Override
		public String toString() {
			return "Customer [address=" + address + ", id=" + id + ", name=" + name
					+ ", premiumCustomer=" + premiumCustomer + "]";
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public boolean isPremiumCustomer() {
			return premiumCustomer;
		}
		public void setPremiumCustomer(boolean premiumCustomer) {
			this.premiumCustomer = premiumCustomer;
		}
	}
}
