package student.filehandling;

import java.util.Date;

public class Person extends Object {

	private String name;
	private String favteam;
	
	public Person(String name, String favteam) {
		super();
		this.name = name;
		this.favteam = favteam;
	}
	
	@Override
	public String toString() {
		return "Person [favteam=" + favteam + ", name=" + name
				+ "]";
	}

	public String getFavteam() {
		return favteam;
	}
	public void setFavteam(String favteam) {
		this.favteam = favteam;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
