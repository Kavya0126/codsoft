import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        Scanner playAgainScanner = new Scanner(System.in);
        do {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nI have generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            int score = 0; // Initialize score for each round

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("\nEnter your guess (Attempt " + attempt + "): ");
                int userGuess = playAgainScanner.nextInt();
                playAgainScanner.nextLine(); // Consume the newline character

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + generatedNumber + " in " + attempt + " attempts.");
                    score++;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                if (attempt == maxAttempts) {
                    System.out.println("Sorry, you ran out of attempts. The correct number was: " + generatedNumber);
                }
            }

            totalScore += score; // Update the total score

            System.out.print("\nDo you want to play again? (yes/no): ");

        } while (playAgainScanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your final score is: " + totalScore);

        playAgainScanner.close();
    }
}





