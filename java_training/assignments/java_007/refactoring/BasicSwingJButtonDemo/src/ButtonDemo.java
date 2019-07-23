import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.*;

public class ButtonDemo  implements ActionListener {
	JLabel jlab;
	String first;
	String second;
	String firstMsg;
	String secondMsg;
	
	ButtonFunc btnSettings = (frm, f, s, fMsg, sMsg) -> {
		first = f;
		second = s;
		firstMsg = fMsg;
		secondMsg = sMsg;
		
		JButton jbtnUp = new JButton(first);
		JButton jbtnDown = new JButton(second);
		// Add action listeners.
		jbtnUp.addActionListener(this);
		jbtnDown.addActionListener(this);
		// Add the buttons to the content pane.
		frm.add(jbtnUp);
		frm.add(jbtnDown);
		// Create a label.
		jlab = new JLabel("Press a button.");
		// Add the label to the frame.
		frm.add(jlab);
	};
	
	// Handle button events.

	public void actionPerformed(ActionEvent ae) {
		OnClick oc = (e) -> {
			if(e.getActionCommand().equals(first)) {
				jlab.setText(firstMsg);
			} else {
				jlab.setText(secondMsg);
			}
		};
		oc.clickEv(ae);
	}
}
