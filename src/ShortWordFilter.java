public class ShortWordFilter implements Filter
{
    @Override
    public boolean accept(Object x)
    {
        String fiveString = (String) x;
        return fiveString.length() < 5;
    }
}
