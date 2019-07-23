import java.awt.event.ActionEvent;
import javax.swing.JFrame;

interface WindowFunc {
	void app(JFrame jfrm, String title, int tf, String tfcmd, String btn, String prompt);
}

interface OnClick {
	void click(ActionEvent e);
}