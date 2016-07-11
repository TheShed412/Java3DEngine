import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Camera extends JPanel
{
    private static final long serialVersionUID = 123456789;
  private int minX = 0;
  private int maxX = 800;
  private int minY = 0;
  private int maxY = 600;
  private int minZ = 0;
  private int maxZ = 100;
  private boolean init = false;
  Point[] points;


  public Camera(int points)
  {
    this.points = new Point[points];
    KeyAction listener = new KeyAction(this, this.points);
    addKeyListener(listener);
    setFocusable(true);
    init = true;
  }

  public Camera(int maxX, int maxY, int maxZ, int points)
  {
    this.maxX = maxX;
    this.maxY = maxY;
    this.maxZ = maxZ;
    this.points = new Point[points];
    KeyAction listener = new KeyAction(this, this.points);
    addKeyListener(listener);
    setFocusable(true);
    init = true;
  }//constructor

  public boolean checkInit()
  {
    return init;
  }//checkInit

  public void drawScene() throws NotInitializedException
  {
    if(checkInit()){
      int checkPoint;

      for(int i=0; i<points.length; i++){
      }//for
    }else{
      throw new NotInitializedException("Camera Not Initialized");
    }//if else
  }//drawScene

  public void randomPoints()
  {
    Random r = new Random();

    for(int i=0; i<points.length; i++){
      int x = r.nextInt(800);
      int y = r.nextInt(600);
      int z = 5;

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


}//Camera
