import java.awt.event.ItemEvent;

import javax.swing.JFrame;

interface WindowFunc {
	void app(JFrame jfrm, String title, String a, String b, String g);
}

interface StateFunc{
	void click(ItemEvent i);
}