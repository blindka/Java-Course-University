import java.util.Scanner;
/**
 * This program calculates the areas 
 * and the perimeters of the excircle and the incircle
 * of a given rectangle
 * 
 * @author Eyal Haimov
 * @version 316316868
 */
public class Circle
{
    public static void main (String [] args)
    {
        // declaration of variable for the corners of the rectangle
        int leftUpX,leftUpY,rightDownX,rightDownY;
        // in = incircle, ex = excircle
        double inArea, inRadius, inPerimeter;
        double exArea, exRadius, exPerimeter;
        Scanner scan = new Scanner (System.in);
        System.out.println ("This program calculates the areas " +
            "and the perimeters of the excircle and the incircle " +
            "of a given rectangle ");
        System.out.print("Please enter the two coordinates of the " +
            "left-upper point of the rectangle ");
        leftUpX = scan.nextInt();
        leftUpY = scan.nextInt();
        System.out.print("Please enter the two coordinates of the " +
            "right-down point of the rectangle ");
        rightDownX = scan.nextInt();
        rightDownY = scan.nextInt();
        // calculate in circle: radius, area, perimeter
        inRadius = (leftUpY-rightDownY) / 2.0;
        inArea = Math.PI*Math.pow(inRadius,2);
        inPerimeter = 2*Math.PI*inRadius;
        // calculate x circle: radius, area, perimeter
        exRadius = Math.sqrt(Math.pow((leftUpX-rightDownX),2) + Math.pow((leftUpY-rightDownY),2)) / 2.0;
        exArea = Math.PI*Math.pow(exRadius,2);
        exPerimeter = 2*Math.PI*exRadius;
        System.out.println("Incircle:  radius = " +inRadius+ ", area = " +inArea+ ", perimeter = " +inPerimeter);
        System.out.println("Excircle:  radius = " +exRadius+ ", area = " +exArea+ ", perimeter = " +exPerimeter);
    } // end of method main
} //end of class Circle

/*Score: 100*/
