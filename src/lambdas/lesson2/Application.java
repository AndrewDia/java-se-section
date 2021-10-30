package lambdas.lesson2;

public class Application {
    public static void main(String[] args) {
        ALambdaInterface helloVar = () -> System.out.println("Hello there!");
        helloVar.someMethod();

        Calculate sumVar = (a, b) -> a + b;
        System.out.println(sumVar.compute(4, 6));

        Calculate nonZeroDivider = (a, b) -> {
            if (a == 0 || b == 0)
                return 0;
            return a / b;
        };
        System.out.println(nonZeroDivider.compute(10, 5));

//        StringWorker reverser = (s) -> {
        MyGenericInterface<String> reverser = (s) -> {
            String result = "";
            for (int i = s.length() - 1; i >= 0; i--)
                result += s.charAt(i);
            return result;
        };
        System.out.println(reverser.work("vehicle"));

//        NumberWorker computedNumber = (n) -> {
        MyGenericInterface<Integer> computedNumber = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++)
                result *= i;
            return result;
        };
        System.out.println(computedNumber.work(10));
    }

    public void sayHello() {
        System.out.println("Hello there!");
    }

    public int sum(int arg1, int arg2) {
        return arg1 + arg2;
    }

    public int nonZeroDivide(int arg1, int arg2) {
        if (arg1 == 0 || arg2 == 0)
            return 0;
        return arg1 / arg2;
    }

    public String reverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);
        return result;
    }

    public int factorial(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++)
            result *= i;
        return result;
    }
}

interface ALambdaInterface {
    void someMethod();
}

interface Calculate {
    int compute(int a, int b);
}

interface StringWorker {
    String work (String str);
}

interface NumberWorker {
    int work(int num);
}

interface MyGenericInterface<T> {
    T work(T t);
}