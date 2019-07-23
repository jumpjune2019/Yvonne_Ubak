import javax.swing.JFrame;
import javax.swing.JLabel;

interface SettingsFunc {
	JFrame setFrameStuff(JFrame frm, int onExit, int width, int height);
}

interface FrameFunc{
	JFrame getFrame();
}

interface PositionFunc{
	void centerAndSizeJFrameOnScreen(JFrame frm, int width, int height);
}

interface LabelFunc{
	JLabel setLabel(String l, String p, JFrame jf);
}

interface LabelSet{
	void setLabelInLayout(JFrame jF, JLabel jl);
}

interface toFrame{
	void setLabelsToFrame(JFrame frm);
}
