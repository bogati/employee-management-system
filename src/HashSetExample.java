import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class HashSetExample {
	public static void main(String[] args) {
		
		Set<String> employeeHash = new HashSet<>();
		
		long userId;
		long departmentId;
		String lastName;
		String firstName;
		int age;
		String position;
		int salary;
		String email;
		String phone;
		String address;
		
		long[] userIdArr = { 00001, 00004, 00042, 81481, 78162, 12863, 82632, 83614, 18736, 19236 };
		long[] departmentIdArr = { 00001, 00004, 00004, 00004, 00026, 00072, 00041, 00021, 00036, 00053 };
		String[] lastNameArr = { "Says", "Antoinette", "Skywalker", "Solo", "Polo", "Cortes", "Button", "Ketchum", "Bear", "Chicken" };
		String[] firstNameArr = { "Simon", "Marie", "Luke", "Hans", "Marco", "Hernan", "Benjamin", "Ash", "Pooh", "Fried" };
		int[] ageArr = { 44, 38, 34, 62, 22, 31, 19, 18, 28, 25 };
		String[] positionArr = { "CEO", "Manager", "Assistant Manager", "Java Developer", "Java Developer", "Java Developer", 
				"Java Developer", "Java Developer", "Java Developer", "Java Developer" };
		int[] salaryArr = { 1000, 500, 100, 50, 60, 50, 50, 50, 55, 50 };
		String[] emailArr = { "Simon", "Marie", "Luke", "Hans", "Marco", "Hernan", "Benjamin", "Ash", "Pooh", "Fried" };
		String[] phoneArr = { "Simon", "Marie", "Luke", "Hans", "Marco", "Hernan", "Benjamin", "Ash", "Pooh", "Fried" };
		String[] addressArr = { "Simon", "Marie", "Luke", "Hans", "Marco", "Hernan", "Benjamin", "Ash", "Pooh", "Fried" };		
		
		//made another array...
		//hashset has to be same type?
		
		for(int i = 0; i < ageArr.length; i++) {
			System.out.println("UserID: " + userIdArr[i] + "\tDepartmentID: " + departmentIdArr[i] + "\nName: " + 
			lastNameArr[i] + ", " + firstNameArr[i] + "\nAge: " + ageArr[i] + "\nPosition: " + positionArr[i] + "\tSalary: " + 
			salaryArr[i] + "\nPhone: " + phoneArr[i] + "\nEmail: " + emailArr[i] + "\nAddress: " + addressArr[i] +"\n"); 

		}
		
		/*		for(String l : lastNameArr) {
			employeeHash.add(l);
		}
		
		Set<Integer> intHash = new HashSet<>();
		for(int i = 0; i < 100000; i++) {
			intHash.add(i);
		System.out.println("Employee Name: " + (i));
		}
			
		Iterator<String> iterEmployee = employeeHash.iterator();
		
		while(iterEmployee.hasNext()) { 
			
			System.out.println(iterEmployee.next()); 
		
	}
*/	
	}			
}