public class Camera
{
  private int minX = 0;
  private int maxX = 800;
  private int minY = 0;
  private int maxY = 600;
  private int minZ = 0;
  private int maxZ = 100;
  private boolean init = false;
  Point[] things;
  DrawPanel panel;

  public Camera(DrawPanel dp, int points)
  {
    things[points];
    panel = dp;
    init = true;
  }

  public Camera(DrawPanel dp, int maxX, int maxY, int maxZ, int points)
  {
    this.maxX = maxX;
    this.maxY = maxY;
    this.maxZ = maxZ;
    things = new Point[points];
    panel = dp;
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

      for(int i=0; i<things.length; i++){
        checkPoint =
      }//for
    }else{
      throw new NotInitializedException("Camera Not Initialized");
    }//if else
  }//drawScene

  public Points[] getThings()

}//Camera
