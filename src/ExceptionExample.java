import java.util.InputMismatchException;
import java.util.Scanner;

import com.cognixia.jump.corejava.exceptions.VotingAgeException;
import com.sun.tools.javac.launcher.Main;

public class ExceptionExample extends Exception {

	import java.util.InputMismatchException;
	import java.util.Scanner;

	
	public class ExceptionExample {
	public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);
			
			int dId;
			try {
				dId = addEmployee(sc);
				System.out.println("Adding " + dId + " to the department.");
				
			} catch(InputMismatchException e) {
				System.out.println("Not a valid entry.");
			}
			
			sc.close();
		}
		
		public static int addEmployee(Scanner sc) {
			
			System.out.println("What is the employee's ID?");
			
			int dId = sc.nextInt();
			
//			if(name < InputMismatchException) {
		//		throw new InputMismatchException(dId);
			
			
			return dId;
		}
		
		
		
}