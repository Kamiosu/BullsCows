import java.util.*;
import java.util.Random;
import java.util.ArrayList;
//10 100 1000 1000

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer a = scanner.nextInt(); // Starting seed
        Integer b = scanner.nextInt(); // Ending seed
        Integer n = scanner.nextInt(); // N Numbers
        Integer k = scanner.nextInt(); // Range (0, K)
        scanner.close();
        // Create a 2D array to store the random numbers generated by each seed
        Integer[][] randomArray = new Integer[b - a + 1][n]; // Should be inclusive of B
        Integer[] seedMax = new Integer[b - a + 1];

        // For each seed in the range A to B
        for (int i = 0; i < b - a + 1; i++) {
            // Create new random object with the i th seed
            // Creating it outside the loop will generate different numbers for each seed
            Random random = new Random(i + a); // Add A to get the correct seed
            // Generate N random numbers using the i th seed
            for (int j = 0; j < n; j++) {

                randomArray[i][j] = random.nextInt(k);
                // System.out.println(randomArray[i][j]);

            }

            // Use max method to find the maximum number generated by the i th seed
            seedMax[i] = max(randomArray[i]);

        }

        // System.out.println(Arrays.toString(seedMax));
        // maximum of these N numbers to be the minimum among all maximums of other
        // seeds in this range.
        Integer minValue = min(seedMax);

        // Find the seed that generated the minimum among all maximums of other seeds in
        // this range.
        // Since the array is in assending order, we can use arrayList to find the first
        // index of the minimum value

        Integer correctSeed = Arrays.binarySearch(seedMax, minValue);
        ArrayList<Integer> list = new ArrayList<Integer>();
        // Append the array to the list to use the indexOf method
        for (int i = 0; i < seedMax.length; i++) {
            list.add(seedMax[i]);
        }
        correctSeed = list.indexOf(minValue);
        System.out.println(correctSeed + a); // Add A to get the correct seed
        System.out.println(minValue);

    }

    public static Integer max(Integer[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static Integer min(Integer[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

}