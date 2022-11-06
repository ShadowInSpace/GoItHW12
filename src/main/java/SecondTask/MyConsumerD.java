package SecondTask;

import java.util.concurrent.BlockingQueue;

public class MyConsumerD implements Runnable{
    public BlockingQueue<String> lQueue;
    private boolean repeet = true;

    public void finish(){
        repeet = false;
    }

    public MyConsumerD(BlockingQueue lQueue) {
        this.lQueue = lQueue;
    }

    @Override
    public void run() {
        while (repeet) {
            while (!lQueue.isEmpty()) {
                System.out.println(lQueue.poll());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
