import javax.swing.*;
public class MyLabel {
	private String position;

	MyLabel() {
		
	}
	
	LabelSet lblSet = (jF, jl) -> {
		jl.setHorizontalAlignment(JLabel.CENTER);
		jl.setVerticalAlignment(JLabel.CENTER);
		jF.add(jl, position);
	};
	
	LabelFunc lbl = (l, p, jf) -> {
		position = p;
		JLabel lb = new JLabel(l);
		lblSet.setLabelInLayout(jf, lb);
		return lb;
	};
}
