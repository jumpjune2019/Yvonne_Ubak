import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

interface SettingsFunc {
	JFrame setFrameStuff(JFrame frm, int onExit, int width, int height);
}

interface FrameFunc{
	JFrame getFrame();
}

interface PositionFunc{
	void centerAndSizeJFrameOnScreen(JFrame frm, int width, int height);
}

interface ButtonFunc{
	void setButtons(JPanel frm, String f, String s, String fMsg, String sMsg);
}

interface OnClick{
	void clickEv(ActionEvent e);
}
