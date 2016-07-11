
public class LinearTransformation
{
    private int n;
    private double[][] transformation;

    public LinearTransformation(int n)
    {
        this.n = n;
        transformation = new double[n][n];
    }//constructor

    public LinearTransformation(int n, double[][] tranArr)
    {
        this.n = n;
        transformation = new double[n][n];
        makeTransformation(tranArr);
    }//constructor

    public double[][] makeTransformation(double[][] tranArr)
    {
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                transformation[i][j] = tranArr[i][j];
            }//inner for
        }//outer for
        return transformation;
    }//makeTransformation

    public String toString()
    {
        String returnString = "";

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(transformation[i][j]);
            }//inner for
            System.out.println();
        }//outer for

        return returnString;
    }//toString

}//LinearTransformation
