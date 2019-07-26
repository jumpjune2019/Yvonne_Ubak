import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Image;
import java.awt.event.*;

public class ButtonDemo  implements ActionListener {
	JLabel jlab,jlab2;
	String first;
	String second;
	String firstMsg;
	String secondMsg;
	
	public void setButtons(JPanel frm, String f, String s, String sMsg, String fMsg) {
		first = f;
		second = s;
		firstMsg = fMsg;
		secondMsg = sMsg;
		
		ImageIcon dairy = new ImageIcon("dairy.png");
		Image image = dairy.getImage(); // transform it 
		Image newimg = image.getScaledInstance(28, 28,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		dairy = new ImageIcon(newimg);  // transform it back
		
		
		ImageIcon fungi = new ImageIcon("fungi.png");
		Image image1 = fungi.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(28, 28,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		fungi = new ImageIcon(newimg1);  // transform it back

		//JButton button = new JButton(water);
	    //frame.add(button);
//		JButton jbtnUp = new JButton("Dairy", dairy);
//		JButton jbtDown = new JButton("Fungi", fungi);

		
		JButton jbtnUp = new JButton(first, dairy);
		JButton jbtnDown = new JButton(second, fungi);
		JButton reset = new JButton("Reset");
		// Add action listeners.

		reset.addActionListener(l -> {
			if(l.getActionCommand().equals("Reset")) 
				jlab.setText("");
		});
		
		jbtnUp.addActionListener(ae -> 	{
			if(ae.getActionCommand().equals(first)) {
			jlab.setText(firstMsg);
		} else {
			jlab.setText(secondMsg);
		}
	
});

		jbtnDown.addActionListener(ae -> 	{
			if(ae.getActionCommand().equals(first)) {
			jlab.setText(firstMsg);
		} else {
			jlab.setText(secondMsg);
		}
		});
			// Add the buttons to the content pane.
		jlab2 = new JLabel("Push a button.");
		frm.add(jbtnUp);
		frm.add(jbtnDown);
		frm.add(reset);
		// Create a label.
		jlab = new JLabel("Push a button.");
		// Add the label to the frame.
		frm.add(jlab);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
