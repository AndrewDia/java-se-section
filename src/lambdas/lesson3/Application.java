package lambdas.lesson3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("Honda", "Accord", "Red", 22300),
                new Car("Honda", "Civic", "Blue", 17700),
                new Car("Toyota", "Land Cruiser", "White", 48500),
                new Car("Toyota", "Corolla", "Black", 16200),
                new Car("Toyota", "Camry", "Blue", 24000),
                new Car("Nissan", "Sentra", "White", 17300),
                new Car("Mitsubishi", "Lancer", "White", 20000),
                new Car("Jeep", "Wrangler", "Red", 24500)
        );
//        printCarsPriceRange(cars, 18000, 22000);
//        printCarsByColor(cars, "Blue");
        System.out.println("Printing cars between price 18000 and 22000");
        printCars(cars, (c) -> c.getPrice() >= 18000 && c.getPrice() <= 22000);
        System.out.println("Printing cars that are blue");
        printCars(cars, (c) -> c.getColour().equals("Blue"));

        Function<Car, String> priceAndColour = (c) -> "price = " + c.getPrice() + " colour = " + c.getColour();
        String stringCar = priceAndColour.apply(cars.get(0));
        System.out.println(stringCar);
    }

//    public static void printCars(List<Car> cars, Condition<Car> condition) {
//        for (Car c : cars)
//            if (condition.test(c))
//                System.out.println(c);
//    }

    public static void printCars(List<Car> cars, Predicate<Car> predicate) {
        for (Car c : cars)
            if (predicate.test(c))
                System.out.println(c);
    }

    public static void printCarsPriceRange(List<Car> cars, int low, int high) {
        for (Car c : cars)
            if (c.getPrice() >= low && c.getPrice() <= high)
                c.printCar();
    }

    public static void printCarsByColor(List<Car> cars, String color) {
        for (Car c : cars)
            if (c.getColour().equals(color))
                c.printCar();
    }
}

@FunctionalInterface
interface Condition<T> {
    boolean test(T t);
}
