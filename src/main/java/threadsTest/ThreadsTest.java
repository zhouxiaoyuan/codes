package threadsTest;

import org.junit.Test;
import sun.misc.Contended;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description ThreadsTest
 * @Created by Administrator on 2021/3/24 9:00
 */

class Count{
    int c = 0 ;
    public void inc(){
        c++;
    }
    public void dec(){
        c--;
    }
    public int get(){
        return c;
    }
}

class ManyThread1 extends Thread{
    Thread t2;
    Count c;
    public ManyThread1( Thread t2 , Count c){
        this.t2 = t2;
        this.c = c;
    }
    @Override
    public void run(){
        int mm ;
        while (true){
            if ( (mm=c.get()&1) == 0 ){
                System.out.println("1----------->A");
                c.inc();
                try {
                    if(t2!=null){
                        t2.notify();
                    }
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
class ManyThread2 extends Thread{
    Thread t2;
    Count c;

    @Contended
    long l1;

    public ManyThread2( Thread t2 , Count c){
        this.t2 = t2;
        this.c = c;
    }
    @Override
    public void run(){
        int mm ;
        while(true){
            if ( (mm=c.get()&1) == 1 ){
                System.out.println("2----------->B");
                c.inc();
                try {
                    if(t2!=null){
                        t2.notify();
                    }
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ThreadsTest {

    @Test
    public void synchronizedTest(){
        CountDownLatch cdl = new CountDownLatch(2);
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = null, t2 = null;
        Count c = new Count();

        t1 = new ManyThread1(t2,c);
        t2 = new ManyThread1(t1,c);

        while( t1 == null || t2 == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t1.start();
        t2.start();

        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }



    /**
     * t.join  加入t线程，需要等待t线程执行完毕才能继续执行
     */
    @Test
    public void join(){

        CountDownLatch cdl = new CountDownLatch(2);
        Thread t1 = new Thread(()->{
            int i = 0 ;
            while(i  < 10){
                i++;
                System.out.println("i am thread t1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            cdl.countDown();
            System.out.println("t1 finish");

        });

       Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int  i = 0 ;
            while( i < 10 ){
                i++;
                System.out.println("i am thread t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cdl.countDown();

        });

        t1.start();
        t2.start();

        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void yieldTest(){
        new Thread(()->{
            for(int i  = 0 ; i < 1000000; i++){
//                System.out.println(i);
                if(i == 100){
                    System.out.println(System.currentTimeMillis() + "---" +i);
                    Thread.yield();
                    System.out.println(System.currentTimeMillis() + "---" +"what i do");
                }
            }
        }).start();


        new Thread(()->{
            while(true){
                System.out.println("thread ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
    }




}
