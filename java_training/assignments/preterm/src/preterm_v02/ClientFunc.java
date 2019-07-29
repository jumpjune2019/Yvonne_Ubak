package preterm_v02;

//all Client interfaces for lambda functions

//adding a new client from file to the storage array
interface newClient {
	void add(Client c);
}

//loading file
interface loadClient {
	boolean load(String f);
}

//get data
interface getArray<T>{
	T[] storage();
}
interface getCount{
	int count();
}

