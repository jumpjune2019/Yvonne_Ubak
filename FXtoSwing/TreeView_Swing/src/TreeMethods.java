import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeMethods {
	//globals
	JFrame frm;
	JLabel lbl;
	
	
	//create GUI
	public void app() {
		//core setup
		frm = new JFrame("TreeView Demo");
		JPanel pan = new JPanel();
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		frm.setSize(850, 600);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		
		//labels
		JLabel title = new JLabel("TreeView Demo");
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		
		//TreeItems
		DefaultMutableTreeNode t1Root = new DefaultMutableTreeNode("Food");
		JTree tree = new JTree(t1Root);
		DefaultMutableTreeNode t1Fruit = new DefaultMutableTreeNode("Fruits");
		DefaultMutableTreeNode t1Apples = new DefaultMutableTreeNode("Apples");
		DefaultMutableTreeNode t2Pears = new DefaultMutableTreeNode("Pears");
		DefaultMutableTreeNode t2Oranges = new DefaultMutableTreeNode("Oranges");
		DefaultMutableTreeNode t3Fuji = new DefaultMutableTreeNode("Fuji");
		DefaultMutableTreeNode t3Winesap = new DefaultMutableTreeNode("Winesap");
		DefaultMutableTreeNode t3Clark = new DefaultMutableTreeNode("Clark");
		DefaultMutableTreeNode t1Veggies = new DefaultMutableTreeNode("Veggies");
		DefaultMutableTreeNode t2Corn = new DefaultMutableTreeNode("Corn");
		DefaultMutableTreeNode t2Peas = new DefaultMutableTreeNode("Peas");
		DefaultMutableTreeNode t2Broccoli = new DefaultMutableTreeNode("Broccoli");
		DefaultMutableTreeNode t2Beans = new DefaultMutableTreeNode("Beans");
		DefaultMutableTreeNode t1Nuts = new DefaultMutableTreeNode("Nuts");
		DefaultMutableTreeNode t2Walnuts = new DefaultMutableTreeNode("Walnuts");
		DefaultMutableTreeNode t2Almonds = new DefaultMutableTreeNode("Almonds");
		DefaultMutableTreeNode t2Pistachios = new DefaultMutableTreeNode("Pistachios");
		DefaultMutableTreeNode t2Cashews = new DefaultMutableTreeNode("Cashews");
		
		//add tree elements
		t1Root.add(t1Fruit);
		t1Fruit.add(t1Apples);
		t1Fruit.add(t2Pears);
		t1Fruit.add(t2Oranges);
		t1Apples.add(t3Fuji);
		t1Apples.add(t3Winesap);
		t1Apples.add(t3Clark);
		t1Root.add(t1Veggies);
		t1Veggies.add(t2Corn);
		t1Veggies.add(t2Peas);
		t1Veggies.add(t2Broccoli);
		t1Veggies.add(t2Beans);
		t1Root.add(t1Nuts);
		t1Nuts.add(t2Walnuts);
		t1Nuts.add(t2Almonds);
		t1Nuts.add(t2Pistachios);
		t1Nuts.add(t2Cashews);
		
		//add components and show
		pan.add(tree);
		frm.add(pan);
		frm.setVisible(true);
		
		
	}
	
}
