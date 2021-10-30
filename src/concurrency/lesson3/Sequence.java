package concurrency.lesson3;

public class Sequence {
    private int value = 0;
    private int syncValue = 0;

    public int getNext() {
        return ++value;
    }

    public synchronized int getNextSync() {
        return ++syncValue;
    }
}
