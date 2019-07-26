// Demonstrate a simple JList.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
class ListDemo implements ListSelectionListener {
	JLabel jlab,jlab1;
	JScrollPane jscrlp;
	// Create an array of names.
	DefaultListModel listModel;
	
	ListDemo() {
		// Create a new JFrame container.
		JFrame jfrm = new JFrame("JList Demo");
		
		Container container = jfrm.getContentPane();
	    container.add(new JLabel("Select Transport Type"), BorderLayout.PAGE_START);
		
		
		// Specify a flow Layout.
		jfrm.setLayout(new FlowLayout());
		// Give the frame an initial size.
		jfrm.setSize(200, 160);
		// Terminate the program when the user closes the application.
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create a JList.

		listModel = new DefaultListModel();
		listModel.addElement("Train");
        listModel.addElement("Car");
        JList list = new JList(listModel);
        listModel.addElement("Airplane");
		jscrlp = new JScrollPane(list);
		
		// Set the preferred size of the scroll pane.
		jscrlp.setPreferredSize(new Dimension(120, 90));
		// Make a label that displays the selection.
		jlab = new JLabel("Nothing clicked");
		// Add list selection handler.
		list.addListSelectionListener(le -> {
			// Get the index of the changed item.
			int idx = list.getSelectedIndex();
			// Display selection, if item was selected.
		
			//listModel.			
			if(idx != -1) {
				jlab.setText("Transport selected is " + list.getSelectedValue());
			    int previous = idx == le.getFirstIndex() ? le.getLastIndex() : le.getFirstIndex();
			   
			    System.out.println("What used to be selected was " + listModel.elementAt(previous));

			} else {
				// Otherwise, reprompt.
				jlab.setText("Nothing clicked.");
			}
		});
		
		
		JButton add = new JButton("Add an item");
		JButton remove = new JButton("Remove first item");
		
		add.addActionListener(ae -> 	{
			if(ae.getActionCommand().equals("Add an item")) {
			listModel.addElement("null");
		} 
	
});
		
		remove.addActionListener(ae -> 	{
			if(ae.getActionCommand().equals("Remove first item")) {
			listModel.remove(0);
		} 
	
});	
		
		
		// Add the list and label to the content pane.
		jfrm.add(jscrlp);
		jfrm.add(jlab);
		jfrm.add(add);
		jfrm.add(remove);
		// Display the frame.
		jfrm.setVisible(true);
	}


	public static void main(String args[]) {
		// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ListDemo();
			}
		});
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}