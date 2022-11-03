package firstTask;

import java.util.concurrent.TimeUnit;

public class OneSecondOut implements Runnable {
    long startTime = System.nanoTime();

    public void run() {
        long currentTime = System.nanoTime();
        long totalTime = currentTime - startTime;
        System.out.println("Time from start " + TimeUnit.NANOSECONDS.toSeconds(totalTime));
    }

}
