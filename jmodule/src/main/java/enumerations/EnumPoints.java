package enumerations;

import static enumerations.EnumPoints.Color.RED;

/* internally  enum Color is converted to
class Color
{
     public static final Color RED = new Color();
     public static final Color BLUE = new Color();
     public static final Color GREEN = new Color();
}*/
public class EnumPoints {
    enum Color
    {
        RED, GREEN, BLUE , PINK
    }

    // Driver method
    public static void main(String[] args)

    {
        Color c1 = Color.GREEN;
        System.out.println(c1);
        switch (c1)
        {
            case RED:
                System.out.println("RED are bad.");
                break;
            case BLUE:
                System.out.println("BLUE are better.");
                break;
            case GREEN:
            case PINK:
                System.out.println("GREEN and PINK are best.");
                break;
            default:
                System.out.println("Others are so-so.");
                break;
        }
    }
}
