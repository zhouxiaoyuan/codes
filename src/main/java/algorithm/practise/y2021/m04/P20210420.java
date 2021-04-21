package algorithm.practise.y2021.m04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @Description algorithm.practise.y2021.m04.P20210420
 * @Created by zhouxiaoyuan on 2021/4/20 8:25
 */
public class P20210420 {

    public static void main(String[] args) {

//        Boolean b ;
//        System.out.println((b=Boolean.FALSE).equals(null));

//        ExecutorService
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 1, TimeUnit.MINUTES,new LinkedBlockingQueue<>());
        List list = new ArrayList<String>();
        Map map = new HashMap<String,String>();
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(()->{
                while(true){
                    System.out.println(Thread.currentThread().getName());
                    map.put(Thread.currentThread().getName(), Thread.currentThread().getName());
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            });
        }



    }
}
