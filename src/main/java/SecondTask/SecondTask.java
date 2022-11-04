package SecondTask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class SecondTask {
    public SecondTask() {
        queue = new LinkedBlockingQueue<>();
    }
//Зараз оголошую чергу тут \/ а створюю в конструкторі /\.
     public static BlockingQueue<String> queue;
    public void fizzBuzzIt(int n) throws InterruptedException {

        FizzCheker fizzCheker = new FizzCheker();
        BuzzCheker buzzCheker = new BuzzCheker();
        FizzBuzzCheker fizzBuzzCheker = new FizzBuzzCheker();
        NumberCheker numberCheker = new NumberCheker();
        MyConsumerD myConsumerD = new MyConsumerD();
        ExecutorService executor = Executors.newFixedThreadPool(6);
        executor.execute(fizzCheker);
        executor.execute(buzzCheker);
        executor.execute(fizzBuzzCheker);
        executor.execute(numberCheker);
        executor.execute(myConsumerD);

        for (int i = 1; i <= n; i++) {
            fizzCheker.setN(i);
            buzzCheker.setN(i);
            fizzBuzzCheker.setN(i);
            numberCheker.setN(i);
            while (fizzCheker.isUpdated() || buzzCheker.isUpdated() || fizzBuzzCheker.isUpdated() || numberCheker.isUpdated()){
                Thread.sleep(100);
            }
        }



    }
}
