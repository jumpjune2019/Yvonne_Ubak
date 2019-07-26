package test3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("HelloWorldSwing");
    //final JLabel label = new JLabel("Hello World");
   // frame.getContentPane().add(label);
	JButton jbtnUp = new JButton("Say Hello World");
	frame.add(jbtnUp);

	jbtnUp.addActionListener(ae -> 	{
		if(ae.getActionCommand().equals("Say Hello World")) 
		System.out.println("Hello World");

});
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}


