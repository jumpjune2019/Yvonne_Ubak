package preterm_v04;


interface RoomMatrix {
	void add(Room r, int row, int col);
}

interface ClearSeat{
	void remove(int r, int c);
}

interface getMatrix<T>{
	T[][] storage();
}
