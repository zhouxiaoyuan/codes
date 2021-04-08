package config;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @Description WatchCallBack
 * @Created by Administrator on 2021/4/8 17:51
 */
public class WatchCallBack implements Watcher, AsyncCallback.StatCallback, AsyncCallback.DataCallback {

    ZooKeeper zk;
    MyConf conf;
    CountDownLatch cc = new CountDownLatch(1);

    public String path;

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    public void setConf(MyConf conf) {
        this.conf = conf;
    }



    public WatchCallBack(String path) {
        this.path = path;
    }

    public void await(){
        zk.exists(path, this,this,"");
        try{
            cc.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
        if(bytes != null){
            String ss = new String(bytes);
            System.out.println("--->" + ss);
            conf.setConf(ss);
            cc.countDown();
        }
    }

    @Override
    public void processResult(int i, String s, Object o, Stat stat) {
        if(stat != null){
            zk.getData(path,this,this,"sdfs");
        }
    }

    @Override
    public void process(WatchedEvent event) {
        switch (event.getType()) {
            case None:
                break;
            case NodeCreated:
                zk.getData(path,this,this,"sdfs");

                break;
            case NodeDeleted:
                //容忍性
                conf.setConf("");
                cc = new CountDownLatch(1);
                break;
            case NodeDataChanged:
                zk.getData(path,this,this,"sdfs");

                break;
            case NodeChildrenChanged:
                break;
        }

    }
}
