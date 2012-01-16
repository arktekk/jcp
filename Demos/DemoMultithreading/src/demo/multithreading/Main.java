package demo.multithreading;

import java.util.Scanner;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
	
		System.out.print("Enter 'from': ");
		int from = scanner.nextInt();
		
		System.out.print("Enter 'to': ");
		int to = scanner.nextInt();
		
		PrimeNumberFinder finder = new PrimeNumberFinder(from, to); 
		Thread backgroundThread = new Thread(finder);
		backgroundThread.start();
		
		// Do some work on the main thread, while we're waiting.
		for (int i = 0; i < 5; i++) {
			System.out.println("Ho hum. It's " + new Date());
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex) {}
		}
		
		System.out.println("I've done all my jobs now. So I'm just going to sit here, waiting for the background thread to finish....\n");
		
		try {
			backgroundThread.join();
		}
		catch (InterruptedException ex) {}

		// Get the results from the background thread.
		List<Integer> primes = finder.getPrimes();
		System.out.println("Prime numbers: " + primes);
		
	}

}
