import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] guests = new String[4];

        for (int i = 0; i < 4; i++) {
            guests[i] = scanner.next();
        }

        for (int j = 3; j >= 0; j--) {
            System.out.println(guests[j]);

        }


    }
}
