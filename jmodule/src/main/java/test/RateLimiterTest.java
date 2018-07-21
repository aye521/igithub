package test;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class RateLimiterTest {
    private final static Logger logger = LoggerFactory.getLogger(RateLimiterTest.class);
    public static void main(String[] args) throws InterruptedException {
        int i = 2 & 1;
//        logger.info("result is {}",i);
        toBits(~(-5) + 1);
        toBits(5);
        toBits(~5 + 1);
        toBits(-5);
        toBits(2 << 3);
        toBits(2);
        toBits(-3);
        toBits(-1);
        toBits(Integer.MAX_VALUE);
        toBits(Integer.MIN_VALUE);
        Float.floatToIntBits(1.2f);
        logger.info("test is over");
    }
    private static void toBits(Integer i) {
        String binary = Integer.toBinaryString(i);
        String hex = Integer.toHexString(i);
        System.out.printf("Decimal: %11s, Binary : %32s(%2d), Hex: %8s \n",i,binary , binary.length(),hex);
    }

    static void multipleThreadTest() throws InterruptedException {
        int nThread  = 1;
        RateLimiter rateLimiter = RateLimiter.create(1d);
        final ExecutorService executorService = Executors.newFixedThreadPool(nThread);
        logger.info(" >>> start executing <<<<");
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < nThread; i++) {
            executorService.execute(new SimpleThread(rateLimiter));
        }
        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);
        logger.info(" task finished with elapsed : {}",stopwatch);
    }


    public static void sleepInSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void simpleTest() {
        double permitsPerSecond = 1d;
        RateLimiter limiter = RateLimiter.create(permitsPerSecond);
        for (int i = 0; i < 10; i++) {
            performOperation(limiter);
        }
    }

    static void performOperation(RateLimiter limiter) {
        limiter.acquire(3);
        System.out.println(new Date() + ": Beep");
    }
}


class SimpleThread implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(SimpleThread.class);
    private RateLimiter rateLimiter;
    SimpleThread(RateLimiter limiter) {
        this.rateLimiter = limiter;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName().substring(7);

        int times = 10;
        for (int i = 0; i < times; i++) {
            int permits = 2;
            if (i != 0) {
                permits = 1;
            }
            double sleep = this.rateLimiter.acquire(permits);
            logger.info("{} executed {} time after waited {} seconds",name,(i + 1),sleep);
            if ((i+1) % 5 == 0 && times != (i + 1)) {
                try {
                    // nextInt is normally exclusive of the top value,
                    // so add 1 to make it inclusive
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
                    TimeUnit.SECONDS.sleep(randomNum);
                    logger.info("sleeped {} seconds",randomNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}