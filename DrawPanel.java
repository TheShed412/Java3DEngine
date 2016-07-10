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
        int x = r.nextInt(800);
        int y = r.nextInt(600);
        int z = r.nextInt(10);

        points[i] = new Point(x, y, z);
      }//for

    }//randomPoints

    public void paintComponent(Graphics g)
    {
          //draw on g here e.g.
      super.paintComponent(g);
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
      KeyListener listener = new KeyAction(this);
      addKeyListener(listener);
      setFocusable(true);
    }//KeyListen

    ///KeyListener Class///
    public class KeyAction implements KeyListener
    {
      DrawPanel mainPanel;
      public KeyAction(DrawPanel gp)
      {
        mainPanel=gp;
      }

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
              try{buttA();}
              catch(Exception ex){System.out.println(ex);}
              break;
            case KeyEvent.VK_S:
              try{buttS();}
              catch(Exception ex){System.out.println(ex);}
              break;
            case KeyEvent.VK_D:
              mainPanel.randomPoints();
              mainPanel.revalidate();
              mainPanel.repaint();
              break;
            case KeyEvent.VK_R:
              try{buttR();}
              catch(Exception ex){System.out.println(ex);}
              break;
        }//switch
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
          mainPanel.revalidate();
          mainPanel.repaint();
      }//buttA

      private void buttS() throws NotInitializedException, Not3DPointException
      {
        Point origin = new Point(0,0,0);
        Vector temp;

        for(int i=0; i<points.length; i++){
          temp = points[i].subtractPointFromPoint(origin);
          points[i].setPoint(origin);
          points[i].addVectorToPoint(temp.scale(2.0,2.0,2.0));
        }//for
          mainPanel.revalidate();
          mainPanel.repaint();
      }//buttA

      private void buttR() throws NotInitializedException, Not3DPointException
      {
        Point origin = new Point(0,0,0);
        Vector temp;

        for(int i=0; i<points.length; i++){
          temp = points[i].subtractPointFromPoint(origin);
          points[i].setPoint(origin);
          points[i].addVectorToPoint(temp.XYRotate(15));
        }//for
          mainPanel.revalidate();
          mainPanel.repaint();
      }//buttA

    }//Key Action

}//DrawPanel
