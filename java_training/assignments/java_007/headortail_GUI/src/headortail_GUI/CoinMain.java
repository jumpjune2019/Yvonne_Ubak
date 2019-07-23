package headortail_GUI;
public class CoinMain {

	public static void main(String[] args) {	
		//create class object
		CoinDetails cd = new CoinDetails();
		
		//invoke GUI
		cd.app.func("Heads or Tails", "waiting...", "Click to Flip!", "Reset");

	}

}
