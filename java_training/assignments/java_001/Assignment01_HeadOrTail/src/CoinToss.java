import java.util.*;

//This class will spit out a random number inclusive to the min and max
class CoinToss {
	
	static int getValue(int min, int max) {
		Random r = new Random();
		int rVal;
		
		rVal = r.nextInt((max-min) + 1) + min;
		
		return  rVal;
	}
	
}
