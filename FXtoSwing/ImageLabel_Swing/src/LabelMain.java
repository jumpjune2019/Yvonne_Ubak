import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LabelMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runApp();
			}
		});
	}
	
	static void runApp() {
		JFrame frm = new JFrame("Use a Image in a Label");
		JPanel pan = new JPanel();
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(320, 80);
		
		//load image
		ImageIcon icon = new ImageIcon("src/fungi.png");
		Image img = icon.getImage();
		Image nImg = img.getScaledInstance(28, 28,  java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(nImg);
		//Label and Button
		JLabel lblImg = new JLabel("Fungi", icon, JLabel.LEFT);
		JButton btnImg = new JButton("Fungi", icon);
		lblImg.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 32));
		
		//add components
		pan.add(lblImg);
		pan.add(btnImg);
		//frm.pack();
		frm.add(pan);
		frm.setVisible(true);
	}

}
