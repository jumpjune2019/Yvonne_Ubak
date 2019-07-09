import java.io.*;
//import java.util.*;

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
	static void printConsole() throws InvalidMatrixValueException {
		DiceMatrix labels = new DiceMatrix();
		
		try {
		System.out.println(labels.tableData());
		}catch(Exception err){
			throw new InvalidMatrixValueException("\t\t\t\t\t\tMatrix reference is invalid! Goodbye!");
		}
	}
	
	//write to file
	static void printFile() throws InvalidMatrixValueException{
		DiceMatrix labels = new DiceMatrix();
		String data = labels.tableData();
		File dFile = new File("DiceLabels.txt");
		FileWriter printTo = null;
		
		try {
			printTo = new FileWriter(dFile);
			printTo.write(data);
		}catch(Exception err){
			throw new InvalidMatrixValueException("\t\t\t\t\tMatrix reference is invalid! Goodbye!");
		}finally {
			try {
				printTo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public static void main(String[] args) throws InvalidMenuException {
		
		MenuSelection ms = new MenuSelection();
		int uIn;
		 
		//display menu
		Menu();
		
		//get user selection
		uIn = ms.userIn();
		
		//verify menu selection
		switch(uIn) {
		case 1:
			try {
				printConsole();
			}catch(InvalidMatrixValueException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			break;
		case 2:
			try {
				printFile();
			}catch(InvalidMatrixValueException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			break;
		case 3:
			try {
				printFile();
			}catch(InvalidMatrixValueException e) {
				e.getMessage();
			}finally {
				try {
					printConsole();
				}catch(InvalidMatrixValueException e) {
					System.out.println(e.getMessage());
					System.exit(0);
				}
			}
			break;
		default:
			throw new InvalidMenuException();
		}
	}

}
