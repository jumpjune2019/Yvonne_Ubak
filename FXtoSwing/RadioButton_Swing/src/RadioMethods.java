import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioMethods {
	//globals
	JLabel response;
	
	//createGUI
	void app() {
		//core setup
		JFrame frm = new JFrame("Radio Buttins Demo");
		JPanel pan = new JPanel();
//		JPanel bPan = new JPanel();
//		bPan.setLayout(new BoxLayout(bPan, BoxLayout.Y_AXIS));
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		
		//default fonts
		Font lblFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		Font btnFont = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
		
		//Labels
		JLabel title = new JLabel("Radio Buttons", JLabel.CENTER);
		title.setFont(lblFont);
		response = new JLabel("", JLabel.CENTER);
		response.setFont(lblFont);
		
		//Radio Buttons
		JRadioButton rbTrain = new JRadioButton("Train");
		rbTrain.setActionCommand("Train");
		rbTrain.setFont(btnFont);
		rbTrain.addActionListener(click);
		JRadioButton rbCar = new JRadioButton("Car");
		rbCar.setActionCommand("Car");
		rbCar.setFont(btnFont);
		rbCar.addActionListener(click);
		JRadioButton rbPlane = new JRadioButton("Plane");
		rbPlane.setActionCommand("Plane");
		rbPlane.setFont(btnFont);
		rbPlane.addActionListener(click);
		JRadioButton rbBoat = new JRadioButton("Boat");
		rbBoat.setActionCommand("Boat");
		rbBoat.setFont(btnFont);
		rbBoat.addActionListener(click);
		
		//toggle group
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rbTrain);
		btnGroup.add(rbCar);
		btnGroup.add(rbPlane);
		btnGroup.add(rbBoat);
		
		//add components
		pan.add(title);
		pan.add(rbTrain);
		pan.add(rbCar);
		pan.add(rbPlane);
		pan.add(rbBoat);
		pan.add(response);
		frm.add(pan);
		frm.setSize(300, 250);
		frm.setVisible(true);	
		
	}
	
	//error handlers
	ActionListener click = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			response.setText(e.getActionCommand());
		}
	};
	
}
