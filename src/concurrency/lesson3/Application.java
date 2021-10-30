package concurrency.lesson3;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Without synchronization");
        Sequence sequence = new Sequence();
        Worker worker1 = new Worker(sequence, false);
        worker1.start();
        Worker worker2 = new Worker(sequence, false);
        worker2.start();
        worker1.join();
        worker2.join();
        System.out.println("With synchronization");
        new Worker(sequence, true).start();
        new Worker(sequence, true).start();
    }
}

class Worker extends Thread {
    Sequence sequence;
    boolean isSynchronized;

    public Worker(Sequence sequence, boolean isSynchronized) {
        this.sequence = sequence;
        this.isSynchronized = isSynchronized;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (isSynchronized)
                System.out.println(Thread.currentThread().getName() + " got value: " + sequence.getNextSync());
            else
                System.out.println(Thread.currentThread().getName() + " got value: " + sequence.getNext());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}