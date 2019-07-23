package headortail_GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

class CoinDetails {
	//globals
	JLabel lbl;
	JButton resetBtn;
		//Event listeners
			//flip coin when press button
			ActionListener clickToFlip = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int coin = flipCoin();	//flip for value
					String result = coinFace(coin);			//get face name
		
					lbl.setText("The coin is " + result);
					resetBtn.setEnabled(true);
				}
			};
			//reset label when clicked
			ActionListener resetLbl = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lbl.setText("waiting...");
					resetBtn.setEnabled(false);
					
				}
			};

	//toss coin
	int flipCoin() {
		//lambda function to toss coin
		FlipFunc toss = (min, max) -> {
			Random r = new Random();		//Random object
			int rVal;

			//calculate random value within an inclusive range
			rVal = r.nextInt((max-min) + 1) + min;

			return  rVal;
		};
		return toss.func(1, 2);
	}

	//give face value
	String coinFace(int f) {
		//lambda function to spit out heads or tails
		HTFunc face = (v) -> {
			String ht = "";

			if( v == 1) {
				ht = "Heads";
			}else if(v == 2) {
				ht = "Tails";
			}

			return ht;
		};
		return face.func(f);
	}

	//create GUI
	GUIFunc app = (title, lt, b1, b2) -> {
		//create components
		JFrame frame = new JFrame(title);
		JPanel mainPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		JPanel lblPanel = new JPanel();
		lbl = new JLabel(lt);
		JButton flipBtn = new JButton(b1);
		resetBtn = new JButton(b2);

		//settings
		btnPanel.setLayout(new FlowLayout());
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		frame.add(mainPanel);
		mainPanel.add(btnPanel);
		mainPanel.add(lblPanel);
		btnPanel.add(flipBtn);
		btnPanel.add(resetBtn);
		lblPanel.add(lbl);
		frame.setSize(200, 150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.pack();
		flipBtn.addActionListener(clickToFlip);
		resetBtn.addActionListener(resetLbl);
		
		//enables or disables reset button
			if(lt.contains("waiting")) {
				resetBtn.setEnabled(false);
			}
			else {
				resetBtn.setEnabled(true);
			}
		
	};

}
