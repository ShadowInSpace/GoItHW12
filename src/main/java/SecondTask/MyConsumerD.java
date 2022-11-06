package SecondTask;

import java.util.concurrent.BlockingQueue;

public class MyConsumerD implements Runnable{
    public BlockingQueue<String> lQueue;

    public MyConsumerD(BlockingQueue lQueue) {
        this.lQueue = lQueue;
    }

    @Override
    public void run() {
        while (true) {
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
