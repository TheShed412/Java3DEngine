import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

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
  private int pointsToAdd;
  ArrayList<Point> points;


  public Camera(int pointsToAdd)
  {
    this.points = new ArrayList<Point>();
    this.pointsToAdd = pointsToAdd;
    KeyAction listener = new KeyAction(this, this.points);
    addKeyListener(listener);
    setFocusable(true);
    init = true;
  }

  public Camera(int maxX, int maxY, int maxZ, int pointsToAdd)
  {
    this.pointsToAdd = pointsToAdd;
    this.maxX = maxX;
    this.maxY = maxY;
    this.maxZ = maxZ;
    KeyAction listener = new KeyAction(this, this.points);
    addKeyListener(listener);
    setFocusable(true);
    init = true;
  }//constructor

  public boolean checkInit()
  {
    return init;
  }//checkInit

  public void drawScene(Graphics g) throws NotInitializedException
  {
    if(checkInit()){
        boolean xTrue;
        boolean yTrue;
        boolean zTrue;
        double[] temp;

      for(int i=0; i<points.size(); i++){
          temp = points.get(i).getPoint();

          xTrue = (temp[0]>=minX && temp[0]<=maxX);
          yTrue = (temp[1]>=minY && temp[1]<=maxY);
          zTrue = (temp[2]>=minZ && temp[2]<=maxZ);

          if(xTrue&&yTrue&&zTrue){
              g.fillRect((int)temp[0], (int)temp[1], 2, 2);
          }//if
      }//for
    }else{
      throw new NotInitializedException("Camera Not Initialized");
    }//if else
  }//drawScene

  public void randomPoints()
  {
    Random r = new Random();
    points.clear();

    for(int i=0; i<pointsToAdd; i++){
      int x = r.nextInt(900)-100;
      int y = r.nextInt(700)-100;
      int z = r.nextInt(150)-50;

      points.add(new Point(x, y, z));
    }//for
    randomLine();
  }//randomPoints

  public void randomLine()
  {
    Random r = new Random();
    int x1 = r.nextInt(800);
    int x2 = r.nextInt(800);
    int y1 = r.nextInt(600);
    int y2 = r.nextInt(600);

    LineSegment line = new LineSegment(x1, x2, y1, y2);
    ArrayList<Point> segment = line.returnPointsInSegment();
    Point temp;

    for(int i=0; i<segment.size(); i++){
      temp = segment.get(i);
      points.add(temp);
    }//for

  }//randomLines

  public void paintComponent(Graphics g)
  {
        //draw on g here e.g.
    super.paintComponent(g);

    try{drawScene(g);}
    catch(Exception e){}
    // for(int i=0; i<points.length; i++){
    //   Point p = points[i];
    //   double[] coor = new double[3];
    //   try{
    //     coor = p.getPoint();
    //   }catch(Exception e){}
    //
    //   g.fillRect((int)coor[0], (int)coor[1], 5, 5);
    // }//for
  }//paintComponent


}//Camera
