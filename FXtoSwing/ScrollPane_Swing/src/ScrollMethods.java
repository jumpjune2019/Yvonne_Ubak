import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollMethods {
	//globals
	JFrame frm;
	JScrollPane scrlPan = new JScrollPane();
	JPanel pan;
	JLabel response;
	
	//create GUI
	void app() {
		//core setup
		frm = new JFrame("ScrollPane Demo");
		pan = new JPanel();
		frm.setSize(350, 350);
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		
		//labels
		JLabel title = new JLabel("ScrollPane Demo");
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		String msg = "<html>A ScrollPane streamlines the process <br>" + 
				" of adding darn scroll bars to a window whose contents <br>" + 
				" exceed the viewing area dimension of the window <br> " + 
				" It also enables a control to fit in <br> " + 
				" Such as this label control in JavaFX <br> " + 
				" Without it, we could not really view well the content <br> " + 
				" of a control if it overflowed, so using scrollbars helps lots!</html>";
		response = new JLabel(msg);
		response.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		scrlPan = new JScrollPane(response);
		scrlPan.setPreferredSize(new Dimension(200, 100));
		
		//reset button
		JButton reset = new JButton("Reset Scroll Pane to Top/Left");
		reset.setActionCommand("Reset");
		reset.addActionListener(click);
		
		//add components
		pan.add(title);
		pan.add(scrlPan);
		pan.add(reset);
		frm.add(pan);
		frm.setVisible(true);		
	}
	
	//event handlers
	ActionListener click = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			scrlPan.getViewport().setViewPosition(new java.awt.Point(0,0));
		}
	};
	
}
