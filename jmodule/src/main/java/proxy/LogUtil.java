package proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {

	public static Logger getLogger(Class<?> clazz){
		return LoggerFactory.getLogger(clazz);
	}

    public static void main(String[] args) {
        Logger log = getLogger(LogUtil.class);
        log.info("{}, {} , test","info test ","simple log facade for java");
        log.debug("{}, {} , test","debug test ","simple log facade for java");
    }
}
