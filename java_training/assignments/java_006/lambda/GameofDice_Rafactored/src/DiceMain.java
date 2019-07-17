import java.util.Scanner;

public class DiceMain {

	public static void main(String[] args) {
		Scanner round1 = new Scanner(System.in);
		//String quit = "Q";
		
		//start game
		System.out.println("Welcome to the dice throw challenge!");
		System.out.println("Do you feel lucky? Punk...Do ya");
		System.out.println("Press any key and ENTER to throw your die or press Q and ENTER if you're chicken...");
		String userRound1 = round1.nextLine();
		
		//play or quit
		if (userRound1.equalsIgnoreCase("q")) {
			System.out.println("See ya later alligator!");
			round1.close();
			System.exit(0);
		}
		else {
			GameMethods.playGame();
		}


	}

}
