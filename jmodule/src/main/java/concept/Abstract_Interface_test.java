package concept;

import java.io.Serializable;
import java.util.Arrays;

public class Abstract_Interface_test {

	public static interface MyInterface {
		void foo();
	}
	
	/**
	 * �ڲ���̬��
	 * ���ȣ�ֻ�о�̬�ڲ�����ܶ��徲̬�ĳ�Ա���Ǿ�̬�ڲ����ڲ����ܶ���static��Ա����
	 * ��Σ���̬�ڲ���ֻ�ܷ����ⲿ��ľ�̬��Ա���Ǿ�̬����û��������ƣ�
	 * ����ⲿ����ʱ����̬���ֱ��ʹ�ã����Ǿ�̬��������ȴ����ⲿ���ʵ������������ã�
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