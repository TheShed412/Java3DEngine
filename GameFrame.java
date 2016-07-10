import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame
{
  public GameFrame()
  {
    super("Game Frame");
    setContentPane(new DrawPanel());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 600);
    setVisible(true);
  }//gameFrame
}//GameFrame
