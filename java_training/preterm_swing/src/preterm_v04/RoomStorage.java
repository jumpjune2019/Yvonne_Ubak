package preterm_v04;


public class RoomStorage {
	//globals
	private Room[][] roomData;
	int row = 0;
	int col = 0;

	//constructor
	RoomStorage(){
		roomData = new Room[10][10];	//includes row names
		//sa.load();
	}

	RoomMatrix rm = (r, row, col) -> {
//		for(row =0; row<10; row++) {
//			for(col =0; col<10; col++) {
				roomData[row][col] = r;
				//col++;
//			}
			//row++;
//		}
	};
	
	ClearSeat clearSeat = (r, c) -> {
		roomData[r][c] = null;
	};
	
	getMatrix<Room> getRoom = () -> {
		return roomData;
	};

}
