import java.io.*;
import java.util.*;

public class Main {
	
	//Menu---- strictly text
	static void Menu() {
		System.out.println("\t\t\t\t\t\tDice Combinations Label Matrix");
		System.out.println("\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\t\t\t\t\t\t\tDo you want to: ");
		System.out.println("\t\t\t\t\t\t   1. print on screen only");
		System.out.println("\t\t\t\t\t\t   2. print on file");
		System.out.println("\t\t\t\t\t\t   3. print on both");
		System.out.print("\n\t\t\t\t\t\t   Select an option: ");
	}
	
	//display on console
	static void printConsole() {
		DiceMatrix labels = new DiceMatrix();
		System.out.println(labels.tableData());
	}
	
	//write to file
	static void printFile() {
		DiceMatrix labels = new DiceMatrix();
		String data = labels.tableData();
		File dFile = new File("DiceLabels.txt");
		FileWriter printTo = null;
		
		try {
			printTo = new FileWriter(dFile);
			printTo.write(data);
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				printTo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuSelection ms = new MenuSelection();
		int uIn;
		 
		//display menu
		Menu();
		
		//get user selection
		uIn = ms.userIn();
		
		//verify menu selection
		switch(uIn) {
		case 1:
			printConsole();
			break;
		case 2:
			printFile();
			break;
		case 3:
			printFile();
			printConsole();
			break;
		default:
			System.out.println("\t\t\t\t\t\tInvalid menu option. Goodbye...");
			System.exit(0);
		}
	}

}
