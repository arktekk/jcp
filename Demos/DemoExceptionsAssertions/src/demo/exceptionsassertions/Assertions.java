package demo.exceptionsassertions;

public class Assertions {

	public static void main(String[] args) {
		testWithoutAsserts();
		testWithAsserts();
	}

	private static void testWithoutAsserts() {
		try {
			int tz1 = getTimeZoneWithoutAsserts(60);
			if (tz1 != 4) {
				System.out.println("Invalid timezone result: " + tz1);
			}

			int tz2 = getTimeZoneWithoutAsserts(200);
			
		} catch (IllegalArgumentException ex) {
			System.out.println(ex);
		}
	}
	
	private static void testWithAsserts() {
		int tz1 = getTimeZoneWithAsserts(60);
		assert tz1 == 4 : "Invalid timezone result: " + tz1;

		int tz2 = getTimeZoneWithAsserts(200);
	}

	private static int getTimeZoneWithoutAsserts(int longitude) {
		if (longitude < -180 || longitude >= 180) {
			throw new IllegalArgumentException("longitude " + longitude + " out of range");
		}
		return longitude / 15;
	}

	
	private static int getTimeZoneWithAsserts(int longitude) {
		assert longitude >= -180 && longitude < 180 : "longitude " + longitude + " out of range";
		return longitude / 15;
	}

}
