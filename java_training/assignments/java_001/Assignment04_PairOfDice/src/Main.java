import java.util.*;
//import java.lang.*;
public class Main {
	
	//class that plays the game
	static void Play() {
		String playAgain = "Y";
		Scanner uInput = new Scanner(System.in);
		
		//throw die
		int dice1 = RollDice.getFace(1, 6);		
		int dice2 = RollDice.getFace(1, 6);		
		
		System.out.println("You have rolled the following: ");
		System.out.println("First Dice: "+dice1);
		System.out.println("Second Dice: "+dice2);
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
		System.out.print("Press any key to throw a pair of die and press Enter (or Q and Enter to quit). ");
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
