package proxy;

import org.apache.commons.logging.Log;

/**
 * AOP why ： 在一个方法执行前或后做一些通用的操作（比如日志、事务等，往往是通用的模块），
 * 如果硬编码的话，一方面工作量大、代码冗余，另一方面不易维护（万一通用模块的逻辑发生改变则需要重复修改许多地方）等；
 * AOP在不改变原有业务方法的情况下，通过java动态代理技术实现通用模块的注入；
 * @author meaning
 *
 */

public class ProxyTest {

	@SuppressWarnings("unused")
	private static final Log logger = LogUtil.getLogger(ProxyTest.class);
	private static IHello helloImpl = new HelloImpl();
	public static void main(String[] args) {
//		simpleProxyTest();
		
		dynamicProxyTest();
		
		logger.info("finished test");
	}
	
	static void dynamicProxyTest(){
		//通过传入operation对象，解耦代理对象和方法前后需要的操作
		IHello hello = (IHello)new DynamicProxy().bind(helloImpl,new LoggerOperation());
	    hello.sayBye("Double J");
	}
	
	/**
	 * 简单代理类：实现和目标类相同的接口，然后把目标类作为参数，
	 * 然后用代理类代替目标类，并在代理类的方法内控制在调用目标类的方法前后
	 * 做一些额外的操作;
	 * 缺点：实现起来比较麻烦，需要手动实现每个需要代理的方法，代码量大；解决:使用jdk的动态代理
	 */
	static void simpleProxyTest(){
		IHello hello = new SimulateProxy(new HelloImpl());
		hello.sayHello("simple proxy");
	}
	
}
