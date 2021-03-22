package base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description CollectionsTest
 * @Created by Administrator on 2021/3/17 11:29
 */
public class CollectionsTest {

    Thread t;


    @Test
    public void test(){
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};
        System.out.println(userNames);

        for(String s : userNames){
            if("Hollis".equals(s)){
                userNames.remove(s);
                break;
            }
        }
    }
    static  ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {


        for(int i = 0 ; i < 10000 ; i++ ){
            lock.lock();
        }


        MyThread myThread = new MyThread();

        Thread thread1 = new Thread(myThread, "thread 1");
        Thread thread2 = new Thread(myThread, "thread 2");
        Thread thread3 = new Thread(myThread, "thread 3");

        thread1.start();

        thread2.start();

        thread3.start();



    }







    @Test
    public static void test1() throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName());
        System.out.println("通过线程池创建线程");
        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
    }




}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
    }
}
