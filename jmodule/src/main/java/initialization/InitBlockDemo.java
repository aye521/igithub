package initialization;

class InitBlocksDemo {

    {
            System.out.println(this.i);// can't use a field before it is defined
            i = 20;               //but, can be initialized
    }

    int i;

    static int k;

    static
    {
        System.out.println(k);
        System.out.println(InitBlocksDemo.j); //but this way is ok
        //     System.out.println(j);  can't use a field before it is defined
        //     k=j;                   even you can't use it to initialize other fields
        j=k;                    //but, can be initialized.
    }

    static int j;
    InitBlocksDemo(int x) {
        name = "enter constructor prasad";
        System.out.println("In 1 argument constructor, name = " + name);
    }

    InitBlocksDemo() {
        this.name = "enter constructor";
    System.out.println("In no argument constructor, name = " + this.name);

    }

    /* First static initialization block */

    static{
        //can't access the static filed 'class filed cause of order
//        System.out.println("In first static init block " + classFiled);
        // but can be initialized
        classFiled = "first static block";
    }

    static String classFiled = "class Filed";
    /* First instance initialization block  */
    {
        //this.name is ok ,but just name will cause compile error : illegal forward reference
        System.out.println("In first instance init block, name = " + this.name);
    }

    private String name = "default";

    /* Second instance initialization block */
    {
        System.out.println("In second instance init block, name = " + this.name);
    }

    /* Second static initialization block  */
            static {
                System.out.println("In second static int block " + classFiled);
    }

    public static void main(String args[]) {
        new InitBlocksDemo();
//        new InitBlocksDemo(7);
    }

}