package preterm_v02;

public class Room {
	private int cID = 0;
	private String cFullName = "";
	private String cInitial = "";
	private String row = "";
	private String column = "";
	boolean canBeAssigned = true;
	
	//constructors
	Room(int id, String cfn, String ci, String r, String c, boolean cba){
		cID = id;
		cInitial = ci;
		cFullName = cfn;
		row = r;
		column = c;
		canBeAssigned = cba;
	}
	
	String getSeat() {
		String seatName = row + "-" + column; 
		return seatName;
	}
	
	String getSeatRef() {
		String s;
		//if(cInitial.equals("") && cID == 0) {
			//s = "vacant";
		//}
	//else {
		s = "id: " + cID+ " " + cInitial;
		//}
		return s;
	}
	
	String getInitials() {
		return cInitial;
	}
	
	boolean getAvail() {
		return canBeAssigned;
	}
	
	int getID() {
		return cID;
	}
	
	String getFullName() {
		return cFullName;
		
	}
	
}
