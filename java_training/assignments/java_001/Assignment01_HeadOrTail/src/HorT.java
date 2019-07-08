//import java.util.*;

//this class will return Heads or Tails
public class HorT {
	static int tossCoin() {
		int coinVal = CoinToss.getValue(1, 2);		//return either 1 or 2
		return coinVal;
	}
	
	static String getHeadTail(int coin) {
		//assign heads or tails
		String ht = "N/A";
		
		if(coin == 1) {
			ht = "Heads";
		}
		else if(coin == 2) {
			ht = "Tails";
		}
		
		return ht;
	}
}
