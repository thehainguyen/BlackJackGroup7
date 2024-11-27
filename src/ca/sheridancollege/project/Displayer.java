package ca.sheridancollege.project;

import java.util.ArrayList;

public class Displayer {
    public static void displayAll(MainPlayer player, Dealer dealer) {
        // Print separator line
        printBreakLine(100);

        // Display player's cards
        displayCard(player);

        // Display player's score
        displayScore(player, "player");

        // Print separator line
        printBreakLine(30);

        // Display dealer's cards
        displayCard(dealer);

        // Display dealer's score
        displayScore(dealer, "dealer");

        // Print separator line
        printBreakLine(100);
        System.out.println();
    }

    public static void displayCard(Player player) {
        // Create an ArrayList to store the player's cards
        ArrayList<String> cards = new ArrayList<>();

        // Display player's cards
        System.out.print("Cards: ");
        for (Card card : player.getCards()) {
            cards.add(card.toString()); // Add player's cards to the ArrayList
        }

        System.out.println(String.join(", ", cards));
    }

    public static void displayScore(Player player, String role) {
        if (role.equals("player")) {
            System.out.println("Your score: " + player.getScore());
        } else {
            System.out.println("Dealer score: " + player.getScore());
        }
    }

    public static void printBreakLine(int length) {
        System.out.println("-".repeat(length));
    }

    // Display the result
    public static void displayFinalResult(MainPlayer player) {
        // Display the result
        if (player.getChips() == 0) {
            System.out.println("You lost total of " + player.getBet() + " chips!"); // Player lost all chips
            System.out.println("Better luck next time!");
        } else if (player.getChips() < 1000){
            System.out.println("You lost total of " + (1000 - player.getChips()) + " chips!"); // Player lost less than 1000 chips
            System.out.println("Better luck next time!");
        } else {
            System.out.println("Congratulations! " + player.getName());
            System.out.println("You won total of " + (player.getChips() - 1000) + " chips!"); // Player won
        }
    }

    // Display win amount
    public static void displayWinAmount(MainPlayer player) {
        System.out.println("Congratulations! " + player.getName());
        System.out.println("You won " + player.getBet()*2 + " chips!");
    }

    // Display lose amount
    public static void displayLoseAmount(MainPlayer player) {
        System.out.println("Sorry, " + player.getName());
        System.out.println("You lose " + player.getBet() + " chips!");
    }

    // Display player's chips
    public static void displayChips(MainPlayer player) {
        System.out.println("You have " + player.getChips() + " chips.");
    }

    // Display card dealed
    public static void displayCardDealed(String role, Card card) {
        if (role.equals("player")) {
            System.out.println("You got: " + card);
        } else {
            System.out.println("The Dealer got: " + card);
        }
    }

    public static void displayDraw(boolean isBlackJack) {
        if (isBlackJack) {
            System.out.println("Both you and the dealer have Blackjack! It's a tie.");
        } else {
            System.out.println("Draw!");
        }
    }

    public static void displayPlayerWin(boolean isBlackJack) {
        if (isBlackJack) {
            System.out.println("Blackjack! You win!");
        } else {
            System.out.println("You win!");
        }
    }

    public static void displayDealerWin(boolean isBlackJack) {
        if (isBlackJack) {
            System.out.println("Blackjack! The Dealer wins!");
        } else {
            System.out.println("The Dealer wins!");
        }
    }
}
