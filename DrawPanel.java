import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

class DrawPanel extends JPanel
{
    Point[] points = new Point[100];

    public void randomPoints()
    {
      Random r = new Random();

      for(int i=0; i<points.length; i++){
        int x = r.nextInt(GameFrame.width());
        int y = r.nextInt(GameFrame.height());
        int z = r.nextInt(10);

        points[i] = new Point(x, y, z);
      }//for

    }//randomPoints

    public void paintComponent(Graphics g)
    {
          //draw on g here e.g.
      randomPoints();

      for(int i=0; i<points.length; i++){
        Point p = points[i];
        double[] coor = new double[3];
        try{
          coor = p.getPoint();
        }catch(Exception e){}

        g.fillRect((int)coor[0], (int)coor[1], (int)coor[2], (int)coor[2]);
      }//for
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
      @Override
      public void keyTyped(KeyEvent e)
      {}//keyTyped

      @Override
      public void keyPressed(KeyEvent e)
      {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
              System.exit(0);
              break;
            case KeyEvent.VK_A:
              System.out.println(points[0]);
        }
      }//keyPressed

      @Override
      public void keyReleased(KeyEvent e)
      {}//keyPressed

      private void buttA() throws NotInitializedException, Not3DPointException
      {
        Point origin = new Point(0,0,0);
        Vector temp;

        for(int i=0; i<points.length; i++){
          temp = points[i].subtractPointFromPoint(origin);
          points[i].setPoint(origin);
          points[i].addVectorToPoint(temp.scale(0.5,0.5,0.5));
        }//for
      }//buttA

    }//Key Action

}//DrawPanel
