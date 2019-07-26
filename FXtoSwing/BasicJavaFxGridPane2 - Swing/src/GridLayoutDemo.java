import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;

class GridLayoutDemo
{

  public void buildGUI()
  {
    JPanel p = new JPanel(new GridLayout(2,3));
    JLabel[] labels = new JLabel[6];
   int m;
    for(int x = 0, y = labels.length; x < y; x++)
    {
      m=x;
      m++;
      
      String s="Button";
      String w=Integer.toString(m);
      String s3=s.concat(w);
      
      JButton insideButton = new JButton(s3);
      
      labels[x] = new JLabel();
      labels[x].setOpaque(true);
      labels[x].setHorizontalAlignment(JLabel.CENTER);
      labels[x].setVerticalAlignment(JLabel.CENTER);

      labels[x].setText(labels[x].getText()+"Label "+m);
      
      labels[x].setLayout(new FlowLayout(FlowLayout.CENTER));
      labels[x].add(insideButton);
      p.add(labels[x]);
   	
    }
    JFrame f = new JFrame("GridLayout Demo");
    f.getContentPane().add(p);
    f.setSize(500,500);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    
    Container container = f.getContentPane();
    container.add(new JLabel("Push a Button"), BorderLayout.PAGE_START);

  }
  public static void main(String[] args){new GridLayoutDemo().buildGUI();}
}
