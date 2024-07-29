import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int roundsWon = 0;

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            boolean hasGuessedCorrectly = false;
            int attempts = 0;

            System.out.println("Guess the number between 1 and 100!");

            while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Correct! You've guessed the number.");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                } else if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game over! You've won " + roundsWon + " round(s).");
        scanner.close();
    }
}
