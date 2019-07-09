import java.util.*;
import java.io.*;

public class Main {

	//phone records entry
	static void phoneEntry() throws NullEntryException {
		String [][]phoneArr = new String[5][3];
		Scanner uIn = new Scanner(System.in);
		Scanner aQ = new Scanner(System.in);
		String menuSelect;
		String uName;
		String uPhone;
		String uCity;
		int x=0;
		
		for(int i = 0; i< 5; i++) {
			try {
				System.out.print("Name: ");
				uName = uIn.nextLine();
				verifyInput(uName);
				System.out.print("\nPhone: ");
				uPhone = uIn.nextLine();
				verifyInput(uPhone);
				System.out.print("\nCity: ");
				uCity = uIn.nextLine();
				verifyInput(uCity);
				
				//feedback
				System.out.println("Name: " + uName + " Phone: "+ uPhone + " City: " + uCity);
				System.out.println("1] Accept this data");
				System.out.println("2] Write a new row");
				menuSelect = aQ.nextLine();
				
				//accept
				if(menuSelect.equals("1")) {
					phoneArr[i][x] = uName;
					phoneArr[i][x+1] = uPhone;
					phoneArr[i][x+2] = uCity;
				}
				else if(menuSelect.equals("2")) {
					uName = null;
					uPhone = null;
					uCity = null;
					i--;
					continue;
				}
				
			}catch(Exception ne) {
				i--;
				continue;
				
			}
		}
		printConsole(phoneArr);
		printFile(phoneArr);
	}
	
	//display on console
	static void printConsole(String [][] phoneRecords) {
		//2D array
		//phoneRecords = new String[5][3];		//[row][column]
				
		System.out.println("Phonebook Data");
		String format ="%-30s";
		System.out.printf(format, "Name");
		System.out.printf(format, "Phone");
		System.out.printf(format, "City");
		System.out.println();
				
		//add each row
		for(int i=0; i<5; i++) {
			for(int x=0; x<3;x++) {
				System.out.printf(format, phoneRecords[i][x]);
			}
			System.out.println();
		}
	}
		
	//write to file
	static void printFile(String [][] phoneRecords) {
		//2D array
		//phoneRecords = new String[5][3];		//[row][column]
		File dFile = new File("phone.txt");
		PrintWriter printTo = null;
		
		try {
			printTo = new PrintWriter(dFile);
			printTo.write("Phonebook Data");
			printTo.println();
			printTo.append(String.format("%-30s", "Name"));
			printTo.append(String.format("%-30s", "Phone"));
			printTo.append(String.format("%-30s", "City"));
			printTo.println();
			
			//add each row
			for(int i=0; i<5; i++) {
				//columns
				for(int x=0; x<3;x++) {
					printTo.append(String.format("%-30s",phoneRecords[i][x]));
				}
				printTo.println();
			}
			
		}catch(IOException e) {
			System.out.println("Could not create file");
			//e.printStackTrace();
		}finally {
				printTo.close();
		}
		
			
	}
	
	//ensure that entry ins't null
	static void verifyInput(String s) throws NullEntryException{
		if(s.equals("")) {
			throw new NullEntryException("You did not enter a value. Please try again.");
		}
	}
	
	//application
	public static void main(String[] args) throws NullEntryException {
		// TODO Auto-generated method stub
		
		//enter data
		System.out.println("PhoneBook App");
		phoneEntry();
	}

}
