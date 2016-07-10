public class Test
{
  public static void main(String[] args) throws NotInitializedException, Not3DPointException
   {
      double[] pa1 = {1,2,1};
      double[] pa2 = {0,4,4};
      Point p1 = new Point(pa1);
      Point p2 = new Point(pa2);
      Vector v1 = new Vector(2,0,0);
      Vector v2;

      p1.drawPoint();
      p2.drawPoint();

      v2 = p1.subtractPointFromPoint(p2);
      System.out.println(v2.toString());
      System.out.println(v1.toString());
      v1 = v1.addVectorToVector(v2);
      System.out.println(v1.toString());

      p1.addVectorToPoint(v1);
      p1.drawPoint();

      p2.subtractVectorFromPoint(v2);
      p2.drawPoint();
  }
}//test
