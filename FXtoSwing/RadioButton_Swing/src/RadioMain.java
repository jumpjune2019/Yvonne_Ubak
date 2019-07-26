import javax.swing.SwingUtilities;

public class RadioMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable( ) {
			public void run() {
				RadioMethods rm = new RadioMethods();
				rm.app();
			}
		});
	}

}
