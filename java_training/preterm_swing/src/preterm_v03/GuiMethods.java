package preterm_v03;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GuiMethods {
	//globals
	JFrame frm;
	JPanel pan;
	JPanel centerPan;
	JPanel buttonPan;
	JPanel clientPanel;
	JScrollPane scrlPan;
	JPanel seatPanel;
	JPanel cell;
	JButton[] seatBtn;
	static JLabel seatLbl;
	JLabel rowName;
	
	GuiFunc createGUI = (appTitle, title, reset, print) -> {
		//core setup
		frm = new JFrame(appTitle);
		pan = new JPanel(new BorderLayout());
		centerPan = new JPanel(new FlowLayout());
		buttonPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
		clientPanel = new JPanel(new FlowLayout());
		seatPanel = new JPanel(new GridLayout(11 ,11, 10, 10));
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
//		frm.setSize(new Dimension(500, 500));
		frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//top region - title
		JLabel titleLbl = new JLabel(title);
		titleLbl.setHorizontalAlignment(JLabel.CENTER);
		titleLbl.setVerticalAlignment(JLabel.CENTER);
		
		//bottom region - buttons
		JButton resetBtn = new JButton(reset);
		JButton printBtn = new JButton(print);
		
		//center region
			//list of clients
				//create model and and its elements
			DefaultListModel<String> listModel = new DefaultListModel<>();
				//create list
			JList<String> clientList = new JList<>(listModel);
			ClientStorage cStore = new ClientStorage("clients.csv");
			Client[] data = cStore.getClientData.storage();
				for(Client c : data) {
					if(c != null) {
						int uID = c.getID();
						String uName = c.getFullClient();
						String record = uID + " "+ uName;
						listModel.addElement(record);
					}
				}
			//seating matrix
				//cell settings
				char x = 'A';
				int seatNum =1;
				int newRow = 10;
				rowName = new JLabel(" ");
				seatPanel.add(rowName);
				seatBtn = new JButton[10*10];		//array to hold buttons
					//column labels
				//add column names
				for(int s = 0; s < 10; s++){
					JLabel colNames = new JLabel("Seat " + seatNum);
					seatPanel.add(colNames);
					seatNum++;
				}

				rowName = new JLabel("Row " + x);
				seatPanel.add(rowName);
				
				for(int r = 0; r < 100; r++) {
					//Increments letter for each new row and resets seat number
					if(r == newRow) {
						x++;
						newRow = newRow + 10;
						rowName = new JLabel("Row " + x);
						seatPanel.add(rowName);
					}
					seatLbl = new JLabel("vacant");
					seatBtn[r] = new JButton("book");
//					seatLbl = new JLabel(x + "-" + seat);
//					seatBtn[r] = new JButton(x + "-" + seat);
					
					//create inner cell layout
					cell = new JPanel();
					BoxLayout bxlayout = new BoxLayout(cell, BoxLayout.Y_AXIS);
					cell.setLayout(bxlayout);
					cell.setSize(new Dimension(50, 50));
					cell.add(seatLbl);
					cell.add(seatBtn[r]);	//adds buttons in the JButton array
					//seatBtn[r].addActionListener(selectSeat);	//on click event for each button
					seatPanel.add(cell);
				}
				
		
		//add components and show
		scrlPan = new JScrollPane(clientList);
		scrlPan.setPreferredSize(new Dimension(250, 400));
		clientPanel.add(scrlPan);
		centerPan.add(seatPanel);
		buttonPan.add(resetBtn);
		buttonPan.add(printBtn);
		pan.add(titleLbl, BorderLayout.NORTH);
		pan.add(clientPanel, BorderLayout.WEST);
		pan.add(centerPan, BorderLayout.CENTER);
		pan.add(buttonPan, BorderLayout.SOUTH);
		frm.add(pan);
		frm.setVisible(true);
		
	};
	
	
}
