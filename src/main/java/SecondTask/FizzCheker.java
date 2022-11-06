package SecondTask;

import java.util.concurrent.BlockingQueue;

public class FizzCheker implements Runnable, FizzBuzzChek {
    int n;
    boolean updated = false;

    public BlockingQueue<String> lQueue;

    public FizzCheker(BlockingQueue<String> lQueue) {
        this.lQueue = lQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (updated) {
                    updated = false;
                    if (n % 3 == 0 && n % 5 != 0) {
                        lQueue.put("fizz");
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Override
    public void setN(int n) {
        this.n = n;
        updated = true;
    }

    @Override
    public boolean isUpdated() {
        return updated;
    }

}
