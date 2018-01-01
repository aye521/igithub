package initialization.parentAndSub;

public class Upper {
    String upperString;

    public Upper(){
        System.out.println(">>> enter upper constructor : " + this);
        Initializer.initialize(this);
    }
}
