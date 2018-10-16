package enumerations;

public enum EnumWithMain {
    RED("red",0), GREEN("green",1), BLUE("blue",2);
    private String name;
    private int index;

     // enum constructor called separately for each
    // constant

    /**
     * If no access modifier is specified for the constructor of a normal class,
     * the constructor has default access.
     *
     * If no access modifier is specified for the constructor of an enum type,
     * the constructor is private.
     * @param name
     * @param index
     */
    EnumWithMain(String name, int index)
    {
        this.name = name;
        this.index = index;
        System.out.println("Constructor called for : " +
                this.toString());
    }

    // Only concrete (not abstract) methods allowed
    public void colorInfo()
    {
        final EnumWithMain[] values = EnumWithMain.values();
        for (EnumWithMain value : values) {
            System.out.println(value.index + " : " + value.name);
        }
    }
    // Driver method
    public static void main(String[] args)
    {
        // Calling values()
        EnumWithMain arr[] = EnumWithMain.values();

        // enum with loop
        for (EnumWithMain col : arr)
        {
            // Calling ordinal() to find index
            // of color.
            System.out.println(col + " at index "
                    + col.ordinal());
        }

        // Using valueOf(). Returns an object of
        // Color with given constant.
        // Uncommenting second line causes exception
        // IllegalArgumentException
        System.out.println(EnumWithMain.valueOf("RED"));
        // System.out.println(Color.valueOf("WHITE"));
    }


}

