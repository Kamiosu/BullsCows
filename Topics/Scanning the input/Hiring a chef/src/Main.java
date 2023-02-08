import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int years = scanner.nextInt();
        String type = scanner.next();

        String message = String.format("The form for %s is completed. We will contact you if we need a chef who cooks %s dishes and has %d years of experience.", name, type, years);
        System.out.print(message);
    }
}
