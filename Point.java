public class Point
{
  //Coordinates for Point3
  private double[] coor;
  private boolean init = false;

  public Point()
  {
    this.coor = new double[3];
    init = true;
  }//empty constructor

  public Point(double x, double y, double z)
  {
    this.coor = new double[3];
    this.coor[0] = x;
    this.coor[1] = y;
    this.coor[2] = z;
    init = true;
  }//x,y,z constructor

  public Point(double[] coor) throws Not3DPointException
  {
      if(coor.length!=3){
        init = false;
        throw new Not3DPointException("Needs 3 points in the Array");
      }else{
        this.coor = coor;
        init = true;
      }//if else
  }//coordinate constructor

  private boolean checkInit() throws NotInitializedException
  {
    if(init)
      return init;
    else
      throw new NotInitializedException("Not properly Initialized");
  }//check init

  public double[] getPoint() throws NotInitializedException
  {
    if(checkInit())
      return coor;
    else
      throw new NotInitializedException("The point was not iniotialized properly");
  }//getPoint

  public Point AddVectorToPoint(Vector v)
  {
    return this;
  }//AddVectorToPoint

  public Point SubtractVectorFromPoint(Vector v)
  {
    return this;
  }//SubtractVectorFromPoint

  public Vector SubtractPointFromPoint(Point p)
  {
    Vector v = new Vector();
    return v;
  }//SubtractPointFromPoint

  public void drawPoint()
  {
    System.out.println(toString());
  }//drawPoint
  @Override
  public String toString()
  {
    String str = "("+coor[0]+", "+coor[1]+", "+coor[2]+")";
    return str;
  }//toString

}//Class
