package bullscows;

//import java.util.Collections;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.LinkedHashSet;
//javac -d . bullCows.java && java bullsCows.bullCows
// import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = 0;
        int charNum = 0;
        try {
            System.out.println("Input the length of the secret code:");
            n = scanner.nextInt();
            System.out.println("Input the number of possible symbols in the code:");
            charNum = scanner.nextInt();
        }
        catch (Exception e){
            System.out.print("Error:");
            System.out.print(e.getMessage());
        }

        //______
        //

        char[] charArray = { '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z' };

        // Check if the input is valid
        if (n > 36) {

            System.out.println(
                    "Error: can't generate a secret number with a length of 36 because there aren't enough unique digits and characters.");

            scanner.close();
            return;
        }

        if (charNum > 36) {
            System.out.println(
                    "Error: can't generate a secret number with more than 36 unique symbols.");
            scanner.close();
            return;
        }

        if (n < 1 || charNum < 1) {
            System.out.println("Error: can't generate a secret number with a length of 0.");
            scanner.close();
            return;
        }

        // If number of character given is less then the number required
        if (n > 10 && charNum < n - 10) {
            System.out.println("Error: can't generate a secret number with not enough unique symbols.");
            scanner.close();
            return;
        }


        if (charNum < n ) {
            System.out.println("Error: can't generate a secret number with not enough unique symbols.");
            scanner.close();
            return;
        }

        // Get the secret number from n digits
        // String secretNumber = oldGenerator(n);
        String secretNumber = generator(n, charNum);

        // System.out.println(secretNumber);
        String[] secretNumberArray = secretNumber.split("");

        System.out.print("The secret is prepared: ");

        // Print the secret number
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }

        // Casting the charNum to a char to print the range ASCII
        // Print out the number of characters used in the secret number
        // 0 - 9 if charNum is less than 10
        // 0 - 9 and a - z if charNum is greater than 10

        if (charNum <= 10) {
            System.out.println(" (0-" + (charNum - 1) + ").");
        } else {
            System.out.println(" (0-9, a-" + charArray[charNum - 1] + ").");
        }

        System.out.println("Okay, let's start a game!");

        boolean gameWon = false;
        int turnCounter = 1;
        while (gameWon == false) {
            // Print the turn number
            System.out.println("Turn: " + turnCounter);

            String guess = scanner.next();

            // If the guess is // print the secret number
            if (guess.equalsIgnoreCase("//")) {
                System.out.print(Arrays.toString(secretNumberArray));
            }
            // Check if the guess is the correct length
            if (guess.length() != n) {
                System.out.println("Error: the length of the guess should be " + n);
                continue;
            }

            String[] guessArray = guess.split("");
            String grade = grader(secretNumberArray, guessArray, n);

            System.out.println(grade);

            if (grade.contains(String.format("%d bull", n))) {
                gameWon = true;
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
            turnCounter++;
        }
        scanner.close();

    }

    public static String generator(int intInput, int charNum) {
        /*
         * Takes in the length and the number of characters used
         * Allows 0 as the starting number, can range a - nChars
         * Just use arrays
         *
         */
        Random rand = new Random();
        char[] secretArray = new char[intInput];

        char[] charArray = { '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z' };

        // List<Character> secretList = secretArray.asList();

        // Used set to keep track of used numbers
        Set<Integer> usedChars = new HashSet<>();

        // Gnerate the secret code
        for (int i = 0; i < intInput; i++) {
            boolean empty = true;
            while (empty == true) {

                // If i is full. default statement
                if (secretArray[i] != '\u0000') {
                    empty = false;
                    break;
                }
                // Between the two choices, pick a random number, number or symbol

                int randNum = rand.nextInt(charNum);
                // Continue to generate a random number until it is unique
                while (usedChars.contains(randNum)) {
                    System.out.println("Dulicate character");
                    randNum = rand.nextInt(charNum);
                }
                // Add the random number to the array
                secretArray[i] = charArray[randNum];
                // Add the used number to the set
                usedChars.add(randNum);

            }

        }

        // Convert the array to a string
        String result = Arrays.toString(secretArray);
        // Remove the brackets
        result = result.substring(1, result.length() - 1);
        // Replace the commas with spaces
        result = result.replaceAll(",", "");
        // Replace the spaces with nothing
        String secretCode = result.replaceAll(" ", "");
        return secretCode;
    }

    public static String oldGenerator(int intInput, int charNum) {
        /*
         * Takes in the length and the number of characters used
         * Allows 0 as the starting number, can range a - nChars
         * Just use arrays
         *
         */
        Random rand = new Random();
        char[] secretArray = new char[intInput];

        // List<Character> secretList = secretArray.asList();
        char[] numsArray = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z' };

        // Used set to keep track of used numbers
        Set<Integer> usedNums = new HashSet<>();
        Set<Character> usedChars = new HashSet<>();

        // Gnerate the secret code
        for (int i = 0; i < intInput; i++) {
            boolean empty = true;
            while (empty == true) {

                // If i is full.
                if (secretArray[i] != '\u0000') {
                    empty = false;
                    break;
                }

                int randInt = rand.nextInt(2);
                // Between the two choices, pick a random number, number or symbol
                if (randInt == 0 && usedNums.size() != 10) {

                    int randNum = rand.nextInt(10);
                    // Continue to generate a random number until it is unique
                    while (usedNums.contains(randNum)) {
                        System.out.println("Duplicate number");
                        randNum = rand.nextInt(10);
                    }
                    // Add the random number to the array
                    secretArray[i] = numsArray[randNum];
                    // Add the used number to the set
                    usedNums.add(randNum);

                } else if (randInt == 1 && usedChars.size() != charNum) {

                    int randNum2 = rand.nextInt(charNum);
                    // Continue to generate a random number until it is unique
                    while (usedChars.contains(charArray[randNum2])) {
                        System.out.println("Duplicate character");
                        randNum2 = rand.nextInt(charNum);
                    }
                    // Add the random character to the array
                    secretArray[i] = charArray[randNum2];
                    // Add the used character to the set
                    usedChars.add(charArray[randNum2]);
                }

            }
        }

        // Convert the array to a string
        String result = Arrays.toString(secretArray);
        // Remove the brackets
        result = result.substring(1, result.length() - 1);
        // Replace the commas with spaces
        result = result.replaceAll(",", "");
        // Replace the spaces with nothing
        String secretCode = result.replaceAll(" ", "");
        return secretCode;

    }

    public static String grader(String[] secretNumberArray, String[] guessArray, int lengthOfCode) {
        // System.out.println(Arrays.toString(secretNumberArray));
        // System.out.println(Arrays.toString(guessArray));
        int bullCounter = 0;

        int cowCounter = 0;

        for (int i = 0; i < lengthOfCode; i++) { // For the guess array

            for (int j = 0; j < lengthOfCode; j++) { // For the secret character array

                if (i == j && guessArray[i].equals(secretNumberArray[j])) { // Runs a general search to see if there are
                    // correct guesses
                    bullCounter += 1;

                } else if (guessArray[i].equals(secretNumberArray[j])) { // Runs a general search to see if there are
                    // correct
                    // guesses
                    cowCounter += 1;

                }
            }
        }

        // String secretCode = String.join("", secretNumberArray); // 4198
        // Printing the grade to the console
        // Bulls and cows exist

        // Switch statements
        String bullCowGrade = String.format("Grade: %d bull(s) and %d cow(s).", bullCounter,
                cowCounter);

        // Only hit bulls
        String bullGrade = String.format("Grade: %d bull(s).", bullCounter);

        // Only hit cows
        String cowGrade = String.format("Grade: %d cow(s).", cowCounter);

        // Hit nothing
        String noneGrade = String.format("Grade: None.");

        if (cowCounter > 0 && bullCounter > 0) {
            return bullCowGrade;
        }

        else if (cowCounter == 0 && bullCounter > 0) {
            return bullGrade;
        }

        else if (cowCounter > 0 && bullCounter == 0) {
            return cowGrade;
        }
        return noneGrade;

    }

}
