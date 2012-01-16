package student.swingcontainerscomponents;

public class Contact {

	public enum Type {
		Business, Friend
	};
	
	private String name;
	private String country;
	private Type   type;
	private int    familiarity;
	
	public Contact(String name, String country, Type type, int familiarity) {
		this.name = name;
		this.country = country;
		this.type = type;
		this.familiarity = familiarity;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getFullDetails() {
		return String.format("%s, %s [%s, %d]", name, country, type, familiarity);
	}	
}
