import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 15;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int attempts = 0;
            int correctNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            boolean found = false;

            System.out.println("Round " + (roundsWon + 1) + ": You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.println("Guess a number between " + minRange + " and " + maxRange + ":");
                int guess = sc.nextInt();
                attempts++;

                if (guess < correctNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > correctNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    roundsWon++;
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + correctNumber + ".");
            }

            System.out.println("Do you want to play another round? (yes/no)");
            String playAgain = sc.next().toLowerCase();

            if (playAgain.equals("no")) {
                break;
            }
        }

        System.out.println("You won " + roundsWon + " rounds!");
        double score = (double) roundsWon * 100 / (roundsWon + 1); 
        System.out.println("Your score: " + score + "%");
        System.out.println("Thanks for playing!");
    }
}
