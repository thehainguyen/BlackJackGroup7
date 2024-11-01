package ca.sheridancollege.project;

import java.util.ArrayList;

public class Displayer {
    public static void displayAll(MainPlayer player, Dealer dealer) {
        // Print separator line
        printBreakLine(100);

        // Display player's cards
        displayCard(player);

        // Display player's score
        displayScore(player);

        // Print separator line
        printBreakLine(30);

        // Display dealer's cards
        displayCard(dealer);

        // Display dealer's score
        displayScore(dealer);

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

    public static void displayScore(Player player) {
        System.out.println("Your score: " + player.getScore());
    }

    public static void displayScore(Dealer player) {
        System.out.println("Dealer score: " + player.getScore());
    }

    public static void printBreakLine(int length) {
        System.out.println("-".repeat(length));
    }

    // Display the result
    public static void displayResult(MainPlayer player) {
        // Display the result
        if (player.getChips() == 0) {
            System.out.println("You lost total of " + player.getBet() + " chips!"); // Player lost all chips
        } else if (player.getChips() < 1000){
            System.out.println("You lost total of " + (1000 - player.getChips()) + " chips!"); // Player lost less than 1000 chips
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
}
