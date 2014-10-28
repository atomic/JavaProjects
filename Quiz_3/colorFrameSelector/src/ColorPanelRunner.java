import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;


public class ColorPanelRunner
{
   /**       Creates and displays the application frame.    */    public static void main(String[] args) 
   {
      ColorFrame frame = new ColorFrame();
      frame.setSize(400, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

