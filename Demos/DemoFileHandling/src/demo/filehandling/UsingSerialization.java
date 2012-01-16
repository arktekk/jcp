package demo.filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UsingSerialization {

	public static void main(String[] args) {

		BankAccount acc1 = new BankAccount("John", 1);
		acc1.deposit(100);
		acc1.deposit(350);
		acc1.withdraw(75);
		System.out.println("Original object:     " + acc1);

		// Serialize the BankAccount object to a file.
		serializeBankAccount("Acc1.ser", acc1);

		// Now deserialize the file, to get back a BankAccount object.
		BankAccount deserializedAcc1 = deserializeBankAccount("Acc1.ser");

		// Display the deserialized BankAccount object.
		if (deserializedAcc1 == null) {
			System.out.println("Could not deserialize BankAccount object from Acc1.ser.");
		} else {
			System.out.println("Deserialized object: " + deserializedAcc1);
		}
	}


	public static void serializeBankAccount(String filename, BankAccount acc) {
	
		try {
			FileOutputStream fs = new FileOutputStream(filename);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(acc);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static BankAccount deserializeBankAccount(String filename) {
	
		BankAccount acc = null;
		try {
			FileInputStream fs = new FileInputStream(filename);
			ObjectInputStream is = new ObjectInputStream(fs);
			acc = (BankAccount) is.readObject();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}
}
