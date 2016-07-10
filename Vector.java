public class Vector
{
  private double[] coor;
  private boolean init = false;

  public Vector()
  {
    this.coor = new double[3];
    init = true;
  }//empty constructor

  public Vector(double x, double y, double z)
  {
    this.coor = new double[3];
    this.coor[0] = x;
    this.coor[1] = y;
    this.coor[2] = z;
    init = true;
  }//x,y,z constructor

  public Vector(double[] coor) throws Not3DPointException
  {
      if(coor.length!=3){
        init = false;
        throw new Not3DPointException("Needs 3 Vectors in the Array");
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

  public double[] getVector() throws NotInitializedException
  {
    if(checkInit())
      return coor;
    else
      throw new NotInitializedException("The Vector was not iniotialized properly");
  }//getVector
}//Vector
