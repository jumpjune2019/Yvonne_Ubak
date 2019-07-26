import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class Methods {
	//globals
	JLabel titleL;
	JLabel allTargets;
	JLabel response;
	JCheckBox cbWeb;
	JCheckBox cbDesktop;
	JCheckBox cbMobile;	
	
	//event handler
	ItemListener il = new ItemListener() {
		public void itemStateChanged(ItemEvent ie) {
			StateFunc isc = (i) -> {
				JCheckBox cb = (JCheckBox) i.getItem();
				response.setText("Clicked: " + cb.getActionCommand());
				String stuff = "";
				int count = 0;

				if(cbWeb.isSelected()) {
					stuff += cbWeb.getText();
					count++;
				}

				if(cbDesktop.isSelected()) {
					if(count > 0) {
						stuff += ", ";
					}
					stuff += cbDesktop.getText();
					count++;
				}

				if(cbMobile.isSelected()) {
					if(count > 0) {
						stuff += ", ";
					}
					stuff += cbMobile.getText();
					count++;
				}

				if(count > 0) {
					allTargets.setText(stuff);	
				} else {
					allTargets.setText("<none>");
				}

			};
			isc.click(ie);
		}
	};
	
	//create GUI
	GUIFunc gui = (jfrm, title, lt, r, t, w, d, m)-> {
		//create root
		jfrm = new JFrame(title);
		Box vb = Box.createVerticalBox();
		jfrm.setSize(new Dimension(100,180));
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setLocationRelativeTo(null);
		
		//labels
		titleL = new JLabel(lt);
		response = new JLabel(r);
		allTargets = new JLabel(t);
		
		//checkboxes
		cbWeb = new JCheckBox(w);
		cbWeb.setActionCommand(w);
		cbWeb.addItemListener(il);
		cbDesktop = new JCheckBox(d);
		cbDesktop.setActionCommand(d);
		cbDesktop.addItemListener(il);
		cbMobile = new JCheckBox(m);
		cbMobile.setActionCommand(m);
		cbMobile.addItemListener(il);
		
		//add elements
		vb.add(titleL);
		vb.add(cbWeb);
		vb.add(cbDesktop);
		vb.add(cbMobile);
		vb.add(response);
		vb.add(allTargets);
		jfrm.add(vb);
		jfrm.setVisible(true);
	};
	
}
