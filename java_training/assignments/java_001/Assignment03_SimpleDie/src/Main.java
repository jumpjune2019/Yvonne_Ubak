import java.util.*;
//import java.lang.*;
public class Main {
	
	//class that plays the game
	static void Play() {
		String playAgain = "Y";
		
		int diceValue = RollDice.getFace(1, 6);		//throw dice
		Scanner uInput = new Scanner(System.in);
		
		System.out.println("You have rolled a " + diceValue);
		System.out.print("Play again? (Y or y) and Enter. Press any other key and Enter to Quit. ");
		String uResponse = uInput.nextLine();	//prompt user to answer;
		
		//play again or quit
		if (uResponse.equalsIgnoreCase(playAgain)) {
			Play();
		}
		else {
			uInput.close();
			System.out.println();
			System.out.println("GoodBye!");
			System.out.println("Exit...");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String quit = "Q";
		
		Scanner input = new Scanner(System.in);
		System.out.print("Press any key to throw a dice and press Enter (or Q and Enter to quit). ");
		String userR = input.nextLine();
		
		//play or quit
		if((userR.equalsIgnoreCase(quit))) {
			input.close();
			System.out.println();
			System.out.println("GoodBye!");
			System.out.println("Exit...");
			System.exit(0);
		}
		else {
			Play();
		}
		
	}

}
