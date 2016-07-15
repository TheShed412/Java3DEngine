import java.util.*;

public class Circle
{
  private int centerX;
  private int centerY;
  private int radius;
  private boolean init = false;

  public Circle(int x, int y, int r)
  {
    centerY = y;
    centerX = x;
    radius = r;
    init = true;
  }//constructor

  public Circle(Point p, int r)
  {
    radius = r;
    double[] coor = new double[2];
    try{coor = p.getPoint();}
    catch (Exception e) {}
    centerX = (int)coor[0];
    centerY = (int)coor[1];
    init = true;
  }//constructor

  public ArrayList<Point> returnCircle()
  {
    ArrayList<Point> circle = new ArrayList<Point>();
    int f = 1 - radius;
    int ddFx = 1;
    int ddFy = -2*radius;
    int x = 0;
    int y = radius;

    circle.add(new Point(centerX, centerY + radius, 0));
    circle.add(new Point(centerX, centerY - radius, 0));
    circle.add(new Point(centerX + radius, centerY, 0));
    circle.add(new Point(centerX - radius, centerY, 0));

    while(x < y){
      if(f >= 0){
        y--;
        ddFy += 2;
        f += ddFy;
      }//if
      x++;
      ddFx += 2;
      f+= ddFx;

      circle.add(new Point(centerX + x, centerY + y, 0));
      circle.add(new Point(centerX - x, centerY + y, 0));
      circle.add(new Point(centerX + x, centerY - y, 0));
      circle.add(new Point(centerX - x, centerY - y, 0));
      circle.add(new Point(centerX + y, centerY + x, 0));
      circle.add(new Point(centerX - y, centerY + x, 0));
      circle.add(new Point(centerX + y, centerY - x, 0));
      circle.add(new Point(centerX - y, centerY - x, 0));
    }//while

    return circle;
  }//returnCircle

}//class
