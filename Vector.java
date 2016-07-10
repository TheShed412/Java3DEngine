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

  public Vector addVectorToVector(Vector v) throws NotInitializedException
  {
    if(checkInit()){
      double[] vec = v.getVector();

      for(int i=0; i<3; i++){
        coor[i]+=vec[i];
      }//for
    }else{
      throw new NotInitializedException("Not Initialized");
    }//if else
    return this;
  }//addVectorToVector

  public Vector subtractVectorFromVector(Vector v) throws NotInitializedException
  {
    if(checkInit()){
      double[] vec = v.getVector();

      for(int i=0; i<3; i++){
        coor[i]-=vec[i];
      }//for
    }else{
      throw new NotInitializedException("Not Initialized");
    }//if else
    return this;
  }//addVectorToVector

  public Vector XYRotate(double deg) throws NotInitializedException
  {
    if(checkInit()){

        double rad = Math.toRadians(deg);
        double[] newVec = new double[3];

        newVec[0] = (Math.cos(rad)*coor[0])+((-Math.sin(rad))*coor[1]);
        newVec[1] = (Math.sin(rad)*coor[0])+(Math.cos(rad)*coor[1]);
        newVec[2] = coor[2];

        coor = newVec;

    }else{
      throw new NotInitializedException("Not Initialized");
    }
    return this;
  }//XYRotate

  public Vector XZRotate(double deg) throws NotInitializedException
  {
    if(checkInit()){

        double rad = Math.toRadians(deg);
        double[] newVec = new double[3];

        newVec[0] = (Math.cos(rad)*coor[0])+((Math.sin(rad))*coor[2]);
        newVec[1] = coor[1];
        newVec[2] = ((-Math.sin(rad))*coor[0])+(Math.cos(rad)*coor[2]);

        coor = newVec;

    }else{
      throw new NotInitializedException("Not Initialized");
    }
    return this;
  }//XZRotate

  public Vector YZRotate(double deg) throws NotInitializedException
  {
    if(checkInit()){

        double rad = Math.toRadians(deg);
        double[] newVec = new double[3];

        newVec[0] = coor[0];
        newVec[1] = (Math.cos(rad)*coor[1])+((-Math.sin(rad))*coor[2]);
        newVec[2] = ((Math.sin(rad))*coor[1])+(Math.cos(rad)*coor[2]);

        coor = newVec;

    }else{
      throw new NotInitializedException("Not Initialized");
    }
    return this;
  }//YZRotate

  public Vector scale(double s0, double s1, double s2) throws NotInitializedException
  {
    if(checkInit()){
      coor[0] *= s0;
      coor[1] *= s1;
      coor[2] *= s2;
    }else{
      throw new NotInitializedException("Not Initialized");
    }//if else
    return this;
  }//scale

  @Override
  public String toString()
  {
    String str = "["+coor[0]+", "+coor[1]+", "+coor[2]+"]";
    return str;
  }//toString

}//Vector
