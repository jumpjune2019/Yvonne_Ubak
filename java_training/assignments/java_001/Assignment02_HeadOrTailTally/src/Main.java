
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initialize array and scores
		int headScore = 0;
		int tailScore = 0;
		int tally[] = {headScore, tailScore};
		
		//toss the coin 1000 times
		int coin =0;	
		for(int i =0; i<1000; i++) {
			//toss coin
			coin = CoinToss.getValue(1, 2);
			//check value and append to head or tail score
			if(coin == 1) {
				headScore+= 1;
			}
			else if(coin == 2) {
				tailScore+=1;
			}
		}
		
		System.out.println("1000 Coin FLips");
		System.out.println("Count of Head: "+ headScore);
		System.out.println("Count of Tail: "+ tailScore);

	}

}
