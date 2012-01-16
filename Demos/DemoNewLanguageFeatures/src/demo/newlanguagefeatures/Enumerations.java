package demo.newlanguagefeatures;

public class Enumerations {

	public static void main(String[] args) {
		testSimpleEnum();
		testComplexEnum();
	}
	
	private static void testSimpleEnum() {
		// Create and use USstate enum variable.
		Direction southPole = Direction.SOUTH;
		System.out.println("southPole string:  " + southPole.toString());
		System.out.println("southPole ordinal: " + southPole.ordinal());
	}

	private static void testComplexEnum() {
		// Create and use USstate enum variable.
		USstate favouriteState = USstate.CA;
		System.out.println("favouriteState string:     " + favouriteState.toString());
		System.out.println("favouriteState name:       " + favouriteState.name());
		System.out.println("favouriteState ordinal:    " + favouriteState.ordinal());
	
		// Call custom methods on enum.
		favouriteState.setCapitalCity("San Diego");   // Rarely need to do this!
		System.out.println("favouriteState state name: " + favouriteState.getStateName());
		System.out.println("favouriteState capital:    " + favouriteState.getCapitalCity());

		if (favouriteState.isNewEnglandState()) {
			System.out.println("It's a New England state.");
		}
		else {
			System.out.println("It's NOT a New England state.");
		}
	}
}

class DirectionAsClass {
	public static final int NORTH = 0;
	public static final int SOUTH = 1;
	public static final int EAST  = 2;
	public static final int WEST  = 3;
}

enum Direction {
	NORTH,
	SOUTH, 
	EAST, 
	WEST
}

enum USstate {
	
	// Enum constants.
    AL("Alabama", "Montgomery"),
    AK("Alaska", "Juneau"),
    AZ("Arizona", "Phoenix"),
    AR("Arkansas", "Little Rock"),
    CA("California", "Sacramento"),
    CO("Colorado", "Denver"),
    CT("Connecticut", "Hartford"),
    DE("Delaware", "Dover"),
    FL("Florida", "Tallahassee"),
    GA("Georgia", "Atlanta"),
    HI("Hawaii", "Honolulu"),
    ID("Idaho", "Boise"),
    IL("Illinois", "Springfield"),
    IN("Indiana", "Indianapolis"),
    IA("Iowa", "Des Moines"),
    KS("Kansas", "Topeka"),
    KY("Kentucky", "Frankfort"),
    LA("Louisiana", "Baton Rouge"),
    ME("Maine", "Augusta"),
    MD("Maryland", "Annapolis"),
    MA("Massachusetts", "Boston"),
    MI("Michigan", "Lansing"),
    MN("Minnesota", "St. Paul"),
    MS("Mississippi", "Jackson"),
    MO("Missouri", "Jefferson City"),
    MT("Montana", "Helena"),
    NE("Nebraska", "Lincoln"),
    NV("Nevada", "Carson City"),
    NH("New Hampshire", "Concord"),
    NJ("New Jersey", "Trenton"),
    NM("New Mexico", "SantaFe"),
    NY("New York", "Albany"),
    NC("North Carolina", "Raleigh North"),
    ND("North Dakota", "Bismarck North"),
    OH("Ohio", "Columbus"),
    OK("Oklahoma", "Nashoma City"),
    OR("Oregon", "Salem"),
    PA("Pennsylvania", "Harrisburg"),
    RI("Rhode Island", "Providence"),
    SC("South Carolina", "Columbia"),
    SD("South Dakota", "Pierre"),
    TN("Tennessee", "Nashville"),
    TX("Texas", "Austin"),
    UT("Utah", "Salt Lake City"),
    VT("Vermont", "Montpelier"),
    VA("Virginia", "Richmond"),
    WA("Washington", "Olympia"),
    WV("West Virginia", "Charleston"),
    WI("Wisconsin", "Madison"),
    WY("Wyoming", "Cheyenne");
	
	// Data in each enum instance.
	private String stateName;
	private String capitalCity;

    // Constructor to initialize enum instance. Can't be used by client.
	USstate(String s, String c) {
		stateName   = s;
		capitalCity = c;
	}
	
	// Methods for use by client code.
	final public String getStateName() {
		return stateName;
	}
	
	final public String getCapitalCity() {
		return capitalCity;
	}
	
	final public void setCapitalCity(String c) {
		capitalCity = c;
	}

	// Override some methods.
	@Override 
	public String toString() {
		return "[" + super.toString() + "] "  
		           + this.stateName   + ", "
		           + this.capitalCity;
	}

	// Additional methods, if appropriate. This might be incorrect...
    public boolean isNewEnglandState() {
    	return (this == ME ||
    		    this == MA ||
    		    this == NH ||
    		    this == VT);
    }
}