import java.awt.event.ActionEvent;

import javax.swing.JFrame;

interface WindowFunc {
	void app(JFrame jfrm, String title, int w, int h,int tf, 
			String first, String second, String btn, String lblF, String lblS);
}

interface OnClick {
	void click(ActionEvent e);
}
