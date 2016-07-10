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

  public Point addVectorToPoint(Vector v) throws NotInitializedException
  {
    if(checkInit()){
      double[] vec = v.getVector();

      for(int i=0; i<3; i++){
          coor[i] += vec[i];
      }//for
    }else{
      throw new NotInitializedException("Not Initialized Properly");
    }//if else
    return this;
  }//AddVectorToPoint

  public Point subtractVectorFromPoint(Vector v) throws NotInitializedException
  {
    if(checkInit()){
      double[] vec = v.getVector();

      for(int i=0; i<3; i++){
          coor[i] -= vec[i];
      }//for
    }else{
      throw new NotInitializedException("Not Initialized Properly");
    }//if else
    return this;
  }//SubtractVectorFromPoint

  public Vector subtractPointFromPoint(Point p) throws NotInitializedException, Not3DPointException
  {
    Vector v;
    if(checkInit()){
      double[] point = p.getPoint();
      double[] vec = new double[3];

      for(int i=0; i<3; i++){
        vec[i] = coor[i]-point[i];
      }//for

      v = new Vector(vec);
    }else{
      throw new NotInitializedException("Not Initialized Properly");
    }
    return v;
  }//SubtractPointFromPoint

  public void drawPoint()
  {
    System.out.println(toString());
  }//drawPoint

  public void setPoint(Point p) throws NotInitializedException
  {
    if(checkInit()){
      coor = p.getPoint();
    }else{
      throw new NotInitializedException("Not Initialized");
    }
  }//setPoint

  @Override
  public String toString()
  {
    String str = "("+coor[0]+", "+coor[1]+", "+coor[2]+")";
    return str;
  }//toString

}//Class
