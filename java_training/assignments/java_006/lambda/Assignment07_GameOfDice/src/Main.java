import java.util.*;
public class Main {
	
	private static void playOrQuit(String input, String q) {
		//play again or quit
		if(input.equalsIgnoreCase(q)) {
			System.out.println("Thanks for being a sport! Later!");
			System.exit(0);
		}
		else {
			playGame();
		}
	}
	
	//user decides to play
	static void playGame() {
		RollDice throwDie = new RollDice();
		DiceMatrix label = new DiceMatrix();
		int userSum;
		int cpuSum;
		String quitter = "Q";
		Scanner userRound2 = new Scanner(System.in);
		
		System.out.println("Rolling the Dice!");
		int userDice1 = throwDie.getFace(1, 6);		//user throw dice 1
		int userDice2 = throwDie.getFace(1, 6);		//user throw dice 2
		int cpuDice1 = throwDie.getFace(1, 6);		//computer throw dice 1
		int cpuDice2 = throwDie.getFace(1, 6);		//computer throw dice 2
		
		userSum = userDice1 + userDice2;		//user total
		cpuSum = cpuDice1 + cpuDice2;			//computer total
		
		System.out.println("You have rolled a "+ userDice1 + " and " + userDice2 + " > the '" + label.dieLabels[userDice1-1][userDice2-1] + "'");
		System.out.println("I have rolled a "+ cpuDice1 + " and " + cpuDice2 + " > the '" + label.dieLabels[cpuDice1-1][cpuDice2-1] + "'");
		
		//user wins
		if(userSum > cpuSum) {
			System.out.println("You win!!");
			System.out.println("Did you cheat?? Gimme another try, c'mon! Press any key and ENTER to throw your dice or press 'Q' and ENTER to quit!");
			String userR2 = userRound2.nextLine();
			
			//play again or quit
			playOrQuit(userR2, quitter);
		}
		//computer wins
		else if (cpuSum > userSum) {
			System.out.println("I win!!");
			System.out.println("Wanna try again? Press any key and ENTER to throw your dice or press 'Q' and ENTER to quit!");
			String userR2 = userRound2.nextLine();
			
			//play again or quit
			playOrQuit(userR2, quitter);
		}
		//tie
		else if(cpuSum == userSum) {
			//user has doubles
			if((userDice1 == userDice2) & (cpuDice1 != cpuDice2)) {
				System.out.println("Damn! You win on a Double!  What Luck!");
				System.out.println("Did you cheat?? Gimme another try, c'mon! Press any key and ENTER to throw your dice or press 'Q' and ENTER to quit!");
				String userR2 = userRound2.nextLine();
				
				//play again or quit
				playOrQuit(userR2, quitter);
			}
			//computer has doubles
			else if((userDice1 != userDice2) & (cpuDice1 == cpuDice2)) {
				System.out.println("Damn! I win on a Double! Ah! I pity you!");
				System.out.println("Wanna try again? Press any key and ENTER to throw your dice or press 'Q' and ENTER to quit!");
				String userR2 = userRound2.nextLine();
				
				//play again or quit
				playOrQuit(userR2, quitter);
			}
			//tie regardless of how
			else {
				System.out.println("Stalemate! You're tough, let's try for a tie-breaker.");
				System.out.println("Press any key and ENTER to throw your dice or press 'Q' and ENTER to quit!");
				String userR2 = userRound2.nextLine();
				
				//play again or quit
				playOrQuit(userR2, quitter);
			}
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner round1 = new Scanner(System.in);
		String quit = "Q";
		
		//start game
		System.out.println("Welcome to the dice throw challenge!");
		System.out.println("Do you feel lucky? Punk...Do ya");
		System.out.println("Press any key and ENTER to throw your die or press Q and ENTER if you're chicken...");
		String userRound1 = round1.nextLine();
		
		//play or quit
		if (userRound1.equalsIgnoreCase(quit)) {
			System.out.println("See ya later alligator!");
			System.exit(0);
		}
		else {
			playGame();
		}

	}

}
