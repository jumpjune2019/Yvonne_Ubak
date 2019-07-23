// A simple Swing Program
import java.awt.*;
import javax.swing.*;
public class Main {
	
	static PositionFunc pos = (frm, width, height) -> {
		// set the size of the frame to half in width and height
		frm.setSize(width/2, height/2);
		// here's the part where the JFrame gets actually centered
		frm.setLocationRelativeTo(null);
	};

	static SettingsFunc frmSet =  (frm, onExit, width, height) -> {
		// this will center and size the JFrame on screen
		// it will have a height and width of half the screen
		pos.centerAndSizeJFrameOnScreen(frm, width, height);
		frm.setDefaultCloseOperation(onExit);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		
		ButtonDemo bd = new ButtonDemo();
		bd.btnSettings.setButtons(panel1, "First", "Second", "You Pressed First", "You Pressed Second");
		ButtonDemo bd2 = new ButtonDemo();
		bd2.btnSettings.setButtons(panel2, "Up", "Down", "Going Up!", "Going Down!");
		
		frm.add(panel1);
		frm.add(panel2);
		return frm;
	};
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			SwingDemo demo;
			JFrame frm;
			
			public void run() {
				demo = new SwingDemo("Playing with JButton using a FlowLayout");
				frm = demo.app.getFrame();
				frm = frmSet.setFrameStuff(frm, JFrame.EXIT_ON_CLOSE, 400, 380);
				frm.setVisible(true);
			}
		});
	}
}