
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//2D array
		String[][] dieLabels = {{"Snake eyes", "Australian yo", "Little Joe from Kokomo", "No field five", "Easy six", "Six one you're done"},
					 {"Ace cught a deuce", "Ballerina", "The Fever", "Jimmie Hicks", "Benny Blue", "Easy eight"},
					 {"Easy four", "OJ", "Brooklyn Forest", "Big Red","Eighter from Decatur", "Nina from Pasadena"},
					 {"Little Phoebe", "Easy six", "Skinny Mckinney", "Square pair", "Railroad Nine", "Big one on the end"},
					 {"Sixie from Dixie", "Skinny Dugan", "Easy eight", "Jesse James","Puppy paws", "Yo"},
					 {"The Devil", "Easy eight", "Lou Brown", "Tennessee", "Six five no jive", "Midnight"}};
		
		
		//output
		System.out.println("Dice Combinations Label Matrix");
		System.out.println("\tDice 1\t\t\tDice 2\t\tDice 3\t\t\tDice 4\t\tDice 5\t\t\tDice 6");
		System.out.println("Dice 1\t" + dieLabels[0][0] +"\t\t"+ dieLabels[0][1] +"\t"+ dieLabels[0][2]+"\t"+ dieLabels[0][3]+"\t"+ dieLabels[0][4]+"\t\t"+ dieLabels[0][5] );
		System.out.println("Dice 2\t" + dieLabels[1][0] +"\t"+ dieLabels[1][1] +"\t"+ dieLabels[1][2]+"\t\t"+ dieLabels[1][3]+"\t"+ dieLabels[1][4]+"\t\t"+ dieLabels[1][5] );
		System.out.println("Dice 3\t" + dieLabels[2][0] +"\t\t"+ dieLabels[2][1] +"\t\t"+ dieLabels[2][2]+"\t\t"+ dieLabels[2][3]+"\t\t"+ dieLabels[2][4]+"\t"+ dieLabels[2][5] );
		System.out.println("Dice 4\t" + dieLabels[3][0] +"\t\t"+ dieLabels[3][1] +"\t"+ dieLabels[3][2]+"\t\t"+ dieLabels[3][3]+"\t"+ dieLabels[3][4]+"\t\t"+ dieLabels[3][5] );
		System.out.println("Dice 5\t" + dieLabels[4][0] +"\t"+ dieLabels[4][1] +"\t"+ dieLabels[4][2]+"\t\t"+ dieLabels[4][3]+"\t"+ dieLabels[4][4]+"\t\t"+ dieLabels[4][5] );
		System.out.println("Dice 6\t" + dieLabels[5][0] +"\t\t"+ dieLabels[5][1] +"\t"+ dieLabels[5][2]+"\t\t"+ dieLabels[5][3]+"\t"+ dieLabels[5][4]+"\t"+ dieLabels[5][5] );
	}

}
