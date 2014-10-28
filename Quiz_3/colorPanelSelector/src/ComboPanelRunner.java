import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class ComboPanelRunner
{
   /**       Creates and displays the application frame.    */    public static void main(String[] args) 
   {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 500);
      ComboPanel cp = new ComboPanel();
      frame.add(cp);
      frame.setVisible(true);
   }
}
