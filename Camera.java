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

  public Camera(int maxX, int maxY, int maxZ, int points)
  {
    this.maxX = maxX;
    this.maxY = maxY;
    this.maxZ = maxZ;
    things = new Point[points];
    init = true;
  }//constructor

  public boolean checkInit()
  {
    return init;
  }//checkInit

  public void drawScene()
  {

  }//drawScene

}//Camera
