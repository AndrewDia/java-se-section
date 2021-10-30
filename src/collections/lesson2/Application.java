package collections.lesson2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add("Lion");
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Bird");

//        for (int i = 0; i < animals.size(); i++)
//            System.out.println(animals.get(i));
//        for (String animal : animals)
//            System.out.println(animal);

        List<Vehicle> vehicles = new LinkedList<>();
        Vehicle vehicle = new Vehicle("Toyota", "Camry", 12000, false);
        vehicles.add(new Vehicle("Honda", "Accord", 12000, false));
        vehicles.add(vehicle);
        vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));

        printElements(vehicles);
        printElements(animals);
    }

    public static void printElements(List list) {
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
