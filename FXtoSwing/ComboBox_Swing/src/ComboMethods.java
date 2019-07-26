import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class ComboMethods {
	//globals
	JLabel response;
	JLabel lTitle;
	JPanel pan;
	JSeparator sp = new JSeparator();
	JComboBox<String> cbTransport;
	
	//event handler
	ActionListener click = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			response.setText("Selected: " + cbTransport.getSelectedItem());
		}
		
	};
	
	//create GUI
	GUIFunc gui = (jfrm, title, lbl) -> {
		//create root
		jfrm = new JFrame(title);
		pan = new JPanel();
		pan.setLayout(new BorderLayout());
		jfrm.setSize(200, 100);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setLocationRelativeTo(null);
		
		//label
		lTitle = new JLabel(lbl);
		response = new JLabel("");
		lTitle.setHorizontalAlignment(JLabel.CENTER);
		lTitle.setVerticalAlignment(JLabel.CENTER);
		lTitle.setPreferredSize(new Dimension(200, 25));
		response.setHorizontalAlignment(JLabel.CENTER);
		response.setVerticalAlignment(JLabel.CENTER);
		response.setPreferredSize(new Dimension(200, 20));
		
		//combobox
		String[] modes = new String[] {"Train", "Car", "Airplane"};
		cbTransport = new JComboBox<String>(modes);
		cbTransport.addActionListener(click);
		cbTransport.setPreferredSize(new Dimension(200, 20));
		
		//add elements
		jfrm.add(pan);
		pan.add(lTitle, BorderLayout.NORTH);
		pan.add(cbTransport, BorderLayout.CENTER);
		pan.add(response, BorderLayout.SOUTH);	
		jfrm.setVisible(true);

	};
	
}
