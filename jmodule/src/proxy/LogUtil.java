package proxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogUtil {

	public static void log(Class<?> clazz ,String message){
		Log logger = LogFactory.getLog(clazz);
	    logger.info(message);
	}
	
	public static Log getLogger(Class<?> clazz){
		return LogFactory.getLog(clazz);
	}
}
