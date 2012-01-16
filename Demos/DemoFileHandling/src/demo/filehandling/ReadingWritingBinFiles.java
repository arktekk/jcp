package demo.filehandling;

import java.io.*;
import java.util.*;

public class ReadingWritingBinFiles {

	private static final String CUSTOMERS_FILE_NAME = "Customers.bin";


	public static void main(String[] args) {
		demoWritingBinFiles();
		demoReadingBinFiles();
	}


	public static void demoWritingBinFiles() {
		
		// Create some Customer objects.
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1, "John Smith", "London", false));
		customers.add(new Customer(2, "Mary Evans", "Exeter", true));
		customers.add(new Customer(3, "Bill White", "Dundee", false));
		customers.add(new Customer(4, "Claire Fin", "Dublin", true));
		
		DataOutputStream out = null;

		try {
			
			// Create a DataOutputStream (overwrites file if it exists).
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(CUSTOMERS_FILE_NAME)));
			
			// First, output the number of records (so we know how many to read in later).
			out.writeInt(customers.size());
			
			// Loop through the collection of customers.
			for(Customer cust : customers) {
				
				// Output the properties for a customer as binary data.
				out.writeInt(cust.getId());
				out.writeUTF(cust.getName());
				out.writeUTF(cust.getAddress());
				out.writeBoolean(cust.isPremiumCustomer());
			}
			System.out.printf("Successfully written binary file %s.\n", CUSTOMERS_FILE_NAME);

		}
		catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			if (out != null) {
				try { out.close(); } catch(IOException ex) {}
			}				
		}
	}


	public static void demoReadingBinFiles() {
		
		// Create a collection, ready to hold Customer objects created from file.
		List<Customer> customers = new ArrayList<Customer>();
		
		DataInputStream in = null;

		try {
			
			// Create a DataInputStream.
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(CUSTOMERS_FILE_NAME)));
			
			// Read data into Customer objects, and add each one to the collection.
			for (int recsRemaining = in.readInt(); recsRemaining > 0; recsRemaining--) {
				
				int id = in.readInt();
				String name = in.readUTF();
				String address = in.readUTF();
				boolean premiumCustomer = in.readBoolean();
				
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
		
		System.out.println("\nCustomers read from binary file:");
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


