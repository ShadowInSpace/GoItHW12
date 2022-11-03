package SecondTask;

public class MyConsumerD implements Runnable{
    @Override
    public void run() {
        while (true) {
            while (!SecondTask.queue.isEmpty()) {
                System.out.println(SecondTask.queue.poll());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
