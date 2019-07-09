import java.util.*;
import java.io.*;

public class Main {

	//phone records entry
	static void phoneEntry() throws NullEntryException {
		Scanner uIn = new Scanner(System.in);
		Scanner aQ = new Scanner(System.in);
		String menuSelect;
		String uName;
		String uPhone;
		String uCity;
		
		for(int i = 0; i< 5; i++) {
			try {
				System.out.print("Name: ");
				uName = uIn.nextLine();
				System.out.print("\nPhone: ");
				uPhone = uIn.nextLine();
				System.out.print("\nCity: ");
				uCity = uIn.nextLine();
				
				//feedback
				System.out.println("Name: " + uName + " Phone: "+ uPhone + " City: " + uCity);
				System.out.println("1] Accept this data");
				System.out.println("2] Write a new row");
				menuSelect = aQ.nextLine();
				
				//accept
				if(menuSelect == "1") {
					printConsole();
					printFile();
				}
				else if(menuSelect == "2") {
					uName = null;
					uPhone = null;
					uCity = null;
					continue;
				}
				
			}catch(Exception ne) {
				throw new NullEntryException();
				//continue;
			}
		}
	}
	
	//display on console
	static void printConsole() {
		PhoneData pd = new PhoneData();
		System.out.println(pd.tableData());
	}
		
	//write to file
	static void printFile() {
		PhoneData pd = new PhoneData();
		String data = pd.tableData();
		File dFile = new File("phone.txt");
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
	
	public static void main(String[] args) throws NullEntryException {
		// TODO Auto-generated method stub
		
		//enter data
		System.out.println("PhoneBook App");
		phoneEntry();
	}

}
