package headortail_GUI;
//interface that accepts user input, minimum, and maximum
interface FlipFunc {
	int func(int min, int max);
}

//interface to accept coin value and spit out head or tail
interface HTFunc {
	String func(int v);
}

//interface for GUI
interface GUIFunc{
	void func(String title, String lt, String b1, String b2);
}

