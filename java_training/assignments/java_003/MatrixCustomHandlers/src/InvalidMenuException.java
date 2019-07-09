//custom exception if invalid menu option is entered
public class InvalidMenuException extends Exception{
	public InvalidMenuException() {
		System.out.println("\n\t\t\t\t\t\t   Invalid menu option");
		System.out.println("\t\t\t\t\t\t\tGoodbye!");
		System.exit(0);
	}
}
