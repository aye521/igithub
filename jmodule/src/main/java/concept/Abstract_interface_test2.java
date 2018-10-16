package concept;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 为什么jdk源码里，比如HashMap继承了AbstractMap，AbstractMap implemnts Map接口，按理说HashMap就必须实现Map接口，
 * 但是为什么HashMap也显示implements了Map接口，stackOverflo上面，有的说为了便于阅读或者生成文档，我觉得下面这个答案可能
 * 更靠谱一些，因为一个class的getInterfaces方法好像只会获取到该类显示implements的接口
 *
 * Hence if we wanted to create a dynamic proxy which implements all interfaces for an object
 * which has implicit interface inheritance then the only way to do it generically
 *  would be to walk the superclasses all the way back to java.lang.Object,
 *  as well as walking all the implemented interfaces and their superclasses (remember Java supports multiple interface inheritance),
 *  which doesn't sound very efficient, while it is much easier (and faster) to explicitly name interfaces as I suppose
 *  they are set in at compile time.
 *  So what uses reflection & proxies? RMI for one...
 *
 * Therefore, yes it is a convenience,
 * but no it is certainly not redundant: remember that these classes were carefully designed and implemented by Josh Bloch,
 * so I suspect that they were explicitly programmed this way so that proxied network stubs and skeletons work as they do.
 *
 * Side note: While it does make dyanmic proxies easier to create when all of the interfaces are at the same level,
 * you can always reflectively traverse the class heirarchy (easy since Java is single inheritance)
 * and figure out all of the interfaces of the parents classes
 * @author meaning
 *
 */

public class Abstract_interface_test2 extends Abstract_Interface_test{

	public static void main(String[] args) {

		//静态内部类可直接使用，如果是非静态类则需要先创建外部对象的实例
		MyInterface c1 = new Class1();
		MyInterface c2 = new Class2();

		// Note the order...
		MyInterface proxy2 = createProxy(c2);
		proxy2.foo();

		// This fails with an unchecked exception
		MyInterface proxy1 = createProxy(c1);
		proxy1.foo();
	}

	@SuppressWarnings("unchecked")
	private static <T> T createProxy(final T obj) {

		final InvocationHandler handler = new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.printf("About to call %s() on %s\n", method
						.getName(), obj);
				return method.invoke(obj, args);
			}
		};

		return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), handler);
	}
}
