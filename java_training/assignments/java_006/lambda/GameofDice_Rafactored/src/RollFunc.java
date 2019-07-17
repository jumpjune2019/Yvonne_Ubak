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