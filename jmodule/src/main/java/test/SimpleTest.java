package test;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class SimpleTest {
    private static final Logger logger = LoggerFactory.getLogger(SimpleTest.class);
    public static void main(String[] args) throws InterruptedException {
        Stopwatch sw = Stopwatch.createStarted();
        logger.info("elapsed : {}", sw);
        Thread.sleep(3000);
        logger.info("elapsed : {}, before stopped", sw);
        sw.stop();
        sw.start();
        logger.info("stopped then started : {}", sw);

    }
}
