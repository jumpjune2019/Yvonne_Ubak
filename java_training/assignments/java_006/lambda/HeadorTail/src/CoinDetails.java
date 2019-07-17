import java.util.Random;

class CoinDetails {
	//toss coin
		static int flipCoin() {
			//lambda function to toss coin
			FlipFunc toss = (min, max) -> {
				Random r = new Random();		//Random object
				int rVal;

				//calculate random value within an inclusive range
				rVal = r.nextInt((max-min) + 1) + min;

				return  rVal;
			};
			return toss.func(1, 2);
		}
		
		//give face value
		static String coinFace(int f) {
			//lambda function to spit out heads or tails
			HTFunc face = (v) -> {
				String ht = "";
				
				if( v == 1) {
					ht = "Heads";
				}else if(v == 2) {
					ht = "Tails";
				}
				
				return ht;
			};
			return face.func(f);
		}	
}
