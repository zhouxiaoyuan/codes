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
        for(int i = 0 ; i < 100000 ; i++){
            try{
                String s = "/" + i + "";
                zk.create(s, s.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//                zk.create(s,s.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,cb,s);
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