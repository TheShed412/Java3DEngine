
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

    public double[][] getMatrix()
    {
        double[][] returnArr = new double[5][5];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                returnArr[i][j] = transformation[i][j];
            }//inner for
        }//outer for

        return returnArr;
    }//getMatrix

    public int getSize()
    {
        return n;
    }//getSize

    public LinearTransformation matrixMultiply(LinearTransformation mult)
    {
        double[][] multArr = mult.getMatrix();
        double[][] resultArr = new double[n][n];
        LinearTransformation result = new LinearTransformation(n);
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                resultArr[i][j] = multiply(multArr, j, i);
            }//inner for
        }//outer for

        result.makeTransformation(resultArr);

        return result;
    }//matrixMultiply

    private double multiply(double[][] mult, int col, int row)
    {
        double result = 0.0;

        for(int i=0; i<n; i++){
            result += transformation[row][i]*mult[i][col];
        }//for loop

        return result;
    }//multiply

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
