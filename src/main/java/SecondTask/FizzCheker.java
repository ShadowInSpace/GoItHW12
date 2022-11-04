package SecondTask;

public class FizzCheker implements Runnable, FizzBuzzChek {
    int n;
    boolean updated = false;

    @Override
    public void run() {
        while (true) {
            try {
                if (updated) {
                    updated = false;
                    if (n % 3 == 0 && n % 5 != 0) {
                        SecondTask.queue.put("fizz");
                    }
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
