package concurrency.lesson5;

import java.util.List;

public class Consumer implements Runnable{
    List<Integer> questionList;

    public Consumer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    public void answerQuestion() throws InterruptedException {
        synchronized (questionList) {
            while (questionList.isEmpty()) {
                System.out.println("No Question to Answer... Waiting for producer to get questions");
                questionList.wait();
            }
        }

        synchronized (questionList) {
            Thread.sleep(5000);
            System.out.println("ANSWERED Question: " + questionList.remove(0));
            questionList.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                answerQuestion();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
