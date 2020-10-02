	import java.util.InputMismatchException;
	import java.util.Scanner;

	public class ExceptionInPractice {

		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			int age;
			
			try {
				age = getAge(sc);
				System.out.println("You have entered " + age + ".");
			}
				catch (AgeException e) {
					System.out.println(e.getMessage());
				}	
				catch (InputMismatchException e) {
					System.out.println("Not a valid entry.");
				}	
				sc.close();	
		
	}
			
			public static int getAge(Scanner sc) throws AgeException {
				System.out.println("What is the employee's age?");
				int age = sc.nextInt();
				if(age <= AgeException.MIN_AGE) {
					throw new AgeException(age);
				}
				if(age >= AgeException.MAX_AGE) {
					throw new AgeException(age);
				}
				return age;
			}
			
	
}
