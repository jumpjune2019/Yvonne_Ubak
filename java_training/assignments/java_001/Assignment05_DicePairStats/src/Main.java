
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RollDice dieObj = new RollDice();
		tallyDice tallyObj = new tallyDice();
		int d1 = tallyObj.dice1;
		int d2 = tallyObj.dice2;
		
		//roll 2 die 1000 times
		for(int i=0;i<1000;i++) {
			//roll die
			 d1 = dieObj.getFace(1, 6);
			 d2 = dieObj.getFace(1, 6);
			
			 //tally
			 tallyObj.checkCombos(d1, d2);
		}
		
		//report
		System.out.println("1000 Random 2 die toss stats: ");
		System.out.println("Dice 1 and 1: " + tallyObj.c1 + " times.");
		System.out.println("Dice 2 and 1: " + tallyObj.c2 + " times.");
		System.out.println("Dice 3 and 1: " + tallyObj.c3 + " times.");
		System.out.println("Dice 4 and 1: " + tallyObj.c4 + " times.");
		System.out.println("Dice 5 and 1: " + tallyObj.c5 + " times.");
		System.out.println("Dice 6 and 1: " + tallyObj.c6 + " times.");
		System.out.println("Dice 2 and 2: " + tallyObj.c7 + " times.");
		System.out.println("Dice 3 and 2: " + tallyObj.c8 + " times.");
		System.out.println("Dice 4 and 2: " + tallyObj.c9 + " times.");
		System.out.println("Dice 5 and 2: " + tallyObj.c10 + " times.");
		System.out.println("Dice 6 and 2: " + tallyObj.c11 + " times.");
		System.out.println("Dice 3 and 3: " + tallyObj.c12 + " times.");
		System.out.println("Dice 4 and 3: " + tallyObj.c13 + " times.");
		System.out.println("Dice 5 and 3: " + tallyObj.c14 + " times.");
		System.out.println("Dice 6 and 3: " + tallyObj.c15 + " times.");
		System.out.println("Dice 4 and 4: " + tallyObj.c16 + " times.");
		System.out.println("Dice 5 and 4: " + tallyObj.c17 + " times.");
		System.out.println("Dice 6 and 4: " + tallyObj.c18 + " times.");
		System.out.println("Dice 5 and 5: " + tallyObj.c19 + " times.");
		System.out.println("Dice 6 and 5: " + tallyObj.c20 + " times.");
		System.out.println("Dice 6 and 6: " + tallyObj.c21 + " times.");
		
	}

}
