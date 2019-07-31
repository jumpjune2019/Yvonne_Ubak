package preterm_v03;


interface RoomMatrix {
	void add(Room r, int row, int col);
}

interface seatAssignments {
	void load();
}

interface getMatrix<T>{
	T[][] storage();
}
