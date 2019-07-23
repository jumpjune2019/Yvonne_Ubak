//rolls die
interface RollFunc {
	int dice(int min, int max);
}

//processes user input
interface StateFunc{
	void PlayorQuit(String in);
}

//play the game
interface GameFunc{
	void playGame();
}

//create GUI
interface GUIFunc{
	void createGUI(String title, String lt, String b1, String b2);
}