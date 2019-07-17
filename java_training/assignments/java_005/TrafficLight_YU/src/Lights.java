//enumeration
public enum Lights {
	Green(5), Yellow(2), Red(3), None(0);
	
	private int sec;
	Lights(int s){
		sec = s;
	}
	
	int getSec() {
		return sec;
	}
}
