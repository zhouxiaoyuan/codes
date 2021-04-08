import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description ZookeeperTest
 * @Created by Administrator on 2021/4/8 15:53
 */
public class ZookeeperTest {

    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("172.16.17.52:2181,172.16.17.53:2181,172.16.17.54:2181", 3000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("watch");
            }
        });


        long t1 = System.currentTimeMillis();
        while(true){
            if (ZooKeeper.States.CONNECTING == zk.getState()) {
                Thread.sleep(1000);
            }else {
                break;
            }
        }
        long t2 = System.currentTimeMillis();

        System.out.println("---------------------------" + (t2-t1));

        Stat sta = new Stat();
        byte[] newData = zk.getData("/test", new Watcher(){
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println( "----->" + watchedEvent.getType() );
                try {
                    byte[] newData =  zk.getData("/test", this, sta);
                    System.out.println(" get data---->" + new String(newData));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },sta);
        if( newData != null ){
            System.out.println(" get data---->" + new String(newData));
        }


        zk.setData("/test", "hello".getBytes(), sta.getVersion());

        //zk.getData("/test", "olddata".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        while(true){
            Thread.sleep(1000);
        }

    }
}
