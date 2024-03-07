import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int start = 1;
        int end = 100;
        int maxAttempts = 5;
        int score = 0;

        while (true) {
            System.out.println("\nWelcome to the Guessing Game!");

            int secretNumber = generateNumber(random, start, end);
            boolean won = playGame(scanner, random, secretNumber, maxAttempts);

            if (won) {
                score++;
                System.out.println("Your current score is " + score + ".");
            } else {
                System.out.println("You have lost this round. The correct number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("y")) {
                break; 
            }
        }

        System.out.println("\nThanks for playing!");
        scanner.close();
    }

    private static int generateNumber(Random random, int start, int end) {
        return random.nextInt(end - start + 1) + start;
    }

    private static boolean playGame(Scanner scanner, Random random, int secretNumber, int maxAttempts) {
        System.out.println("Guess the number between " + 1 + " and " + 100 + ". You have " + maxAttempts + " attempts.");
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Attempt " + attempt + ": ");
            int userGuess = scanner.nextInt(); 
            scanner.nextLine(); 

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You've guessed the correct number!");
                return true; 
            } else if (userGuess < secretNumber) {
                System.out.println("The secret number is higher than " + userGuess + ".");
            } else {
                System.out.println("The secret number is lower than " + userGuess + ".");
            }
        }
        
        return false;
    }

   
}
