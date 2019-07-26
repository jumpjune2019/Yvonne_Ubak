import java.awt.FlowLayout;  
import java.awt.event.ItemEvent;  
import java.awt.event.ItemListener;  
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;  
  
public class JToggleButtonExample extends JFrame implements ItemListener {  

	JLabel jlab = new JLabel();
	JLabel jlab2 = new JLabel();
	
	public static void main(String[] args) {  
        new JToggleButtonExample();  
    }  
    private JToggleButton button;  
    JToggleButtonExample() {  
        setTitle("Toggle Button Demo");  
        setLayout(new FlowLayout());  
        setJToggleButton();  
        setAction();  
        setSize(200, 200);  
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
    private void setJToggleButton() {  
        button = new JToggleButton("ON");  
        jlab2 = new JLabel("Push a button");

        add(button);  
        add(jlab2);    
        add(jlab);
    }  
    private void setAction() {  
        button.addItemListener(this);  
    }  
    public void itemStateChanged(ItemEvent eve) {  
        if (button.isSelected())  
            jlab.setText("Button is OFF");  
        else  
            jlab.setText("Button is ON");  
    }  
}  
