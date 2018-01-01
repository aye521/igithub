package proxy;

import org.slf4j.Logger;

/**
 * AOP why �� ��һ������ִ��ǰ�����һЩͨ�õĲ�����������־������ȣ�������ͨ�õ�ģ�飩��
 * ���Ӳ����Ļ���һ���湤�����󡢴������࣬��һ���治��ά������һͨ��ģ����߼������ı�����Ҫ�ظ��޸����ط����ȣ�
 * AOP�ڲ��ı�ԭ��ҵ�񷽷�������£�ͨ��java��̬������ʵ��ͨ��ģ���ע�룻
 * @author meaning
 *
 */

public class ProxyTest {

	@SuppressWarnings("unused")
	private static final Logger logger = LogUtil.getLogger(ProxyTest.class);
	private static IHello helloImpl = new HelloImpl();
	public static void main(String[] args) {
//		simpleProxyTest();
		
		dynamicProxyTest();
		
		logger.info("finished test");
	}
	
	static void dynamicProxyTest(){
		//ͨ������operation���󣬽���������ͷ���ǰ����Ҫ�Ĳ���
		IHello hello = (IHello)new DynamicProxy().bind(helloImpl,new LoggerOperation());
	    hello.sayBye("Double J");
	}
	
	/**
	 * �򵥴����ࣺʵ�ֺ�Ŀ������ͬ�Ľӿڣ�Ȼ���Ŀ������Ϊ������
	 * Ȼ���ô��������Ŀ���࣬���ڴ�����ķ����ڿ����ڵ���Ŀ����ķ���ǰ��
	 * ��һЩ����Ĳ���;
	 * ȱ�㣺ʵ�������Ƚ��鷳����Ҫ�ֶ�ʵ��ÿ����Ҫ����ķ������������󣻽��:ʹ��jdk�Ķ�̬����
	 */
	static void simpleProxyTest(){
		IHello hello = new SimulateProxy(new HelloImpl());
		hello.sayHello("simple proxy");
	}
	
}
