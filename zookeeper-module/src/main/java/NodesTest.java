import config.ZKUtils;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description NodesTest
 * @Created by Administrator on 2021/4/9 9:03
 */
public class NodesTest {

    ZooKeeper zk;

    String testPath = "createTest";

    @Before
    public void before(){
        zk = ZKUtils.getZK(testPath);
    }

    @After
    public void after(){
        try{
            zk.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test(){

        CallBackTest cb = new CallBackTest();

        Stat stat = new Stat();
        try{
            byte[]  bs = zk.getData("/", cb, stat);
            System.out.println( "bs----------->" + new String(bs) );
        }catch (Exception e){
            e.printStackTrace();;
        }

        Stat ss = new Stat();
        try{
            byte[] bb = zk.getData("/node3", false, ss);
            System.out.println(bb);
            zk.delete("/node3",-1);
        }catch (Exception e){
            e.printStackTrace();
        }


        zk.exists("", true, cb, "");

//        zk.create("/lock","lock".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL,cb,"abc");

        for(int i = 0 ; i < 100000 ; i++){
            try{
                String s = "/node" + i + "";
                Stat stat1 = new Stat();
//                zk.create(s, s.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//                zk.create(s,"node".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT,cb,"abc");
                zk.getData(s, cb, stat1);
                zk.delete(s,stat1.getVersion());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        while(true){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}

class CallBackTest implements Watcher,AsyncCallback.DataCallback , AsyncCallback.StatCallback ,AsyncCallback.Create2Callback{
    @Override
    public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
        if(bytes.length > 0 ){
            String ss = new String(bytes);
            System.out.println(ss);
        }
    }

    @Override
    public void processResult(int i, String s, Object o, Stat stat) {

    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }

    @Override
    public void processResult(int i, String s, Object o, String s1, Stat stat) {
        System.out.println("----------->" + s + "---" + s1 );
    }
}