import java.util.Scanner;
import java.util.Arrays;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        String[] newStrings = new String[strings.length] ;
        for (int i = 0; i < strings.length; i++ ) {
            String newString = strings[i].replaceAll("\\d","");
            newStrings[i] = newString;
        }


        return String.join("", newStrings);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        //System.out.print(Arrays.toString(strings));
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}