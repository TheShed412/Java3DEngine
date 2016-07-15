import java.util.*;

public class LineSegment
{
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private boolean init = false;

    public LineSegment(int x1, int x2, int y1, int y2)
    {
        startX = x1;
        endX = x2;
        startY = y1;
        endY = y2;
        init = true;
    }//constructor

    public LineSegment(Point start, Point end)
    {
        double[] endCoor = new double[2];
        double[] startCoor = new double[2];
        try{startCoor = start.getPoint();
            endCoor = end.getPoint();}
            catch (Exception e) {}

        startX = (int)startCoor[0];
        startY = (int)startCoor[1];
        endX = (int)endCoor[0];
        endY = (int)endCoor[1];
        init = true;
    }//constructor

    public int[] getPoints() throws NotInitializedException
    {
      int[] p = new int[4];
      if(init){
        p[0] = startX;
        p[1] = endX;
        p[2] = startY;
        p[3] = endY;
      }else{
        throw new NotInitializedException();
      }
        return p;
    }//getPoints

    public ArrayList<Point> returnPointsInSegment()
    {
      ArrayList<Point> pointArr = new ArrayList<Point>();
      int x0 = this.startX;
      int y0 = this.startY;
      int x1 = this.endX;
      int y1 = this.endY;

      int dx = Math.abs(x1-x0);
      int dy = Math.abs(y1-y0);
      int sx = (x0<x1) ? 1 : -1;
      int sy = (y0<y1) ? 1 : -1;
      int err = dx-dy;

      pointArr.add(new Point(x0, y0, 0));

      while(!((x0==x1)&&(y0==y1))){
        int e2 = err*2;

        if(e2 >= (dy * -1)){
          err-=dy;
          x0+=sx;
        }//if
        if(e2<dx){
          err+=dx;
          y0+=sy;
        }//if
        pointArr.add(new Point(x0, y0, 0));
      }//while

      return pointArr;
    }//returnPointsInSegment

}//lineSegment
