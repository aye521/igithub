package proxy;

public class HelloImpl implements IHello {

	@Override
	public void sayHello(String name) {
		System.out.println("hello , " + name);
	}

	@Override
	public void sayBye(String name) {
		System.out.println("Bye , " + name);
	}

}
