package ca.sheridancollege.project;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        // Initialise the Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Get the name of the player
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        // Create the player and the dealer
        MainPlayer player = new MainPlayer(name);
        Dealer dealer = new Dealer();

        // Create the game
        MainGame game = new MainGame(name, dealer, player);

        // Start the game
        String userAnswer = "yes";
        while (userAnswer.equals("yes") || player.getChips() > 0) {
            // Reset the game
            game.reset();
            
            // Ask the player how much they want to bet
            System.out.println("You have " + player.getChips() + " chips.");
            System.out.println("How much you want to bet?");
            int bet = scanner.nextInt();

            // Check if the player has enough chips
            while (bet > player.getChips()) {
                System.out.println("You only have " + player.getChips() + " chips. Please enter a smaller amount.");
                bet = scanner.nextInt();
            }
            
            // Set the player's bet
            player.setBet(bet);

            // Play the game
            game.play();

            // Ask if the player wants to play again
            System.out.println("Do you want to play again? (Yes/No)");
            scanner.nextLine();
            userAnswer = scanner.nextLine().toLowerCase();

            // Check for valid input
            while (!userAnswer.equals("yes") && !userAnswer.equals("no")) {
                System.out.println("Invalid input. Please enter Yes or No");
                userAnswer = scanner.nextLine().toLowerCase();
            }
        }

        if (player.getChips() == 0) {
            System.out.println("You ran out of chips!");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
