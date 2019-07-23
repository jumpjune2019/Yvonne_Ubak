import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;

interface WindowFunc {
	void app(JFrame jfrm, JScrollPane jscrlp);
}

interface ListSel {
	void sel(ListSelectionEvent l);
}