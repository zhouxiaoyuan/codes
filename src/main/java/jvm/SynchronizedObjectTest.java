package jvm;
import org.openjdk.jol.info.ClassLayout;
import java.util.concurrent.CountDownLatch;
/**
 * @Description SynchronizedObjectTest
 * @Created by Administrator on 2021/3/22 9:08
 */
public class SynchronizedObjectTest {

    @org.junit.Test
    public void test1(){
        int[] ints = {1,4,5,6,7,8,6,6,6,6,6,6,6,6,6,6,6};
        System.out.println(ClassLayout.parseInstance(ints).toPrintable());
    }

    public static void main(String[] args) throws InterruptedException {
        Test o = new Test();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());




        CountDownLatch cdl = new CountDownLatch(2);

        for( int i = 0 ; i < 2 ; i++ ){
            Thread t = new Thread(()->{
                synchronized (o){
                    System.out.println(ClassLayout.parseInstance(o).toPrintable());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            cdl.countDown();
        }
        cdl.await();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}

class Test{
    int x;
    long y;
}
