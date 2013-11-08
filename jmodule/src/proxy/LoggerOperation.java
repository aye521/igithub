package proxy;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;

public class LoggerOperation implements IOperation {

	private static final Log logger = LogUtil.getLogger(LoggerOperation.class);
	
	@Override
	public void start(Method method) {
		logger.debug("'" + method.getName() + "'" + " Method start...");

	}

	@Override
	public void end(Method method) {
		logger.debug("'" + method.getName() + "'" + " Method end...");
	}

}
