package reflections;

public class ObjWithPrivateField {

	private SomeClass privateField;
	
	public ObjWithPrivateField() {
		System.out.println(this.getClass().getSimpleName() + " is contructed!");
	}
	
	public SomeClass getPrivateField(){
		return privateField;
	}
	
}
