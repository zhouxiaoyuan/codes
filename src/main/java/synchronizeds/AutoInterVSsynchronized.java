package synchronizeds;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description AutoInterVSsynchronized
 * @Created by Administrator on 2021/3/23 9:51
 */
public class AutoInterVSsynchronized {

    int count = 10000;

    @Test
    public void testType(){

        ArrayList list = new ArrayList();
        list.getClass();

        System.out.println( AutoInterVSsynchronized.class.getName() );

    }

    @Test
    public void testInteger(){
        Integer i = 0 ;
        changeInteger(i);
        System.out.println(i);
    }

    private void changeInteger(Integer i) {
        i = new Integer(123);
    }

    @Test
    public void testAutoInteger() throws InterruptedException {
       long T1 =  System.currentTimeMillis();
        AtomicInteger integer = new AtomicInteger(0);
        CountDownLatch cdl = new CountDownLatch(2);
       for( int i = 0 ; i < 2 ; i++ ){
         new Thread(()->{
             for(int  j = 0 ; j < count ; j++ ){
                 integer.getAndAdd(1);
             }
             cdl.countDown();
         }).start();
       }

       cdl.await();
        System.out.println( "result:" + integer.get() );
       long T2 =  System.currentTimeMillis();
        System.out.println( T2 - T1);
    }

    @Test
    public void testSynchronied() throws InterruptedException {
        long T1 =  System.currentTimeMillis();
        Integer integer = 0;
        Object o = new Object();
        CountDownLatch cdl = new CountDownLatch(2);

        for( int i = 0 ; i < 2 ; i++ ){
            new AddThread(o,integer,cdl).start();
        }

        cdl.await();
        System.out.println( "result:" + integer );
        long T2 =  System.currentTimeMillis();
        System.out.println( T2 - T1);
    }


}

class AddThread extends Thread{
    Integer init;
    Object o ;
    CountDownLatch cdl;

    public AddThread(Object o ,Integer init,CountDownLatch cdl){
        this.o = o;
        this.init = init;
        this.cdl = cdl;
    }

    @Override
    public void run(){
        synchronized (o){
            for(int  j = 0 ; j < 10000 ; j++ ){
                init++;
            }
            cdl.countDown();
        }
    }
}
