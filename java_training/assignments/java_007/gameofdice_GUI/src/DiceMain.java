public class DiceMain {

	public static void main(String[] args) {		
		String welcomeMsg = "<html><div style= 'text-align: center;'>Welcome to the dice throw challenge!<br>" +
		"Do you feel lucky? <br>Press 'Click to Toss to find out!'</div></html>";
		
		//create class object
		GameMethods gm = new GameMethods();
		
		//invoke GUI
		gm.app.createGUI("Game of Dice", welcomeMsg, "Click to Toss", "Reset");
	}

}
