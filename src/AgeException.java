
public class AgeException extends Exception {
			
	private static final long serialVersionUID = 8484621947746217499L;

	
			public final static int MIN_AGE = 0;
			public final static int MAX_AGE = 100;
			int age;
			
			AgeException(int age) {
				super(age + " is an invalid entry.");
				this.age = age;
			}
		
			
}