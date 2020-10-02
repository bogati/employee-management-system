import java.util.InputMismatchException;
import java.util.Scanner;

public class Other {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int age;
		
		try {
			age = getAge(sc);
			System.out.println("You have entered " + age + ".");
		}
			catch (AgeException e) {
				System.out.println( "is not a valid age.");
			}	
			catch (InputMismatchException e) {
				System.out.println("Not a valid entry.");
			}
				
			sc.close();	
	
}
		
		public static int getAge(Scanner sc) throws AgeException {
			System.out.println("What is your age?");
			int age = sc.nextInt();
			if(age <= AgeException.MIN_AGE) {
				throw new AgeException(age);
			}
			return age;
		}
	}