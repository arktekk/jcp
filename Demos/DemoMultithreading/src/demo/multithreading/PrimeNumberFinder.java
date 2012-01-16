package demo.multithreading;

import java.util.*;

public class PrimeNumberFinder implements Runnable {

	private int from, to;
	private List<Integer> primes;

	
	// Constructor.
	public PrimeNumberFinder(int from, int to) {
		this.from = from;
		this.to = to;
		this.primes = new ArrayList<Integer>();
	}

	
	// This method will execute in a different thread.
	public void run() {

		for (int number = from; number <= to; number++) {

			// Artificial delay.
			try {
				Thread.sleep(5);
			} 
			catch (InterruptedException ex) {}


			// See if number is prime.
			if (isPrime(number)) {
				primes.add(number);
			}
		}
	}

	
	// Helper method.
	private boolean isPrime(int number) {
		
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	
	// Getters/setters.
	public int getFrom() {
		return from;
	}


	public void setFrom(int from) {
		this.from = from;
	}


	public int getTo() {
		return to;
	}


	public void setTo(int to) {
		this.to = to;
	}


	public List<Integer> getPrimes() {
		return primes;
	}


	public void setPrimes(List<Integer> primes) {
		this.primes = primes;
	}	
}