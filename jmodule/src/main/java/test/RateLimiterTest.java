package test;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RateLimiterTest {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(6d);
        for (int i = 0; i < 2; i++) {
//            System.out.println(new Date() + " >>> start executing <<<<");
            new Thread(new SimpleThread(rateLimiter),"T" + i).start();
        }
    }

    static void simpleTest() {
        double permitsPerSecond = 1d;
        RateLimiter limiter = RateLimiter.create(permitsPerSecond);
        for (int i = 0; i < 10; i++) {
            performOperation(limiter);
        }
    }

    private static void performOperation(RateLimiter limiter) {
        limiter.acquire(3);
        System.out.println(new Date() + ": Beep");
    }

    public static void sleepInSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class SimpleThread implements Runnable {
    private RateLimiter rateLimiter;
    SimpleThread(RateLimiter limiter) {
        this.rateLimiter = limiter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            double sleep = this.rateLimiter.acquire(1);
            System.out.println(new Date() + " : " + Thread.currentThread().getName() + " : sleep > " + sleep);
        }
    }


}