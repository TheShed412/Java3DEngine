import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class KeyAction implements KeyListener
{
  DrawPanel mainPanel;
  Point[] points;

  public KeyAction(DrawPanel gp, Point[] points)
  {
    mainPanel=gp;
    this.points = points;
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
