import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int small = 0;
        int large = 0;
        int perfect = 0;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++ ){
            int size = scanner.nextInt();
            if (size == -1){
                small += 1;
            } else if (size == 1) {
                large += 1;
            } else if (size == 0){
                perfect += 1;
            }
        }
        String output = String.format("%d %d %d", perfect, large, small);
        System.out.println(output);
    }
}