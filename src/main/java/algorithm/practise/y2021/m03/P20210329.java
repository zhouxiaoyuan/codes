package algorithm.practise.y2021.m03;

import sun.misc.Unsafe;

import java.sql.Time;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Description P20210329
 * @Created by Administrator on 2021/3/29 9:38
 */
public class P20210329 {

    public static final Object o = new Object();
    LinkedList linkList = new LinkedList<>();


    static boolean breakFlag = false;

    private static final Unsafe unsafe = Unsafe.getUnsafe();


    CopyOnWriteArrayList list = new CopyOnWriteArrayList();


    public static void main(String[] args) throws InterruptedException {
        boolean breakFlag = false;
        Thread t1 = new T1();


        t1.start();
        breakFlag = true;
        while (true){
            TimeUnit.SECONDS.sleep(1);
        }
    }



}

class T1 extends  Thread{
    boolean breakFlag = false;
    @Override
    public void run(){
        System.out.println("start");
        while(!breakFlag){

        }
        System.out.println("end");
    }
}
