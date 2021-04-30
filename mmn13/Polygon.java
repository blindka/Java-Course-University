/**
 * This class display number of vertices from a Convex Polygon
 * display them by order they appear on the Convex Polygon
 * the methods in this program include: the area, the perimeter,
 * the highest vertex, String (prints the vertices)
 * @author Eyal Haimov
 * @version 316316868
 */
public class Polygon {
    private Point[] _vertices;
    private int _noOfVertices;
    private final int MAX_NUMBER_VERTICES = 10;
    /**
     * Creating Constructor for object for the polygun
     * Initializing the array and entering null in each vertex point
     */
    public Polygon()
    {
        _vertices = new Point[MAX_NUMBER_VERTICES];
        _noOfVertices = 0;
        for(int i = 0; i < MAX_NUMBER_VERTICES; i++)
        {
            _vertices[i] = null;
        }
    }
    /**
     * This method add a vertex to the Polygun.
     * Adding the values to the first empty cell in the array.
     * @param x - the X point of the vertex we are adding to the polygun
     * @param y - the Y point of the vertex we are adding to the polygun
     * @return - true if the number of vertices isn't full and we added a point
     * @return - false if the array is full
     */
    public boolean addVertex(double x, double y)
    {
        if (_noOfVertices < MAX_NUMBER_VERTICES)
        {
                _vertices[_noOfVertices] = new Point(x,y);
                _noOfVertices++;
                return true; // return true - if vertex is added
        }
        else{
        return false; // return false - if array is full
        }
    }
    /**
     * This method is checking which vertex is the highest
     * the first highest vertex it encounters it will return it
     * @return the highest vertex of the polygun
     * @return - null if there isn't any vertex
     */
    public Point highestVertex()
    {
        if (_noOfVertices == 0)
        {
            return null; // return null if there isn't any vertex
        }
        Point highest = new Point(_vertices[0]);
        for (int i = 0; i < _noOfVertices; i++)
        {
            if(_vertices[i].isAbove(highest))
                highest = _vertices[i];
        }
         return highest; // return the highest Point
    }
    /**
     * This method returns a string that represent values of the convex polygun - (x,y)
     * @return - if there is 0 vertices - "the polygun has 0 vertices."
     * @return - if there is more than 0, it will represent in that way: ((x,y),(x,y),(x,y))
     */
    public String toString()
    {
        if (_noOfVertices == 0)
        {
            return "The polygon has 0 vertices."; // if there isn't any vertex return "has 0 vertices"
        }
        else{
            String leftBaracket = "(" + _vertices[0].toString(); // ((2.0,1.0)
            for (int i = 1; i < _noOfVertices; i++)
            {
                leftBaracket += "," + _vertices[i].toString(); // ((2.0,5.0),(5.0,0.0),+...+(x,y)
            }
            String rightBaracket = ")"; // ((2.0,5.0),(5.0,0.0),+...+(x,y)) - adding the right baracket
            return "The polygon has " + _noOfVertices + " vertices:\n" + leftBaracket + rightBaracket;
        }
    }
    /**
     * This methold calculate the permieter of the convex polygun
     * @return - if the number of vertices is 0 or 1 - returns 0
     * @return - if the number of vertices is 2 - returns the distance
     * @return - otherwise, calculate the distance of vertices around the polygun
     */
    public double calcPerimeter ()
    {
        if (_noOfVertices == 0 || _noOfVertices == 1)
        {
            return 0; 
        }
        if ( _noOfVertices == 2)
        {
            return _vertices[0].distance(_vertices[1]); // returns distance if there is two vertices
        }
            else{
            double Perimeter = 0;
            for (int i = 0; i < _noOfVertices - 1; i++)
            {
                Perimeter += _vertices[i].distance(_vertices[i+1]); // calculate the distance from one vertex to another
            }
            Perimeter += _vertices[_noOfVertices-1].distance(_vertices[0]); // calculate the perimeter from the first vertex to the last
            return Perimeter;
        }
    }
    /**
     * This method returns the area 
     * @return - the Area of the polygun
     * @return - 0 if the number of vertices is less than 3
     */
    public double calcArea()
    {
        if (_noOfVertices >= 3) // number of vertices is 3 at least (A,B,C)
        {
        double Area = 0;
        for (int i = 0; i <= _noOfVertices - 2; i++)
        {
            double a = _vertices[0].distance(_vertices[i]); // from first index to the next
            double b = _vertices[i].distance(_vertices[i+1]); // from the second index to the next
            double c = _vertices[i+1].distance(_vertices[0]); // from the second index to the first index
            double s = (a+b+c) / 2.0; // half of the perimeter - for the Heron's Formula
            Area += Math.sqrt(s * (s-a) * (s-b) * (s-c));
        }
            return Area;
        } else{
            return 0; // if _noOfVertices < 3 - returns 0 
        }
    }
    /**
     * This method checks if the area of the current polygun is bigger than the other
     * @param other - the other polygun we are comparing with
     * @return - true if the current polygun is bigger than the other
     * @return - false if the the current polygun isnt bigger than the other
     */
    public boolean isBigger(Polygon other)
    {
        if (this.calcArea() > other.calcArea())
        {
            return true;
        }
            else{
        return false;
        }
    }
    /**
     * This method check if a vertex is located on the current polygun
     * @param p - the vertex we are checking
     * @return - the index of the p if it is one the polygun
     * @return - -1 if the point isn't on the polygun
     */
    public int findVertex(Point p)
    {
        for (int i = 0; i < _noOfVertices; i++)
        {
            if(_vertices[i].equals(p))
                return i;
        }
        return -1;
    }
    /**
     * This method checks if a vertex is located on the polygon and return the next vertex of the polygun
     * @param p - the vertex we are checking
     * @return - null the next vertex after the p, if p isn't located on the polygun
     * @return - if the vertex is last point on the polygun it will return the first index
     */
    public Point getNextVertex(Point p)
    {
        if (this.findVertex(p) == -1)
        {
            return null; // checks if equals -1 = isn't located in the polygun
        }
        else if (this.findVertex(p) == _noOfVertices - 1)
        {
            return new Point(_vertices[0]); // if the point is the last point on the array it will return the first index
        }
        else{
            int nextVertex = this.findVertex(p) + 1; // adding 1 to get to the next index
            return new Point(_vertices[nextVertex]);
        }
    }
    /**
     * This method return a rectangle the blocks the polygun
     * @return - null if the number of vertices is less than 3
     * @return - the rectangle as a polygun.
     */
    public Polygon getBoundingBox()
    {
        if (_noOfVertices <= 3)
        {
            return  null;
        }
        Point xLeft = new Point(_vertices[0]);
        Point xRight = new Point(_vertices[0]);
        Point yUp = this.highestVertex(); // using the method highest to get the highest index
        Point yDown = new Point(_vertices[0]);
    for(int i = 0; i < _noOfVertices; i++)
    {
        if (!(xLeft.isLeft(_vertices[i]))) // if the first index is left to the other index ,if=false the other one is left to it - setting it the other index 
            xLeft = _vertices[i]; 
        if (!(xRight.isRight(_vertices[i]))) // if the first index is right to the other index ,if=false the other one is right to it - setting it the other index 
            xRight = _vertices[i];
        if (!(yDown.isUnder(_vertices[i]))) // if the first index is under to the other index ,if=false the other one is under to it - setting it the other index 
            yDown = _vertices[i];
    }
    Polygon BoundingBox = new Polygon();
    BoundingBox.addVertex(xLeft.getX(),yDown.getY());
    BoundingBox.addVertex(xRight.getX(),yDown.getY());
    BoundingBox.addVertex(xRight.getX(),yUp.getY());
    BoundingBox.addVertex(xLeft.getX(),yUp.getY());
    return BoundingBox;
}
}