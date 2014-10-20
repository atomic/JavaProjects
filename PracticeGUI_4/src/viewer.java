import javax.swing.JFrame;

public class viewer
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(300,400);
        frame.setTitle("Square Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comp J = new comp();
        frame.add(J);

        frame.setVisible(true);
    }
}
