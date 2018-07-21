package threads;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable{
	 
 // SimpleDateFormat is not thread-safe, so give one to each thread
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue()
        {
        	System.out.println(Thread.currentThread().getName()+" init Formatter");
            return new SimpleDateFormat("yyyyMMdd");
        }
    };
    
    @SuppressWarnings("unused")
	private static SimpleDateFormat fmt = new SimpleDateFormat();
    //
     
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for(int i=0 ; i<3; i++){
            Thread t = new Thread(obj, "Thread-"+i);
            Thread.sleep(new Random().nextInt(1024));
            t.start();
        }
        /**
         * As you can see 
         * from the output that Thread-0 has changed the value of formatter
         *  but still thread-2 default formatter is same as the initialized value.
         *  如果不用threadLocal如果其中一个线程改变了变量的值，那么就会影响所有的之后使用该变量的线程
         * 
         * 
         */
        
    }
 
    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName()+" default Formatter = "+ formatter.get().toPattern());
    	 System.out.println(Thread.currentThread().getName()+" default formatter = "+ fmt.toPattern());
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
//        formatter.set(new SimpleDateFormat("yyyy-MM-dd"));
        fmt = new SimpleDateFormat("yyyy-MM-dd HHmmss");
         
//        System.out.println(Thread.currentThread().getName()+" new formatter = "+ formatter.get().toPattern());
        System.out.println(Thread.currentThread().getName()+" new formatter = "+ fmt.toPattern());
    }
 
}
