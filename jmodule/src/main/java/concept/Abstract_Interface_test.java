package concept;

import java.io.Serializable;
import java.util.Arrays;

public class Abstract_Interface_test {

	public static interface MyInterface {
		void foo();
	}
	
	/**
	 * 内部静态类
	 * 首先，只有静态内部类才能定义静态的成员（非静态内部类内部不能定义static成员）；
	 * 其次，静态内部类只能访问外部类的静态成员，非静态的则没有这个限制；
	 * 最后，外部访问时，静态类可直接使用，而非静态类则必须先创建外部类的实例对象才能引用；
	 * @author meaning
	 *
	 */

	@SuppressWarnings("serial")
	public static class BaseClass implements MyInterface, Cloneable,
			Serializable {

		@Override
		public void foo() {
			System.out.println("BaseClass.foo");
		}
	}

	@SuppressWarnings("serial")
	public static class Class1 extends BaseClass {

		@Override
		public void foo() {
			super.foo();
			System.out.println("Class1.foo");
		}
	}

	@SuppressWarnings("serial")
	static class Class2 extends BaseClass implements MyInterface, Cloneable,
			Serializable {

		@Override
		public void foo() {
			super.foo();
			System.out.println("Class2.foo");
		}
	}

	public static void main(String[] args) {

		showInterfacesFor(BaseClass.class);
		showInterfacesFor(Class1.class);
		showInterfacesFor(Class2.class);
	}

	private static void showInterfacesFor(Class<?> clazz) {
		System.out.printf("%s --> %s\n", clazz,
				Arrays.toString(clazz.getInterfaces()));
	}
}
