import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Test
{
  public static void main(String[] args) throws NotInitializedException, Not3DPointException
  {
      double[][] lt = {{2,7,4},{5,4,2}, {7,4,8}};
      double[][] lt2 = {{8,5,4},{5,4,2}, {7,4,8}};

      LinearTransformation l = new LinearTransformation(3, lt);
      LinearTransformation l2 = new LinearTransformation(3, lt2);

      LinearTransformation l3 = l.matrixMultiply(l2);

      System.out.print(l3);
  }//main
}//test
