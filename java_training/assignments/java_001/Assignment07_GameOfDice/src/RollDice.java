import java.util.*;
class RollDice {
	
	static int getFace(int min, int max) {
		Random r = new Random();
		int rDie;
		
		rDie = r.nextInt((max-min) + 1) + min;
		
		return  rDie;
	}

}
