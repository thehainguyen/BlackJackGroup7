package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The Displayer class provides utility methods to display information
 * about the game, including player and dealer cards, scores, results, and chips.
 * This class handles all game-related outputs for the user.
 * 
 * @author The Hai Nguyen
 * @studentID 991745555
 * @date November 27, 2024
 */
public class Displayer {

    /**
     * Displays the cards and scores for both the player and the dealer.
     * 
     * @param player The main player in the game.
     * @param dealer The dealer in the game.
     */
    public static void displayAll(Player player, Player dealer) {
        // Print separator line
        printBreakLine(100);

        // Display player's cards and score
        displayCard(player);
        displayScore(player, "player");

        // Print separator line
        printBreakLine(30);

        // Display dealer's cards and score
        displayCard(dealer);
        displayScore(dealer, "dealer");

        // Print separator line
        printBreakLine(100);
        System.out.println();
    }

    /**
     * Displays the cards held by a player.
     * 
     * @param player The player whose cards are to be displayed.
     */
    public static void displayCard(Player player) {
        // Create an ArrayList to store the player's cards
        ArrayList<String> cards = new ArrayList<>();

        // Display player's cards
        System.out.print("Cards: ");
        for (Card card : player.getCards()) {
            cards.add(card.toString()); // Add player's cards to the ArrayList
        }
        System.out.println(String.join(", ", cards)); // Join and print card names
    }

    /**
     * Displays the score of the player or dealer.
     * 
     * @param player The player or dealer whose score is to be displayed.
     * @param role   The role of the player ("player" or "dealer").
     */
    public static void displayScore(Player player, String role) {
        if (role.equals("player")) {
            System.out.println("Your score: " + player.getScore());
        } else {
            System.out.println("Dealer score: " + player.getScore());
        }
    }

    /**
     * Displays the final result of the game, including the player's total chips.
     * 
     * @param player The main player in the game.
     */
    public static void displayFinalResult(MainPlayer player) {
        // Get the player's total chips
        int chips = player.getChips();

        // Print a separator line
        printBreakLine(50);

        // Display the result based on the player's chips
        if (chips == 0) {
            System.out.println("Sorry, " + player.getName() + ". You lose all of your chips!"); // Lose all chips
            
            System.out.println("You lost a total of " + player.getMaxChips() + " chips!");

            System.out.println(); // Print an empty line

            displayPlayedRounds(player); // Display win and lose rounds

            System.out.println("Better luck next time!");
        } else if (chips < 1000) {
            System.out.println("You lost a total of " + (player.getMaxChips() - chips) + " chips!"); // Lose some chips
            displayChips(player);

            System.out.println(); // Print an empty line

            displayPlayedRounds(player); // Display win and lose rounds

            System.out.println("Better luck next time!");
        } else if (chips == 1000) {
            System.out.println("Your chips are safe!");
            System.out.println("You still have " + player.getChips() + " chips!");

            System.out.println(); // Print an empty line

            displayPlayedRounds(player); // Display win and lose rounds
        }else {
            System.out.println("Congratulations! " + player.getName());
            System.out.println("You won a total of " + (chips - 1000) + " chips!");
            displayChips(player);

            System.out.println(); // Print an empty line

            displayPlayedRounds(player); // Display win and lose rounds
        }
    }

    /**
     * Displays the amount won by the player.
     * 
     * @param player The main player in the game.
     */
    public static void displayWinAmount(MainPlayer player) {
        System.out.println("Congratulations! " + player.getName());
        displayPlayerWin(false);
        System.out.println("You won " + player.getBet() * 2 + " chips!");
    }

    /**
     * Displays the amount lost by the player.
     * 
     * @param player The main player in the game.
     */
    public static void displayLoseAmount(MainPlayer player) {
        System.out.println("Sorry, " + player.getName());
        System.out.println("You lose " + player.getBet() + " chips!");
    }

    /**
     * Displays the current chips held by the player.
     * 
     * @param player The main player in the game.
     */
    public static void displayChips(MainPlayer player) {
        System.out.println("You have " + player.getChips() + " chips.");
    }

    /**
     * Displays the card dealt to a player or dealer.
     * 
     * @param role The role of the recipient ("player" or "dealer").
     * @param card The card that was dealt.
     */
    public static void displayCardDealed(Card card, String role) {
        if (role.equals("player")) {
            System.out.println("You got: " + card);
        } else {
            System.out.println("The Dealer got: " + card);
        }
    }

    /**
     * Displays the result of a draw.
     * 
     * @param isBlackJack Indicates whether the draw occurred due to a blackjack.
     */
    public static void displayDraw(boolean isBlackJack) {
        if (isBlackJack) {
            System.out.println("Both you and the dealer have Blackjack! It's a tie.");
        } else {
            System.out.println("It is a Draw!");
        }
        System.out.println("Your chips are safe!");
        System.out.println();
    }

    /**
     * Displays a message indicating the player has won.
     * 
     * @param isBlackJack Indicates whether the win occurred due to a blackjack.
     */
    public static void displayPlayerWin(boolean isBlackJack) {
        if (isBlackJack) {
            System.out.println("Blackjack! You win the game!");
        } else {
            System.out.println("You are the winner!");
        }
    }

    /**
     * Displays a message indicating the dealer has won.
     * 
     * @param isBlackJack Indicates whether the win occurred due to a blackjack.
     */
    public static void displayDealerWin(boolean isBlackJack) {
        if (isBlackJack) {
            System.out.println("Blackjack! The Dealer wins!");
        } else {
            System.out.println("The Dealer wins!");
        }
    }

    /**
     * Displays win, draw, and lose rounds for the player.
     * 
     * @param player The main player in the game.
     */
    public static void displayPlayedRounds(MainPlayer player) {
        System.out.println("You won " + player.getWinRounds() + " rounds.");
        System.out.println("You lost " + player.getLoseRounds() + " rounds.");
        System.out.println("You drew " + player.getDrawRounds() + " rounds.");
    }

    /**
     * Prints a separator line of a specified length.
     * 
     * @param length The length of the separator line.
     */
    public static void printBreakLine(int length) {
        System.out.println("-".repeat(length));
    }
}
