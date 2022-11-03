package firstTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FirstTask {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(new OneSecondOut(),1,1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(new FiveSecondsOut(),5,5, TimeUnit.SECONDS);
    }
}
