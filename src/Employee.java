
public class Employee {
	
	private long userId;
	private long departmentId;
	private String lastName;
	private String firstName;
	private int age;
	private String position;
	private int salary;
	private String email;
	private String phone;
	private String address;
	
	public Employee(long userId, long departmentId, String lastName, String firstName, int age, String position,
			int salary, String email, String phone, String address) {
		super();
		this.userId = userId;
		this.departmentId = departmentId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
}	
