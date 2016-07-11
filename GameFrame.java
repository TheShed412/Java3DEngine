import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame
{
    private static final long serialVersionUID = 123456789;
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;

  public GameFrame()
  {
    super("Game Frame");
    Camera gamePanel = new Camera(100);
    gamePanel.randomPoints();
    setContentPane(gamePanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(WIDTH, HEIGHT);
    setVisible(true);
  }//gameFrame

  public static int width()
  {
    return WIDTH;
  }//getWidth

  public static int height()
  {
    return HEIGHT;
  }//getWidth
}//GameFrame
