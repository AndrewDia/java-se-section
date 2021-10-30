package collections.lesson4;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(12);
        set.add(43);
        set.add(15);
        set.add(67);
        set.add(43);
        set.add(10);

        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(10);
        newList.add(67);
        newList.add(15);
//        list.addAll(newList);
//        list.removeAll(newList);
//        list.retainAll(newList);
//        System.out.println(list.contains(67));
//        System.out.println(list.isEmpty());
//        list.clear();
//        System.out.println(list);

        HashSet<Employee> hashSet = new HashSet<>();
        hashSet.add(new Employee("Mike", 3500, "Accounting"));
        hashSet.add(new Employee("Paul", 3000, "Admin"));
        hashSet.add(new Employee("Peter", 4000, "IT"));
        hashSet.add(new Employee("Angel", 2000, "Maint"));

        ArrayList<Employee> myList = new ArrayList<>(hashSet);

        Collections.sort(myList);

        System.out.println(myList);
    }
}
