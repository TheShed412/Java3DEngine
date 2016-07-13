public class LineSegment
{
    private int startX;
    private int endX;
    private int startY;
    private int endY;
    private boolean init = false;

    public LineSegment(int x1, int x2, int y1, int y2)
    {
        startX = x1;
        endX = x2;
        startY = y1;
        endY = y2;
        init = true;
    }//constructor

    public LineSegment(Point start, Point end)
    {
        double[] endCoor = new double[2];
        double[] startCoor = new double[2];
        try{startCoor = start.getPoint();
            endCoor = end.getPoint();}
            catch (Exception e) {}

        startX = (int)startCoor[0];
        startY = (int)startCoor[1];
        endX = (int)endCoor[0];
        endY = (int)endCoor[1];
        init = true;
    }//constructor

    public Point[] getPoints()
    {
        Point[] p = new Point[3];
        return p;
    }//getPoints
}//lineSegment
