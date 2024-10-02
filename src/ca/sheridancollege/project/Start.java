package ca.sheridancollege.project;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        // Initialise the Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Get the name of the player
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Welcome the player
        System.out.println("Welcome to Blackjack, " + name + "!");
        System.out.println();

        // Create the player and the dealer
        MainPlayer player = new MainPlayer(name);
        Dealer dealer = new Dealer();

        // Create the game
        MainGame game = new MainGame(name, dealer, player);

        // Start the game
        String userAnswer = "yes";
        while (userAnswer.equals("yes")) {
            // Reset the game
            game.reset();
            
            // Ask the player to bet
            game.askPlayerBet();

            // Play the game
            game.play();

            // If the player has no chips, exit the game
            if (player.getChips() == 0) {
                break;
            }
            
            // Ask if the player wants to play again
            userAnswer = isValidInput();
        }

        // Display the result
        game.displayResult();

        // Exit the game
        System.out.println();
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static String isValidInput() {
        // Initialise the Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask if the player wants to play again
        System.out.println("Do you want to play again? (Yes/No): ");
        String userAnswer = scanner.next().toLowerCase();

        // Check for valid input
        while (!userAnswer.equals("yes") && !userAnswer.equals("no")) {
            System.out.println("Invalid input. Please enter Yes or No: ");
            userAnswer = scanner.next().toLowerCase();
        }

        // Print a blank line
        System.out.println();
        
        // Return the user's answer
        return userAnswer;
    }
}
