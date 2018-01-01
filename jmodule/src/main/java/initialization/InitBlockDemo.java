package initialization;

class InitBlocksDemo {

    InitBlocksDemo(int x) {
        this.name = "enter constructor prasad";
        System.out.println("In 1 argument constructor, name = " + this.name);
    }

    InitBlocksDemo() {
        this.name = "enter constructor";
    System.out.println("In no argument constructor, name = " + this.name);

    }

    /* First static initialization block */

    static{
        //can't access the static filed 'class filed cause of order
        System.out.println("In first static init block ");
    }

    static String classFiled = "class Filed";
    /* First instance initialization block  */
    {
        //instance block without consider the order of definition instance field,so can access the name field
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