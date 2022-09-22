import java.awt.Rectangle;

public class BigRectangleFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        Rectangle rectangle = (Rectangle) x;
        return ((2 * rectangle.height) + (2 * rectangle.width)) > 10;
    }
}
