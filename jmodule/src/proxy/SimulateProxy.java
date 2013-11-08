package proxy;

import org.apache.commons.logging.Log;

public class SimulateProxy implements IHello {

	private IHello hello;
	private static final Log logger = LogUtil.getLogger(SimulateProxy.class);
	
	public SimulateProxy(HelloImpl helloImpl) {
		hello = helloImpl;
	}

	@Override
	public void sayHello(String name) {
		logger.debug("Before method start ......");
		hello.sayHello("business method executing : " + name);
		logger.debug("After method executed ......");
	}

	@Override
	public void sayBye(String name) {
		System.out.println("do something before method execute...");
		hello.sayBye("business method executing : " + name);
		System.out.println("do somethin after method finished....");
	}

}
