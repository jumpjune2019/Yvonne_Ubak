import java.util.Scanner;
public class CoinMain {

	public static void main(String[] args) {	
		boolean go = true;
		
		//output
		System.out.println("Welcome to the game of Head or Tail where you will flip your life away!");
		System.out.println("Press the F key and Enter to flip your luck!");	
		//user input
		Scanner sc = new Scanner(System.in);
		String uIn = sc.nextLine();
		
		while(go) {
			if(uIn.equalsIgnoreCase("F")) {
				int coin = CoinDetails.flipCoin();
				String result = CoinDetails.coinFace(coin);
				System.out.println("The coin flip is " + result);
				System.out.println("Press the F key and Enter to try again, press Q and Enter to Quit");
				uIn = sc.nextLine();
			}else if(uIn.equalsIgnoreCase("Q")) {
				System.out.println("Thank you for playing!");
				go = false;
			}
		}
		
		sc.close();
		System.exit(0);
		
	}

}
