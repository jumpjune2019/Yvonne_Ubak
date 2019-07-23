package gridlayoutchallenge;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridMethods {
	//globals
	JFrame frm;
	JPanel pan;
	JPanel cellPan;
	JPanel centerPan;
	JLabel introLbl;
	static JLabel selectedLbl;
	static JLabel seatLbl;
	JButton[] seatBtn;
	
	//function to get random rows and columns
	RandFunc setMatrix = (min, max) -> {
		Random r = new Random();
		int rVal;

		rVal = r.nextInt((max-min) + 1) + min;

		return  rVal;
	};
	
	//event listeners
	ActionListener selectSeat = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String l = e.getActionCommand();
			//selectedLbl.setText(l + " selected");
			//selectedLbl.setText(Integer.toString(x));
			selectedLbl.setText(l + " selected");
		}
	};
	
	//create swing app
	FrameFunc createFrame = (jfrm, title, jpan, cpan, intro, lbl, cell) ->{
		//outer frame and panel
		jfrm = new JFrame(title);
		jpan = new JPanel();
		BorderLayout blayout = new BorderLayout();
		jpan.setLayout(blayout);
		jfrm.setLocationRelativeTo(null);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//top region
		introLbl = new JLabel(intro);
		introLbl.setHorizontalAlignment(JLabel.CENTER);
		introLbl.setVerticalAlignment(JLabel.CENTER);
		
		//bottom region
		selectedLbl = new JLabel(lbl);
		selectedLbl.setHorizontalAlignment(JLabel.CENTER);
		selectedLbl.setVerticalAlignment(JLabel.CENTER);
		
		//center region
		cpan = new JPanel();
		int row = setMatrix.rcval(2, 5);	//generate rows
		int col = setMatrix.rcval(2, 5);	//generate columns
		int rc = row*col;
		//System.out.println(row);
		//System.out.println(col);
		
		//the center region will contain a panel with a gridlayout
		GridLayout glayout = new GridLayout(row, col);
		cpan.setLayout(glayout);
		
			//cell settings
			char x = 'A';
			int seat = 1;
			seatBtn = new JButton[rc];		//array to hold buttons
			for(int r = 0; r < rc; r++) {
				//Increments letter for each new row and resets seat number
				if(r == col || r == col*2 || r == col*3 || r == col*4) {
					x++;
					seat =1;
				}
				seatLbl = new JLabel(x + "-" + seat);
				seatBtn[r] = new JButton(x + "-" + seat);
				
				//create inner cell layout
				cell = new JPanel();
				BoxLayout bxlayout = new BoxLayout(cell, BoxLayout.Y_AXIS);
				cell.setLayout(bxlayout);
				cell.setSize(new Dimension(50, 50));
				cell.add(seatLbl);
				cell.add(seatBtn[r]);	//adds buttons in the JButton array
				seatBtn[r].addActionListener(selectSeat);	//on click event for each button
				cpan.add(cell);
				seat++;	//increment seat number
				
				//add label to array
				//strlbl[r] = seatLbl.getText();
			}
		
		//add elements
		jfrm.setSize(new Dimension(500, (row * 50) + 80));
		jfrm.add(jpan);
		jpan.add(introLbl, BorderLayout.NORTH);
		jpan.add(selectedLbl, BorderLayout.SOUTH);
		jpan.add(cpan, BorderLayout.CENTER);
		jfrm.setVisible(true);
		
	};
	
	void invokeApp() {
		createFrame.app(frm, "GridLayout Challenge", pan, centerPan, "Basic Matrix Demo", 
				"No seat selected", cellPan);
	}
	

}
