import javax.swing.SwingUtilities;

public class GridMain {
	GridMain(){
		GridMethods gm = new GridMethods();
		gm.createGUI();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GridMain();
			}
		});
	}

}
