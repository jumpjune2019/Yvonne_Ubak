import javax.swing.JFrame;

interface SettingsFunc {
	JFrame setFrameStuff(JFrame frm, int onExit, String label);
}

interface FrameFunc{
	JFrame getFrame();
}

interface PositionFunc{
	void centerAndSizeJFrameOnScreen(JFrame frm);
}
