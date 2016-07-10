import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class DrawPanel extends JPanel
{
    public void paintComponent(Graphics g)
    {
          //draw on g here e.g.
       g.fillRect(20, 20, 100, 200);
    }//paintComponent

    public DrawPanel()
    {
      KeyListener listener = new KeyAction();
      addKeyListener(listener);
      setFocusable(true);
    }//KeyListen

    ///KeyListener Class///
    public class KeyAction implements KeyListener
    {
      public void keyTyped(KeyEvent e)
      {}//keyTyped

      public void keyPressed(KeyEvent e)
      {
        System.out.println("Key Pressed: "+KeyEvent.getKeyText(e.getKeyCode()));
      }//keyPressed

      public void keyReleased(KeyEvent e)
      {
        System.out.println("Key Released: "+KeyEvent.getKeyText(e.getKeyCode()));
      }//keyPressed

    }//Key Action

}//DrawPanel
