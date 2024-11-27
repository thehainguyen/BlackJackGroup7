package ca.sheridancollege.project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prompter {
    public static Scanner scanner = new Scanner(System.in);

    // Ask player to enter the name
    public static String askPlayerName(){
        // Ask the player to enter their name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Check valid name
        while (!InputValidator.isValidName(name)) {
            System.out.print("Invalid input. Please enter your name: ");
            name = scanner.nextLine();
        }

        // Return the player's name
        return name;
    }

    // Ask player if they want to play again
    public static String askPlayerToPLayAgain() {
        // Ask if the player wants to play again
        System.out.print("Do you want to play again? (Yes/No): ");
        String userAnswer = scanner.next().toLowerCase();

        // Check for valid input
        while (!InputValidator.isYesOrNo(userAnswer)) {
            System.out.println("Invalid input. Please enter Yes or No: ");
            userAnswer = scanner.next().toLowerCase();
        }
        
        // Return the user's answer
        return userAnswer;
    }

    // Ask player to bet
    public static void askPlayerBet(MainPlayer player) {
        // Display chips
        Displayer.displayChips(player);

        // Ask player to bet
        System.out.print("Enter your bet: ");

        // Validate bet
        int bet = 0;
        do {
            try {
                // Get player's initial bet
                if (bet == 0) {
                    bet = scanner.nextInt();
                }

                // Check if the player has enough chips
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

        // Print a blank line
        System.out.println();

        // Set the player's bet
        player.setBet(bet);
    }

    // Ask player to hit or stand
    public static String askPlayerHitOrStand() {
        // Ask player to hit or stand
        System.out.print("Hit or Stand?: ");
        String userChoice = scanner.next().toLowerCase();

        // Check for valid input
        while (!InputValidator.isHitOrStand(userChoice)) {
            System.out.println("Invalid input. Please enter Hit or Stand: ");
            userChoice = scanner.next().toLowerCase();
        }

        // Return the player's choice
        return userChoice;
    }

    // Ask player to choose Ace card value
    public static int askPlayerAceValue(Card card) {
        // Ask player to choose Ace card value
        System.out.print("Please choosr the value of the Ace card: 1 or 11: ");

        // Validate Ace card value
        int aceValue = 0;
        do {
            try {
                // Get player's choice
                if (aceValue == 0) {
                    aceValue = scanner.nextInt();
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter 1 or 11: ");
                scanner.nextLine(); // Clear the input buffer
                aceValue = 0;
            } 
        } while (aceValue <= 0 || !InputValidator.isValidAceValue(aceValue));
        
        // Return the player's choice
        return aceValue;
    }
}
