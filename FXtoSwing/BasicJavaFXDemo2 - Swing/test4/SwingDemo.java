package test4;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("2 Buttons and a Label");
 
    JLabel label = new JLabel();
    label.setBounds(50,50,150,20);  

    JButton jbtnUp = new JButton("Say Hello World");
   	JButton reset = new JButton("Reset");
   
   	jbtnUp.setBounds(200,150,95,30);  
	reset.setBounds(50,150,95,30);
	
	frame.add(jbtnUp);
	frame.add(reset);
	frame.add(label);
 	
	jbtnUp.addActionListener(ae -> 	{
		if(ae.getActionCommand().equals("Say Hello World")) 
		label.setText("Hello World");

});
	
	reset.addActionListener(ae -> 	{
		if(ae.getActionCommand().equals("Reset")) 
		label.setText("");

});

	
    frame.setSize(400,400);  
    frame.setLayout(null);  
    frame.setVisible(true);
	// here's the part where the JFrame gets actually centered
	
		
    
 //   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 //   frame.pack();
 //   frame.setVisible(true);
  }
}


