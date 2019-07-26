import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	JFrame frm;
	
	Main(){
		Methods m = new Methods();
		m.gui.app(frm, "Checkbox Demo", "Select App Deployment Options", "Nothing Clicked.", "<none>", "Web", "Desktop", "Mobile");
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
		
	}
}
