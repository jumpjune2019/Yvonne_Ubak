package preterm_v04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

public class GuiMethods {
	//globals
	JFrame frm;
	JPanel pan;
	JPanel topPan;
	JPanel centerPan;
	JPanel buttonPan;
	JPanel clientPanel;
	JLabel titleLbl;
	JLabel deetsLbl;
	JLabel fillerlbl;
	ImageIcon chair;
	JButton resetBtn;
	JButton printBtn;
	DefaultListModel<String> listModel;
	JList<String> clientList;
	JScrollPane scrlPan;
	JPanel seatPanel;
	JPanel cell;
	JButton[] seatBtn;
	JLabel[] seatLbl;
	JLabel[] iconLbl;
	JLabel rowName;
	String idx = " ";
	int uID;
	int rowVal = 0;
	int colVal = 0;
	String cidx;
	ClientStorage cStore;
	Client[] data;
	RoomStorage rmStore = new RoomStorage();
	Room[][] rmData;
	
//event handlers
	//press book or unbook button
	ActionListener bookClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				cidx = Integer.toString(clientList.getSelectedIndex()+1) + " ";		//client ID converted to String
				idx = cidx.substring(0, 2).trim();									//trim it
				cStore = new ClientStorage("src/resources/clients.csv");
				data = cStore.getClientData.storage();
				int btnVal = Integer.valueOf(e.getActionCommand());					//retrieve stored button value
				int rowNum; 
				int c1;

				rmData = rmStore.getRoom.storage();
				//cycle through clients
				for(Client c : data) {
					uID = c.getID();
					//booking a client
					if(seatBtn[btnVal].getText() == "book") {
						String initials = c.getInititals();									
						String fullname = c.getFullClient();
						String rowLtr = Character.toString(Labels.getRow(btnVal));
						c1 = Labels.getSeatNumber(btnVal);
						String colNum = Integer.toString(c1);
						rowNum = Labels.getRowNum(Labels.getRow(btnVal));
						String tid = clientList.getSelectedValue().substring(0,2).trim();	//retrieve client id of selected item
						int trueID = Integer.valueOf(tid);									
						if(uID == trueID) {		//if user ID is equal to the selected id
							//store seat data
							Room seatBooking = new Room(uID, fullname, initials, rowLtr, colNum, true);
							rmStore.rm.add(seatBooking, rowNum, (c1-1));
							//remove from list
							int listidx = clientList.getSelectedIndex();
							listModel.remove(listidx);
							//create red seat icon
							selectedSeat();
							//edit labels and button
							seatLbl[btnVal].setText("id: " + trueID + "/" + initials);
							seatLbl[btnVal].setForeground(Color.WHITE);
							iconLbl[btnVal].setIcon(chair);
							seatBtn[btnVal].setText("unbook");
							seatBtn[btnVal].setForeground(Color.PINK);
							break;
						}

					}else if(seatBtn[btnVal].getText() == "unbook") {
						//store full name and ids from label
						rowNum = Labels.getRowNum(Labels.getRow(btnVal));
						c1 = Labels.getSeatNumber(btnVal);
						int colNum = c1-1;
						Room r = rmData[rowNum][colNum];
						int listID = (r.getID());			//retrieve stored user id
						String listName = (listID) + " " + r.getFullName();	//retrieve saved client name
						//add back to list
						listModel.addElement(listName);
						//remove from storage
						rmStore.clearSeat.remove(rowNum, colNum);
						//create blank seat
						blankSeat();
						//edit button and label
						seatLbl[btnVal].setText("vacant");
						seatLbl[btnVal].setForeground(Color.RED);
						iconLbl[btnVal].setIcon(chair);
						seatBtn[btnVal].setText("book");
						seatBtn[btnVal].setForeground(Color.WHITE);
						break;						
					}
				}
			}catch(NullPointerException ne) {
				JOptionPane.showMessageDialog(frm, "Please select a client to book.");
				//ne.printStackTrace();
			}
		}
	};
	
	//press reset button
	ActionListener resetAll = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//reset and reload the Client list
			listModel.removeAllElements();
			createList();
			//reset seat matrix
			factorySeat();
			//clear room storage
			for(int r =0; r<10; r++) {
				for(int c = 0; c<10;c++) {
					rmStore.clearSeat.remove(r, c);
				}
			}
		}
	};
	
	//press print button
	ActionListener printSeats = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try{
				//labels
				System.out.println("\nThis is client list and their seating assignments");
				System.out.printf("%30s %5s %12s", "Client", "ID", "Seat\n");
				//clients and seats
				for(int rowP = 0; rowP < 10; rowP++) {
					Room r;
					for(int columnP = 0; columnP < 10; columnP++) {
						r = rmData[rowP][columnP];

						if(r != null) {
							String clientInfo = r.getFullName();
							int clientID = r.getID();
							String clientSeat = r.getSeat();
							System.out.printf("%30s %5d %10s", clientInfo, clientID, clientSeat);
							System.out.println();
						}
						else {
							continue;
						}
					}
				}
			}catch(NullPointerException ne) {
				JOptionPane.showMessageDialog(frm, "There are no seats booked in this room.");
			}
		}
	};
	
	void createList() {
		cStore = new ClientStorage("src/resources/clients.csv");
		data = cStore.getClientData.storage();
		for(Client c : data) {
			if(c != null) {
				String uName = c.getFullClient();
				int uID = c.getID();
				listModel.addElement(uID+ " " +uName);
			}
		}
	}
	
	void factorySeat() {
		//create blank seat
		blankSeat();
		//reset all components
		for(int r = 0; r < 100; r++) {
			seatLbl[r].setText("vacant");
			seatLbl[r].setForeground(Color.RED);
			iconLbl[r].setIcon(chair);
			seatBtn[r].setText("book");
			seatBtn[r].setForeground(Color.WHITE);
		}
	}
	
	void blankSeat() {
		//icon settings
		chair = new ImageIcon("src/resources/seat.png");
		Image img = chair.getImage();		//transform it
		Image newimg = img.getScaledInstance(15,15, Image.SCALE_SMOOTH); //scale
		chair = new ImageIcon(newimg);	//transform back
	}
	
	void selectedSeat() {
		//icon settings
		chair = new ImageIcon("src/resources/redseat.png");
		Image img = chair.getImage();		//transform it
		Image newimg = img.getScaledInstance(15,15, Image.SCALE_SMOOTH); //scale
		chair = new ImageIcon(newimg);	//transform back
	}
	
	//create app
	GuiFunc createGUI = (appTitle, title, reset, print, deets) -> {
		//core setup
		frm = new JFrame(appTitle);
		pan = new JPanel(new BorderLayout());
		centerPan = new JPanel(new FlowLayout());
		topPan = new JPanel();
		buttonPan = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 5));
		clientPanel = new JPanel();
		BoxLayout bxlay = new BoxLayout(clientPanel, BoxLayout.Y_AXIS);
		BoxLayout toplay = new BoxLayout(topPan, BoxLayout.Y_AXIS);
		clientPanel.setLayout(bxlay);
		topPan.setLayout(toplay);
		seatPanel = new JPanel(new GridLayout(11 ,11));
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//top region - titles
		titleLbl = new JLabel(title);
		titleLbl.setHorizontalAlignment(JLabel.CENTER);
		titleLbl.setVerticalAlignment(JLabel.CENTER);
		deetsLbl = new JLabel(deets);
		deetsLbl.setHorizontalAlignment(JLabel.CENTER);
		deetsLbl.setVerticalAlignment(JLabel.CENTER);
		
		//bottom region - buttons
		resetBtn = new JButton(reset);
		printBtn = new JButton(print);
		
		//left region
			//list of clients
				//create model and and its elements
			listModel = new DefaultListModel<>();
				//create list
			clientList = new JList<>(listModel);
			clientList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			createList();	
			
		//center region
			//seating matrix
				//cell settings
				char x = 'A';
				int seatNum =1;
				int newRow = 10;
				rowName = new JLabel(" ");
				seatPanel.add(rowName);
				seatLbl = new JLabel[10*10];
				seatBtn = new JButton[10*10];
				iconLbl = new JLabel[100];
				
				//icon settings
				blankSeat();
				
				//add column names
				for(int s = 0; s < 10; s++){
					JLabel colNames = new JLabel("Seat " + seatNum);
					seatPanel.add(colNames);
					colNames.setForeground(Color.ORANGE);
					seatNum++;
				}

				rowName = new JLabel("Row " + x);
				seatPanel.add(rowName);
				rowName.setForeground(Color.ORANGE);
				
				for(int r = 0; r < 100; r++) {
					//Increments letter for each new row and resets seat number
					if(r == newRow) {
						x++;
						newRow = newRow + 10;
						rowName = new JLabel("Row " + x);
						seatPanel.add(rowName);
						rowName.setForeground(Color.ORANGE);
					}
					seatLbl[r] = new JLabel("vacant");
					iconLbl[r] = new JLabel(chair);
					seatBtn[r] = new JButton("book");
					
					//css
						//labels
					seatLbl[r].setPreferredSize(new Dimension(70, 15));
					seatLbl[r].setForeground(Color.RED);
					seatLbl[r].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
					seatLbl[r].setAlignmentX(Component.CENTER_ALIGNMENT);
					iconLbl[r].setAlignmentX(Component.CENTER_ALIGNMENT);
					seatBtn[r].setAlignmentX(JLabel.CENTER_ALIGNMENT);
						//buttons
					seatBtn[r].setPreferredSize(new Dimension(80, 20));
					seatBtn[r].setBackground(Color.DARK_GRAY);
					seatBtn[r].setForeground(Color.WHITE);
					seatBtn[r].setBorder(BorderFactory.createCompoundBorder(
											BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
											BorderFactory.createEmptyBorder(7, 10, 10 ,10)));
					seatBtn[r].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
					

					//create inner cell layout
					cell = new JPanel();
					BoxLayout bxlayout = new BoxLayout(cell, BoxLayout.Y_AXIS);
					cell.setLayout(bxlayout);
					cell.add(seatLbl[r]);
					cell.add(iconLbl[r]);
					cell.add(seatBtn[r]);
					cell.setBackground(Color.darkGray);
					//button settings
					seatBtn[r].addActionListener(bookClick);	
					String btnNum = Integer.toString(r);
					seatBtn[r].setActionCommand(btnNum);
					
					seatPanel.add(cell);
				}
		//reset button
		resetBtn.addActionListener(resetAll);
		//print button		
		printBtn.addActionListener(printSeats);
		
		fillerlbl = new JLabel();
		fillerlbl.setPreferredSize(new Dimension(200, 50));
		
		//arrange components and show
		scrlPan = new JScrollPane(clientList);
		scrlPan.setPreferredSize(new Dimension(175, 400));
		topPan.add(titleLbl);
		topPan.add(deetsLbl);
		clientPanel.add(fillerlbl);
		clientPanel.add(scrlPan);
		centerPan.add(seatPanel);
		buttonPan.add(resetBtn);
		buttonPan.add(printBtn);
		pan.add(topPan, BorderLayout.NORTH);
		pan.add(clientPanel, BorderLayout.WEST);
		pan.add(centerPan, BorderLayout.CENTER);
		pan.add(buttonPan, BorderLayout.SOUTH);
		frm.add(pan);
		GuiCSS();
		frm.setVisible(true);
		
	};
	
	void GuiCSS(){
		//top area
		topPan.setBackground(Color.DARK_GRAY);
		titleLbl.setForeground(Color.WHITE);
		titleLbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 23));
		deetsLbl.setForeground(Color.ORANGE);
		deetsLbl.setFont(new Font(Font.SERIF, Font.BOLD, 15));
		
		//center area
		centerPan.setBackground(Color.darkGray);
		seatPanel.setBackground(Color.darkGray);
		
		//bottom area
		buttonPan.setBackground(Color.darkGray);
		resetBtn.setBackground(Color.RED);
		printBtn.setBackground(Color.ORANGE);
		
		//left area
		clientPanel.setBackground(Color.DARK_GRAY);
		clientList.setBackground(Color.ORANGE);
	}
	
}
