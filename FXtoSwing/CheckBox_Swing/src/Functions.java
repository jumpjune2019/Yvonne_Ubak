import java.awt.event.ItemEvent;

import javax.swing.JFrame;

interface GUIFunc {
	void app(JFrame jfrm, String title, String lt, String r, String t, String w, String d, String m);
}

interface StateFunc{
	void click(ItemEvent i);
}