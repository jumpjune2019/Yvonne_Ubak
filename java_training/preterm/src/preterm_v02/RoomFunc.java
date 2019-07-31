package preterm_v02;

interface RoomMatrix {
	void add(Room r, int row, int col);
}

interface seatAssignments {
	void load();
}

interface getMatrix<T>{
	T[][] storage();
}
