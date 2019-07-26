import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	//globals
	static JLabel lbl;
	
	//event handlers
	static ActionListener click = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			lbl.setText(e.getActionCommand() + " was pressed.");
		}
	};

	public static void main(String[] args) {
		//core setup
		JFrame frm = new JFrame("JavaFX Buttons, Events and Alignment");
		JPanel pan = new JPanel();
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		
		//Components
		JButton aBtn = new JButton("Alpha");
		aBtn.addActionListener(click);
		JButton bBtn = new JButton("Beta");
		bBtn.addActionListener(click);
		lbl = new JLabel("Push a Button!");
		
		//add components
		pan.add(aBtn);
		pan.add(bBtn);
		pan.add(lbl);
		frm.add(pan);
		frm.setVisible(true);
	}

}
