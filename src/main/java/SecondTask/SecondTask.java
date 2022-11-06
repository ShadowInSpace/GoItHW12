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

        FizzCheker fizzCheker = new FizzCheker(queue);
        BuzzCheker buzzCheker = new BuzzCheker(queue);
        FizzBuzzCheker fizzBuzzCheker = new FizzBuzzCheker(queue);
        NumberCheker numberCheker = new NumberCheker(queue);
        MyConsumerD myConsumerD = new MyConsumerD(queue);
        ExecutorService executor = Executors.newFixedThreadPool(5);
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
                Thread.sleep(10);
            }
        }
        Thread.sleep(10);
        fizzCheker.finish();
        buzzCheker.finish();
        fizzBuzzCheker.finish();
        numberCheker.finish();
        myConsumerD.finish();
        executor.shutdown();



    }
}
