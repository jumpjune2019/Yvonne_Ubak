import java.util.Random;
import java.util.Scanner;

class GameMethods {
	//use user input to continue game or quit
	static void playQuit(String input) {
		StateFunc pq = (in) -> {
			//user wants to quit
			if(in.equalsIgnoreCase("q")) {
				System.out.println("Thanks for being a sport! Later!");
				System.exit(0);
			}
			//user wants to play
			else {
				playGame();
			}
		};
		pq.PlayorQuit(input);
	}
	
	//user decides to play game
	static void playGame() {
		//function to throw the die
		RollFunc throwDie = (min, max) -> {
			Random r = new Random();
			int rDie;
			
			rDie = r.nextInt((max-min) + 1) + min;
			
			return  rDie;
		};
		
		//dice labels
		DiceMatrix label = new DiceMatrix();
		//variables
		int userSum;
		int cpuSum;
		Scanner userRound2 = new Scanner(System.in);
		
		System.out.println("Rolling the Dice!");
		int userDice1 = throwDie.dice(1, 6);		//user throw dice 1
		int userDice2 = throwDie.dice(1, 6);		//user throw dice 2
		int cpuDice1 = throwDie.dice(1, 6);			//computer throw dice 1
		int cpuDice2 = throwDie.dice(1, 6);			//computer throw dice 2
		
		userSum = userDice1 + userDice2;		//user total
		cpuSum = cpuDice1 + cpuDice2;			//computer total
		
		System.out.println("You have rolled a "+ userDice1 + " and " + userDice2 + " > the '" + label.dieLabels[userDice1-1][userDice2-1] + "'");
		System.out.println("I have rolled a "+ cpuDice1 + " and " + cpuDice2 + " > the '" + label.dieLabels[cpuDice1-1][cpuDice2-1] + "'");
		
		//if user wins
		if(userSum > cpuSum) {
			System.out.println("You win!!");
			System.out.println("Did you cheat?? Gimme another try, c'mon! Press any key and ENTER to throw your dice or press 'Q' and ENTER to quit!");
			String userR2 = userRound2.nextLine();

			//play again or quit
			playQuit(userR2);
		}
		//computer wins
		else if (cpuSum > userSum) {
			System.out.println("I win!!");
			System.out.println("Wanna try again? Press any key and ENTER to throw your dice or press 'Q' and ENTER to quit!");
			String userR2 = userRound2.nextLine();

			//play again or quit
			playQuit(userR2);
		}
		//tie
		else if(cpuSum == userSum) {
			//user has doubles
			if((userDice1 == userDice2) & (cpuDice1 != cpuDice2)) {
				System.out.println("Damn! You win on a Double!  What Luck!");
				System.out.println("Did you cheat?? Gimme another try, c'mon! Press any key and ENTER to throw your dice or press 'Q' and ENTER to quit!");
				String userR2 = userRound2.nextLine();

				//play again or quit
				playQuit(userR2);
			}
			//computer has doubles
			else if((userDice1 != userDice2) & (cpuDice1 == cpuDice2)) {
				System.out.println("Damn! I win on a Double! Ah! I pity you!");
				System.out.println("Wanna try again? Press any key and ENTER to throw your dice or press 'Q' and ENTER to quit!");
				String userR2 = userRound2.nextLine();
				
				//play again or quit
				playQuit(userR2);
			}
			//tie regardless of how
			else {
				System.out.println("Stalemate! You're tough, let's try for a tie-breaker.");
				System.out.println("Press any key and ENTER to throw your dice or press 'Q' and ENTER to quit!");
				String userR2 = userRound2.nextLine();
				
				//play again or quit
				playQuit(userR2);
			}
		}
	}
	
}
