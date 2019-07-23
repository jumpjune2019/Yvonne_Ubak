import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
//import java.util.concurrent.TimeUnit;

class GameMethods {
	//globals
	static JLabel lbl;
	static JLabel resultsLbl;
	JButton resetBtn;
	//Event listeners
	//flip coin when press button
	ActionListener clickToToss = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			playGame();
			resetBtn.setEnabled(true);
		}
	};
	//reset label when clicked
	ActionListener resetLbl = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String welcomeMsg = "<html><div style= 'text-align: center;'>Welcome to the dice throw challenge!<br>" +
					"Do you feel lucky? <br>Press 'Click to Toss to find out!'</div></html>";
			lbl.setText(welcomeMsg);
			resultsLbl.setText("");
			resetBtn.setEnabled(false);

		}
	};

	/*//use user input to continue game or quit
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
	}*/

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

		//lbl.setText("Rolling the Dice!");
		int userDice1 = throwDie.dice(1, 6);		//user throw dice 1
		int userDice2 = throwDie.dice(1, 6);		//user throw dice 2
		int cpuDice1 = throwDie.dice(1, 6);			//computer throw dice 1
		int cpuDice2 = throwDie.dice(1, 6);			//computer throw dice 2

		userSum = userDice1 + userDice2;		//user total
		cpuSum = cpuDice1 + cpuDice2;			//computer total

		/*try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			lbl.setText("Uh oh! Thread was interrupted");
		}*/
		lbl.setText("<html><div style= 'text-align: center;'>You have rolled a "+ userDice1 + " and " + userDice2 + " > the '" + label.dieLabels[userDice1-1][userDice2-1] + "'" +
		"<br>I have rolled a "+ cpuDice1 + " and " + cpuDice2 + " > the '" + label.dieLabels[cpuDice1-1][cpuDice2-1] + "'</div></html>");

		/*try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			lbl.setText("Uh oh! Thread was interrupted");
		}*/
		//if user wins
		if(userSum > cpuSum) {
			resultsLbl.setText("<html><div style= 'text-align: center;'>You win!!" +
					"<br>Did you cheat?? Gimme another try, c'mon! <br>Press the 'Click to Toss' button to throw your die again!</div></html>");
		}
		//computer wins
		else if (cpuSum > userSum) {
			resultsLbl.setText("<html><div style= 'text-align: center;'>I win!!" +
			"<br>Wanna try again? <br>Press the 'Click to Toss' button to throw your die again!</div></html>");
		}
		//tie
		else if(cpuSum == userSum) {
			//user has doubles
			if((userDice1 == userDice2) & (cpuDice1 != cpuDice2)) {
				resultsLbl.setText("<html><div style= 'text-align: center;'>Damn! You win on a Double!  What Luck!" +
				"<br>Did you cheat?? <br>Gimme another try, c'mon! <br>Press the 'Click to Toss' button to throw your die again!</div></html>");
			}
			//computer has doubles
			else if((userDice1 != userDice2) & (cpuDice1 == cpuDice2)) {
				resultsLbl.setText("<html><div style= 'text-align: center;'>Damn! I win on a Double! Ah! I pity you!" +
				"<br>Wanna try again? <br>Press the 'Click to Toss' button to throw your die again!</div></html>");
			}
			//tie regardless of how
			else {
				resultsLbl.setText("<html><div style= 'text-align: center;'>Stalemate! You're tough, let's try for a tie-breaker." +
				"<br>Press the 'Click to Toss' button to throw your die again!</div></html>");
			}
		}
	}

	GUIFunc app = (title, lt, b1, b2) -> {
		//create components
		JFrame frame = new JFrame(title);
		JPanel mainPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		JPanel lblPanel = new JPanel();
		lbl = new JLabel(lt);
		resultsLbl = new JLabel();
		JButton flipBtn = new JButton(b1);
		resetBtn = new JButton(b2);

		//settings
		btnPanel.setLayout(new FlowLayout());
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		lblPanel.setLayout(new GridLayout(2,1));
		lbl.setHorizontalAlignment(JLabel.CENTER);
		resultsLbl.setHorizontalAlignment(JLabel.CENTER);
		frame.add(mainPanel);
		mainPanel.add(btnPanel);
		mainPanel.add(lblPanel);
		btnPanel.add(flipBtn);
		btnPanel.add(resetBtn);
		lblPanel.add(lbl);
		lblPanel.add(resultsLbl);
		frame.setSize(250, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.pack();
		flipBtn.addActionListener(clickToToss);
		resetBtn.addActionListener(resetLbl);

		//enables or disables reset button
		if(lt.contains("Welcome")) {
			resetBtn.setEnabled(false);
		}
		else {
			resetBtn.setEnabled(true);
		}

	};

}
