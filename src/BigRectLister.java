import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister
{
    public static void main(String args[])
    {
        BigRectangleFilter bigRect = new BigRectangleFilter();
        ArrayList<Object> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(3, 3));
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(2, 4));
        rectangles.add(new Rectangle(5, 1));
        rectangles.add(new Rectangle(8, 2));
        rectangles.add(new Rectangle(4, 4));
        rectangles.add(new Rectangle(3, 2));
        rectangles.add(new Rectangle(4, 1));

        System.out.println("All Rectangle Perimeters");
        for(Object x : rectangles)
        {
            Rectangle rectangle = (Rectangle) x;
            System.out.println((2 * rectangle.height) + (2 * rectangle.width) + " ");
        }
        System.out.println();
        System.out.println("Rectangles with Big Perimeters");
        for(Object x : rectangles)
        {
            if(bigRect.accept(x))
            {
                Rectangle rectangle = (Rectangle) x;
                System.out.println((2 * rectangle.height) + (2 * rectangle.width) + " ");
            }
        }
    }
}
