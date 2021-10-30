package concurrency.lesson2;

public class Application {
    public static void main(String[] args) {
        System.out.println("Starting Thread 1");
        Thread t1 = new Thread(new Task("Thread-A"));
        t1.start();

        System.out.println("Starting Thread 2");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread-B");
                for (int i = 0; i < 10; i++) {
                    System.out.println("number: " + i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();
    }
}

class Task implements Runnable {
    String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        for (int i = 0; i < 10; i++) {
            System.out.println("number: " + i + " - " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
