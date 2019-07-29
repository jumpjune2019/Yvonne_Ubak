package preterm_v02;

public class Client {
	private String fName;
	private String lName;
	private int id;
	
	//constructor
	Client(String f, String l, int i){
		fName = f;
		lName = l;
		id = i;
	}
	
	int getID() {
		return id;
	}
	
	String getFirstName() {
		return fName;
	}
	
	String getLastName() {
		return lName;
	}
	
	//needed for room Matrix assignments
	String getInititals() {
		char[] initialsArray= {' ', ' '};	//initialize
		initialsArray[0] = fName.charAt(0);
		initialsArray[1] = lName.charAt(0);
		
		return new String(initialsArray);
	}
	
	String getFullClient() {
		String fullClient = (fName + " " + lName);
		
		return fullClient;
	}
	
}
