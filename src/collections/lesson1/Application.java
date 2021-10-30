package collections.lesson1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Application {
    public static void main(String[] args) {
//        ArrayList words = new ArrayList();
//        words.add("hello");
//        words.add("there");
//        words.add(10);
//        words.add(9);
//        words.add(12.00);
//        words.add('H');
//
//        Object odjItem = words.get(0);
//        String item = (String) words.get(0);
//
//        int item1 = (int) words.get(2);
//        int item2 = (int) words.get(3);
//        System.out.println(item1 + item2);

        ArrayList<String> words = new ArrayList<>();
        words.add("hello");
        words.add("there");
        words.add("10");

        String item = words.get(2);
        System.out.println(item);

        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(100);
        numbers.add(200);
        numbers.add(45);
        numbers.add(1000);
        numbers.remove();   //numbers.removeFirst();

        for (int number : numbers)
            System.out.println(number);
    }
}
