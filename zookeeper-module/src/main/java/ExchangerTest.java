import java.util.concurrent.Exchanger;

public class ExchangerTest {

    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<String>();

        Thread[] threads = new Thread[100];
        for(int i =0 ; i < 100;i++){
            threads[i] = new  ThreadExchange(exchanger,i+"");
            Thread.sleep(100);
            threads[i].start();
        }



        while(true){
            System.out.println("1231");
            Thread.sleep(1000);
        }
    }


}



class ThreadExchange extends Thread{
    Exchanger<String> exchanger;
    String s;
    public ThreadExchange(Exchanger<String> exchanger,String s){
        this.exchanger = exchanger;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            this.s = exchanger.exchange(this.s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}