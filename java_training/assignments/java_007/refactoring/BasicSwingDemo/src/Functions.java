import javax.swing.JFrame;

interface SettingsFunc {
	JFrame setFrameStuff(JFrame frm, int width, int height, int onExit, String label);
}

interface FrameFunc{
	JFrame getFrame();
}
