package solution.newjavaseclasses;

public class UsingStringBuilder {

	public static void main(String[] args) {
		
		StringBuilder sb1 = new StringBuilder(50);
		
		sb1.append("<person>");
		sb1.append("<name>Johan</name>");
		sb1.append("<age>21</age>");
		sb1.append("</person>");
		System.out.println(sb1);

		// Delete <age>21</age>
		sb1.delete(25, 38);
		System.out.println(sb1);
		
		// Delete the o and the h in Johan
		sb1.deleteCharAt(15);
		sb1.deleteCharAt(15);
		System.out.println(sb1);

		// Insert new text
		sb1.insert(24, "<country>UK</country>");
		sb1.insert(24, "<gender>M</gender>");
		System.out.println(sb1);

		// Replace some text
		sb1.replace(51, 53, "Wales");
		System.out.println(sb1);

		// Set a specific character
		sb1.setCharAt(32, 'F');
		System.out.println(sb1);

		String finishedString = sb1.toString();
		System.out.println("\nFinished string: " + finishedString);
	}
}
