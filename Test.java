import javax.swing.*;
import java.awt.*;

public class Test extends JFrame
{
  public Test()
  {
    super("Game Frame");
    setContentPane(new DrawPanel());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 600);
    setVisible(true);
  }//frame constructor

  class DrawPanel extends JPanel
  {
    public void paintComponent(Graphics g){
          //draw on g here e.g.
           g.fillRect(20, 20, 100, 200);
         }
  }

  public static void main(String[] args) throws NotInitializedException, Not3DPointException
  {
      new Test();
  }//main
}//test
