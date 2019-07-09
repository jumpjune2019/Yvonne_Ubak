//the die labels
public class PhoneData {
		
		//2D array
		String[][] phoneRecords = new String[5][3];
		
		//formatted table for console
				String tableData() {
					String table = "PhoneBook App" +
					"\r\n\tName \t\tPhone\t\tCity" +
					"\r\n1]\t" + phoneRecords[0][0] +"\t\t"+ phoneRecords[0][1] +"\t"+ phoneRecords[0][2]+
					"\r\n2]t" + phoneRecords[1][0] +"\t"+ phoneRecords[1][1] +"\t"+ phoneRecords[1][2]+
					"\r\n3]\t" + phoneRecords[2][0] +"\t\t"+ phoneRecords[2][1] +"\t\t"+ phoneRecords[2][2]+
					"\r\n4]\t" + phoneRecords[3][0] +"\t\t"+ phoneRecords[3][1] +"\t"+ phoneRecords[3][2]+
					"\r\n5]\t" + phoneRecords[4][0] +"\t"+ phoneRecords[4][1] +"\t"+ phoneRecords[4][2];
					
					return table;
				}

}
