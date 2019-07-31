package preterm_v04;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		/*Scaffolding tbl = new Scaffolding();
		
		tbl.start();
		tbl.getInputandProcess();
		tbl.getOutput();
		tbl.end();*/
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GuiMethods gm = new GuiMethods();
				gm.createGUI.app("Seat Matrix Demo", "Toy Story 4", "Reset All", "Print Assigned Clients", 
						"Tower Plaza North | July 31, 2019 | 7PM");
			}
		});

	}

}
