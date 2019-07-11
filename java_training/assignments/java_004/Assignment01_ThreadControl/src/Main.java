//import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main extends JFrame{

		//create window and contents
		static JFrame frame = new JFrame("Thread Control Project");
		static JPanel panel = new JPanel();
		static final JTextField writeArea = new JTextField();
		static final JTextArea displayArea = new JTextArea();
		static BoxLayout bl = new BoxLayout(panel, BoxLayout.Y_AXIS);
		static Thread1 currentThread;
		
	public static void main(String[] args) {		
		//setup window
		frame.add(panel);
		panel.add(writeArea);
		//frame.setPreferredSize(new Dimension(4000, 4000));
		displayArea.setPreferredSize(new Dimension(8000, 8000));
		panel.setLayout(bl);
		frame.setVisible(true);
	    displayArea.setEditable(false); // set textArea non-editable
	    JScrollPane scroll = new JScrollPane(displayArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    panel.add(scroll);
		
		//intro
		displayArea.setText("Welcome to this program.");
		displayArea.append("\nType an integer between 1-5 to take control of a thread");
		
		Thread1 t1 = new Thread1("Thread 1");	//thread 1 object
		Thread1 t2 = new Thread1("Thread 2");	//thread 2 object
		Thread1 t3 = new Thread1("Thread 3");	//thread 3 object
		Thread1 t4 = new Thread1("Thread 4");	//thread 4 object
		Thread1 t5 = new Thread1("Thread 5");	//thread 5 object
		
		try {
			//check for user input
			checkInput(t1, KeyEvent.VK_1, t2, t3, t4, t5);
			checkInput(t2, KeyEvent.VK_2, t1, t3, t4, t5);
			checkInput(t3, KeyEvent.VK_3, t1, t2, t4, t5);
			checkInput(t4, KeyEvent.VK_4, t1, t2, t3, t5);
			checkInput(t5, KeyEvent.VK_5, t1, t2, t3, t4);
		}
		catch(Exception e) {
			System.out.println("Thread interrupted");
		}
		

	}
	
	public static void displayInfo(String msg) {
		displayArea.append("\n\n" + msg);
	}
	
	public static void checkInput(Thread1 obj, int k, Thread1 o1, Thread1 o2, Thread1 o3, Thread1 o4) {
		writeArea.addKeyListener(new KeyListener() {

	          @Override
	          public void keyTyped(KeyEvent e) {}

	          @Override
	          public void keyReleased(KeyEvent e) {}

	          @Override
	          public void keyPressed(KeyEvent e) {
	        	  
	        	//pause and resume thread  
	            if(e.getKeyCode() == k) {
	            	currentThread = obj;
	            	if(obj.suspended == true) {
	            		obj.myresume();
	            	}
	            	else if(obj.suspended == false) {
	            		String msg1 = "Controlling " + obj.thrd.getName();
		            	displayInfo(msg1);
	            		obj.mypause();
	            		String msg2 = "Press 'S' to stop thread completely."
	            				+ "\n Press 'T' to give this thread Top Priority"
	            				+ "\n Press 'N' to give this thread Normal Priority"
	            				+ "\n Press 'L' to give this thread Low Priority";
		            	displayInfo(msg2);
	            	}
	            }
	            //stop thread
	            else if(e.getKeyCode() == KeyEvent.VK_S && obj.thrd.getName().equals(currentThread.thrd.getName())) {
	            		currentThread.mystop();
	        
          			//check available threads
          			if(!o1.stopped) {
          				displayInfo(o1.thrd.getName() + ": " + o1.thrd.getState());
          			}
          			if(!o2.stopped) {
          				displayInfo(o2.thrd.getName() + ": " + o2.thrd.getState());
          			}
          			if(!o3.stopped) {
          				displayInfo(o3.thrd.getName() + ": " + o3.thrd.getState());
          			}
          			if(!o4.stopped) {
          				displayInfo(o4.thrd.getName() + ": " + o4.thrd.getState());
          			}
          			if(o1.stopped && o2.stopped && o3.stopped && o4.stopped && currentThread.stopped) {
          				try {
          					displayInfo("This app is now exiting, all threads have been stopped");
							Thread.sleep(2000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
          				System.exit(0);
          			}
	            }	
          	//change priority
	            else if(e.getKeyCode() == KeyEvent.VK_T  && obj.thrd.getName().equals(currentThread.thrd.getName())) {
	            	 currentThread.thrd.setPriority(Thread.MAX_PRIORITY);
	            	 displayInfo("High Priority set");
	            }
	            else if(e.getKeyCode() == KeyEvent.VK_N  && obj.thrd.getName().equals(currentThread.thrd.getName())) {
	            	 currentThread.thrd.setPriority(Thread.MAX_PRIORITY);
	            	 displayInfo("Normal Priority set");
	            }
	            else if(e.getKeyCode() == KeyEvent.VK_L && obj.thrd.getName().equals(currentThread.thrd.getName())) {
	            	currentThread.thrd.setPriority(Thread.MAX_PRIORITY);
	            	 displayInfo("Low Priority set");
	            }
	          }
		});
	}
	

}
