package reflections;

public class SomeClass {

	private String desc;
	public SomeClass() {
		System.out.println("SomeClass is contructed");
		desc = "SomeClass's private field!";
	}
	
	String getDesc(){
		return desc;
	}
}
