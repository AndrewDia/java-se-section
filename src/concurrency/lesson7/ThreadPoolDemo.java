package concurrency.lesson7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2); // recycle threads
        Runnable processor1 = new MessageProcessor(2);
        executor.execute(processor1);
        Runnable processor2 = new MessageProcessor(3);
        executor.execute(processor2);
        Runnable processor3 = new MessageProcessor(4);
        executor.execute(processor3);
        Runnable processor4 = new MessageProcessor(5);
        executor.execute(processor4);
        executor.shutdown(); // Rejects any new task from being submitted. Gratefully shuts down the service.
//        executor.shutdownNow(); // Terminate the executor service immediately.
//        while (!executor.isTerminated()) {}

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("submitted all tasks...");
    }
}
