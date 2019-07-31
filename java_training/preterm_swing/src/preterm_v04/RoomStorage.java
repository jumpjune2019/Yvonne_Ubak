package preterm_v04;


public class RoomStorage {
	//---------------------------------------------globals
	private Room[][] roomData;
	int row = 0;
	int col = 0;

	//----------------------------------------------constructor
	RoomStorage(){
		roomData = new Room[10][10];	//includes row names
	}

	//---------------------------------------add to Room Matrix
	RoomMatrix rm = (r, row, col) -> {
		roomData[row][col] = r;
	};
	
	//---------------------------------------remove from room matrix
	ClearSeat clearSeat = (r, c) -> {
		roomData[r][c] = null;
	};
	
	//---------------------------------------get matrix
	getMatrix<Room> getRoom = () -> {
		return roomData;
	};

}
