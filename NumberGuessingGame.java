import java.util.*;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerRange = 1;
        int upperRange = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int totalRounds = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int numberToGuess = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("I have selected a number between " + lowerRange + " and " + upperRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Attempt #" + (attempts + 1) + ": Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    totalRounds++;
                    hasGuessedCorrectly = true;
                    break;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        double averageAttemptsPerRound = (double) totalAttempts / totalRounds;
        System.out.println("Thanks for playing! You played " + totalRounds + " rounds, and your average attempts per round was " + String.format("%.2f", averageAttemptsPerRound) + ".");
        
        scanner.close();
    }
}

