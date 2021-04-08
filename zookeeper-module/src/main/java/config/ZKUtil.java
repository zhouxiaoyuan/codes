package config;

import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @Description ZKUtil
 * @Created by Administrator on 2021/4/8 17:36
 */
public class ZKUtil {

    private  static ZooKeeper zk;

    private static String address = "172.16.17.52:2181,172.16.17.53:2181,172.16.17.54:2181";

    private static DefaultWatch watch = new DefaultWatch();

    private static CountDownLatch init  =  new CountDownLatch(1);
    public static ZooKeeper  getZK(){

        try {
            zk = new ZooKeeper(address,1000,watch);
            watch.setCc(init);
            init.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return zk;
    }
}
