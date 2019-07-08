
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//toss the coin
		int coin = HorT.tossCoin();
		
		//heads or tails?
		String headTail = HorT.getHeadTail(coin);
		
		System.out.println("Coin Flip Program");
		System.out.println("The Coin Flip is: "+ headTail);

	}

}
