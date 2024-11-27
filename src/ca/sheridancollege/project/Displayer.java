package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The Displayer class provides utility methods to display information
 * about the game, including player and dealer cards, scores, results, and chips.
 * This class handles all game-related outputs for the user.
 * 
 * @author The Hai Nguyen - 991745555 - November 27, 2024
 */
public class Displayer {

    /**
     * Displays the cards and scores for both the player and the dealer.
     * 
     * @param player The main player in the game.
     * @param dealer The dealer in the game.
     */
    public static void displayAll(MainPlayer player, Dealer dealer) {
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
     * Prints a separator line of a specified length.
     * 
     * @param length The length of the separator line.
     */
    public static void printBreakLine(int length) {
        System.out.println("-".repeat(length));
    }

    /**
     * Displays the final result of the game, including the player's total chips.
     * 
     * @param player The main player in the game.
     */
    public static void displayFinalResult(MainPlayer player) {
        // Display the result based on the player's chips
        if (player.getChips() == 0) {
            System.out.println("You lost a total of " + player.getBet() + " chips!");
            System.out.println("Better luck next time!");
        } else if (player.getChips() < 1000) {
            System.out.println("You lost a total of " + (1000 - player.getChips()) + " chips!");
            System.out.println("Better luck next time!");
        } else {
            System.out.println("Congratulations! " + player.getName());
            System.out.println("You won a total of " + (player.getChips() - 1000) + " chips!");
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
    public static void displayCardDealed(String role, Card card) {
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
}
