package solution.newlanguagefeatures;

public class UseEmployee {

	public static void main(String[] args) {
		
		Employee emp = new Employee("Claire", 25000, ContractType.FULL_TIME);
		
		System.out.println(emp);
		
		emp.displayJoiningDateInfo();
	}
}
