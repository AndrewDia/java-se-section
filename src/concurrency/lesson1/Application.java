package concurrency.lesson1;

public class Application {
    public static void main(String[] args) {
        Task taskRunner = new Task();
        taskRunner.start();

        System.out.println("hello there...");

        Task newTaskRunner = new Task();
        newTaskRunner.start();
    }
}

class Task extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++)
            System.out.println("number: " + i);
    }
}
