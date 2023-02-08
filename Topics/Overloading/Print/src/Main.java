import java.util.Scanner;

public class Main {

    public static void print(String strArg) {
        System.out.println("print(\"" + strArg + "\")");
    }

    public static void print(String strArg2, int intArg) {

        //System.out.print("print(\"" + strArg2 + "\", " + intArg + ")");
        System.out.print(String.format("print(\"%s\", %d)", strArg2, intArg));
    } 

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int val = scanner.nextInt();
        print(str);
        print(str, val);
    }
}
