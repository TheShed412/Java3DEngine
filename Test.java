import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Test
{
  public static void main(String[] args) throws NotInitializedException, Not3DPointException
  {
      double[][] lt = {{1,1,1},{1,1,1}, {1,1,1}};

      LinearTransformation l = new LinearTransformation(3, lt);

      System.out.print(l);
  }//main
}//test
