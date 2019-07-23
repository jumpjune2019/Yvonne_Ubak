package gridlayoutchallenge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class GridMain{

	GridMain(){
		GridMethods gm = new GridMethods();
		gm.invokeApp();
	}
	
	public static void main(String[] args) {
		//on event dispatching thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GridMain();
			}
		});

	}

}
