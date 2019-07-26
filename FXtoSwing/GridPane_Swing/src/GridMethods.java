import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridMethods {
	//globals
	JFrame frm;
	JPanel pan;
	JPanel grid;
	JLabel title;
	
	//create GUI
	void createGUI() {
		//core setup
		frm = new JFrame("GridLayout Demo");
		pan = new JPanel();
		grid = new JPanel();
		pan.setLayout(new BorderLayout());
		grid.setLayout(new GridLayout(2, 3, 10, 10));
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(new Dimension(200, 150));
		
		//label
		title = new JLabel("Push a Button");
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
		
		//deafult font
		Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
		
		//buttons
		JButton btn1 = new JButton("Button 1");
		JButton btn2 = new JButton("Button 2");
		JButton btn3 = new JButton("Button 3");
		JButton btn4 = new JButton("Button 4");
		JButton btn5 = new JButton("Button 5");
		JButton btn6 = new JButton("Button 6");
		btn1.setFont(f);
		btn2.setFont(f);
		btn3.setFont(f);
		btn4.setFont(f);
		btn5.setFont(f);
		btn6.setFont(f);
		
		//add buttons to grid
		grid.add(btn1);
		grid.add(btn2);
		grid.add(btn3);
		grid.add(btn4);
		grid.add(btn5);
		grid.add(btn6);
		
		//add everything
		pan.add(title, BorderLayout.NORTH);
		pan.add(grid, BorderLayout.CENTER);
		frm.add(pan);
		frm.setVisible(true);
		
	}
	
}
