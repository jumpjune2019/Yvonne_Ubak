package preterm_v02;

public class Scaffolding {
	//globals
	RoomStorage rmStore = new RoomStorage();
	int rowVal = 0;
	int colVal =0;
	int seatNum;
	char rowlbl;
	
	 void start() {
		System.out.println("start()--->");
		System.out.println("* Enter application");
		System.out.println("* Ask to login, register, or quit\n\n");
	}
	
	 char getRow(int rv) {
		 switch(rv) {
			case 0:
				rowlbl ='A';
				break;
			case 1:
				rowlbl ='B';
				break;
			case 2:
				rowlbl ='C';
				break;
			case 3:
				rowlbl ='D';
				break;	
			case 4:
				rowlbl ='E';
				break;	
			case 5:
				rowlbl ='F';
				break;
			case 6:
				rowlbl ='G';
				break;
			case 7:
				rowlbl ='H';
				break;
			case 8:
				rowlbl ='I';
				break;
			case 9:
				rowlbl ='J';
				break;
			}
		 return rowlbl;
	 }
	 
	 int getSeatNumber(int sn) {
		 switch(sn) {
		 case 0:
			 seatNum =1;
			 break;
		 case 1:
			 seatNum =2;
			 break;
		 case 2:
			 seatNum =3;
			 break;
		 case 3:
			 seatNum =4;
			 break;	
		 case 4:
			 seatNum =5;
			 break;	
		 case 5:
			 seatNum =6;
			 break;
		 case 6:
			 seatNum =7;
			 break;
		 case 7:
			 seatNum =8;
			 break;
		 case 8:
			 seatNum =9;
			 break;
		 case 9:
			 seatNum =10;
			 break;
		 }
		 return seatNum;
	 }
	 
	
	void getInputandProcess() {
		ClientStorage cStore = new ClientStorage("clients.csv");
		Client[] data = cStore.getClientData.storage();

		//Randomly assign clients to seat	
			for(Client c : data) {
				if(c != null) {
					rowVal = (int) (Math.random() * ((9) + 1)) + 0;
					colVal = (int) (Math.random() * ((9) + 1)) + 0;
					int uID = c.getID();
					String uName = c.getFullClient();
					String rowLtr = Character.toString(getRow(rowVal));
					String colNum = Integer.toString(getSeatNumber(colVal));
					String uInitials = c.getInititals();
					
					Room seatBooking = new Room(uID, uName, uInitials, rowLtr, colNum, true);
//					System.out.println("UID: " +uID+ " Initials: " + uInitials + " row " + rowLtr+ " seat: " + colNum);
					rmStore.rm.add(seatBooking, rowVal, colVal);
				}
			}
		
		
	}
	
	void getOutput() {
		System.out.println("This is the seating chart");
		
		//get room matrix
		Room[][] rmData = rmStore.getRoom.storage();
		
		
		//add column names
		seatNum =1;
		System.out.print("     ");
		for(int s = 0; s < 10; s++){
			System.out.printf("%16s", "Seat " + seatNum);
//			System.out.print("Seat " + seatNum + " ");
			seatNum++;
		}
		System.out.println();
		
		//add rows with labels
		rowlbl = 'A';
		String bookingInfo = "";
		for(int row = 0; row < 10; row++) {
			Room r;
			System.out.print("Row " + rowlbl);
//			System.out.println("Row " + rowlbl);
			for(int column = 0; column < 10; column++) {
				r = rmData[row][column];
				
				if(r != null) {
					bookingInfo = (r.getSeatRef());
					System.out.printf("%16s", bookingInfo);
				}
				else {
					System.out.printf("%16s", "vacant");
				}
			}
			System.out.println();
			rowlbl++;
		}
		
		//labels
		System.out.println("\nThis is client list and their seating assignments");
		System.out.printf("%30s %5s %12s", "Client", "ID", "Seat\n");
		
		//print seating assignments
		for(int rowP = 0; rowP < 10; rowP++) {
			Room r;
			for(int columnP = 0; columnP < 10; columnP++) {
				r = rmData[rowP][columnP];
				
				if(r != null) {
					String clientInfo = r.getFullName();
					int clientID = r.getID();
					String clientSeat = r.getSeat();
					System.out.printf("%30s %5d %10s", clientInfo, clientID, clientSeat);
					System.out.println();
				}
				else {
					continue;
				}
			}
		}
		
	}
	
	void end() {
		System.out.println("\n\nend()");
		System.out.println("Log out user and Exit the application");
		System.exit(0);
	}
	
}
