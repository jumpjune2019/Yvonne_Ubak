import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	static void runApp() {
		//core setup
		JFrame frm = new JFrame("Fungi is hilarious!");
		JPanel pan = new JPanel();
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		
		//image
		ImageIcon fungi = new ImageIcon("src/fungi.png");
		Image image1 = fungi.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(28, 28,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		fungi = new ImageIcon(newimg1);
		JLabel lbl = new JLabel(fungi);
		
		pan.add(lbl);
		frm.add(pan);
		frm.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runApp();
			}
		});
	}

}
