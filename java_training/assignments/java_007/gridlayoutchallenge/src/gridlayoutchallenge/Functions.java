package gridlayoutchallenge;

import javax.swing.JFrame;
import javax.swing.JPanel;

interface RandFunc {
	int rcval(int min, int max);
}

interface FrameFunc {
	void app(JFrame jfrm, String title, JPanel jpan, JPanel cpan, String intro,
			String lbl, JPanel cell);
}