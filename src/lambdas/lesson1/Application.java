package lambdas.lesson1;

public class Application {
    public static void main(String[] args) {
//        walker(new Walkable() {
//            @Override
//            public void walk() {
//                System.out.println("Custom object walking...");
//            }
//        });
        walker(() -> System.out.println("Custom object walking..."));

        Walkable aBlockOfCode = () -> {
            System.out.println("Custom object walking...");
            System.out.println("the object tripped...");
        };
        walker(aBlockOfCode);
    }

    public static void walker(Walkable walkableEntity) {
        walkableEntity.walk();
    }
}
