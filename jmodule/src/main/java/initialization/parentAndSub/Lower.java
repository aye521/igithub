package initialization.parentAndSub;

public class Lower extends Upper {
    /*
     String lowerString; for test purpose
     */
    String lowerString = "lower field";

    public Lower(){
//        super();
        System.out.println(">>> enter lower constructor : " + this);
        System.out.println("Upper: " + upperString);
        System.out.println("Lower: " + lowerString);
    }

    /**
     * main() calls the Lower constructor.
     An instance of Lower is prepared. That means, all fields are created and populated with default values, i. e. null for reference types, false for booleans and so on. At this time, any inline assignments to the fields have not taken place!
     The super-constructor is called. This is mandated by the language spec. So, before anything else happens, Upper's constructor is called.
     The Upper constructor runs and hands a reference to the freshly created instance to the Initializer.initialize() method.
     The Initializer attaches new Strings to both fields. It does so by using a somewhat dirty instanceof check - not a particularly good design pattern, but possible, nevertheless. Once that has happened, both the upperString lowerString references are no longer null.
     The Initializer.initialize() call finishes, as does the Upper constructor.
     Now it becomes interesting:
     Construction of the Lower instance continues.
     Assuming there is no explicit =null assignment in the lowerString field declaration,
     the Lower constructor resumes execution and prints out the two Strings that are attached to the fields.
     However, if there is an explicit assignment to null,
      execution has a slightly different flow: Just when the super constructor is done, any variable initializers are executed (see section 12.5 of the Java Language Spec), before the rest of the constructor is run. In this case the String reference that was previously assigned to lowerString is not overwritten with null again! Only then does the rest of the constructor continue execution, now printing lowerString: null.
     * @param args
     */
    public static void main(String[] args) {
        new Lower();

    }
}
