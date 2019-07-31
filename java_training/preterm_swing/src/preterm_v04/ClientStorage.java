package preterm_v04;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClientStorage {
	//scope variables
	private Client[] clientData;
	private int count;
	private String fileName;
	
	//constructor
	ClientStorage(String fn){
		//limit of 25 records for now
		clientData = new Client[25];
		count = 0;
		fileName = fn;
		boolean success = lc.load(fn);	//immediately loads file data
		if(!success) {
			System.out.println("File was unable to load.");
		}
	}
	
	//add a client to the Client array
	newClient nc = (c) -> {
		if(count < 25) {
			clientData[count] = c;
			count++;
		}else {
			System.out.println("The limit of 25 has been reached.");
		}
	};
	
	//get client record from the file	
		loadClient lc = (f) -> {
			//variables
			String fLine;
			String[] record;
			boolean first = true; //beginning on first line
			
			try(BufferedReader br = new BufferedReader(new FileReader(f))){
				while((fLine = br.readLine()) != null) {
					//skips first line
					if(first) {
						first = false;
						continue;		//jumps to next iteration
					}
					//for rest of file
					record = fLine.split(",");
					//firstName, LastName, id
					Client client = new Client(record[2], record[1], Integer.parseInt(record[0]));
					nc.add(client);
				}
			}catch(IOException e) {
				System.out.println("There is an IO Error: " + e);
			}
			return true;	
		};
	
	//getters
	getArray<Client> getClientData = () -> {
		return clientData;
	};
	
	getCount getCount = () -> {
		return count;
	};

}
