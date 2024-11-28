package ca.sheridancollege.project;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Prompter class handles user input during the game. It includes methods
 * for asking the player for their name, bets, and gameplay decisions.
 * This class ensures input validation and user-friendly interaction.
 * 
 * @author The Hai Nguyen
 * @studentID 991745555
 * @date November 27, 2024
 */
public class Prompter {

    // Shared scanner object for user input
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the player to enter their name and validates the input.
     * 
     * @return The validated name entered by the player.
     */
    public static String askPlayerName() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Validate the name using InputValidator
        while (!InputValidator.isValidName(name)) {
            System.out.print("Invalid input. Please enter your name: ");
            name = scanner.nextLine();
        }

        return name; // Return the validated name
    }

    /**
     * Asks the player if they want to play again and validates their response.
     * 
     * @return The player's response ("yes" or "no").
     */
    public static String askPlayerToPLayAgain() {
        System.out.print("Do you want to play again? (Yes/No): ");
        String userAnswer = scanner.next().toLowerCase();

        // Validate the response
        while (!InputValidator.isYesOrNo(userAnswer)) {
            System.out.print("Invalid input. Please enter Yes or No: ");
            userAnswer = scanner.next().toLowerCase();
        }

        return userAnswer; // Return the validated response
    }

    /**
     * Prompts the player to place a bet and validates the amount.
     * Ensures the player has enough chips and handles invalid inputs.
     * 
     * @param player The main player placing the bet.
     */
    public static void askPlayerBet(MainPlayer player) {
        Displayer.displayChips(player); // Display current chips
        System.out.print("Enter your bet: ");
        int bet = 0;

        // Loop until a valid bet is entered
        do {
            try {
                if (bet == 0) {
                    bet = scanner.nextInt(); // Read the bet amount
                }

                // Check if the bet is valid
                if (!InputValidator.isValidBet(player, bet)) {
                    System.out.print("You only have " + player.getChips() + " chips. Please enter a smaller amount: ");
                    bet = scanner.nextInt();
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine(); // Clear the input buffer
                bet = 0;
            }
        } while (bet <= 0 || !InputValidator.isValidBet(player, bet));

        System.out.println(); // Print a blank line
        player.setBet(bet); // Set the player's bet
    }

    /**
     * Asks the player if they want to hit or stand and validates the response.
     * 
     * @return The player's decision ("hit" or "stand").
     */
    public static String askPlayerHitOrStand() {
        System.out.print("Hit or Stand?: ");
        String userChoice = scanner.next().toLowerCase();

        // Validate the response
        while (!InputValidator.isHitOrStand(userChoice)) {
            System.out.print("Invalid input. Please enter Hit or Stand: ");
            userChoice = scanner.next().toLowerCase();
        }

        return userChoice; // Return the validated response
    }

    /**
     * Prompts the player to choose a value for the Ace card (1 or 11)
     * and validates the input.
     * 
     * @param card The Ace card for which the value is being chosen.
     * @return The validated value of the Ace card (1 or 11).
     */
    public static int askPlayerAceValue(Card card) {
        System.out.print("Please choose the value of the Ace card: 1 or 11: ");
        int aceValue = 0;

        // Loop until a valid Ace value is entered
        do {
            try {
                if (aceValue == 0) {
                    aceValue = scanner.nextInt(); // Read the Ace value
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter 1 or 11: ");
                scanner.nextLine(); // Clear the input buffer
                aceValue = 0;
            }
        } while (aceValue <= 0 || !InputValidator.isValidAceValue(aceValue));

        return aceValue; // Return the validated Ace value
    }
}
