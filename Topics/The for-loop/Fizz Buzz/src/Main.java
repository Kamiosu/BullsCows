
import java.util.Scanner;

class App2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            for (;start < end+1; start++){

                if (start % 3 == 0 && start % 5 != 0){
                    System.out.println("Fizz");
                } else if (start % 3 != 0 && start % 5 == 0){
                    System.out.println("Buzz");
                } else if (start % 3 == 0 && start % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else {
                    System.out.println(start);
                }


            }
        }

    }
}