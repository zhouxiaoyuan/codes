import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {


    public static void main(String[] args) throws InterruptedException {


        final ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                lock.lock();
                try{
                    System.out.println("线程1拿到锁了");
                    Thread.sleep(1200);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        };

        t1.start();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                lock.lock();
                try{
                    System.out.println("线程2拿到锁了");
                    Thread.sleep(1200);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        };

        t2.start();

        t1.interrupt();

        Thread.sleep(2000);






        /*Thread t = new Thread(){
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t.start();

        t.interrupt();*/

        while(true){

        }

//        ReentrantLock lock = new ReentrantLock();

    }
}
