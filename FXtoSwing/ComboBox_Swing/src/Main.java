import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	JFrame frm;
	Main(){
		ComboMethods cm = new ComboMethods();
		cm.gui.app(frm, "ComboBox Demo", "Select Transport Type");
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main();
			}
		});
	}

}
