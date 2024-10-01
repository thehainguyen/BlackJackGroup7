package ca.sheridancollege.project;

import java.util.Scanner;

public class MainGame extends Game {

    private Dealer dealer;
    private MainPlayer player;
    private Scanner scanner = new Scanner(System.in);
    
    public MainGame(String name, Dealer dealer, MainPlayer player) {
        super(name);
        this.dealer = dealer;
        this.player = player;
    }

    @Override
    public void play() {
        // Start the game
        this.dealer.start(this.player);
        displayPlayerCards();

        // Check if player has blackjack
        if (this.player.getScore() == 21) {
            System.out.println("Blackjack! You win!");
            this.player.win();
            return;
        }

        // Check if dealer has blackjack
        if (this.dealer.getScore() == 21) {
            System.out.println("Dealer has Blackjack! You lose.");
            this.player.lose();
            return;
        }

        // Player's turn
        while (this.player.getScore() < 21) {
            // Ask player if they want to hit or stand
            System.out.println("Hit or Stand?");
            String userChoice = scanner.nextLine().toLowerCase();
            // Check for valid input
            while (!userChoice.equals("hit") && !userChoice.equals("stand")) {
                System.out.println("Invalid input. Please enter Hit or Stand:");
                userChoice = scanner.nextLine().toLowerCase();
            }

            // If player hits, deal another card
            if (userChoice.equals("hit")) {
                this.player.addCard(this.dealer.getRandomCard());
                displayPlayerCards();
            } else {
                break; // Player stands, end turn
            }    
        }

        // If player's score is above 21, declare winner
        if (this.player.getScore() > 21) {
            System.out.println("You Bust!");
            this.player.lose();
            return;
        }

        // Dealer's turn
        int playerScore = this.player.getScore();
        while (this.dealer.getScore() < playerScore) {
            this.dealer.dealToSelf();
            displayPlayerCards();
        }

        if (this.dealer.getScore() > 21) {
            System.out.println("Dealer Busts!");
            declareWinner(this.player);
            this.player.win();
        } else {
            displayPlayerCards();
            this.player.lose();
            System.out.println("Game over. The winner is The Dealer!");
        }
    }

    @Override
    public void declareWinner(Player player) {
        System.out.println(player.getName() + " is the winner!");
    }

    public void displayPlayerCards() {
        System.out.println("-".repeat(30));

        // Display player's cards
        System.out.print("Your cards: ");
        for (Card card : player.getCards()) {
            System.out.print(card.toString() + ", ");
        }

        // Display player's score
        System.out.println();
        System.out.println("Your score: " + player.getScore());

        System.out.println("-".repeat(15));

        // Display dealer's cards
        System.out.print("Dealer's cards: ");
        for (Card card : dealer.getCards()) {
            System.out.print(card.toString() + ", ");
        }

        // Display dealer's score   
        System.out.println();
        System.out.println("Dealer's score: " + dealer.getScore());
        System.out.println("-".repeat(30));
        System.out.println();
    }

    public void reset() {
        this.dealer.reset();
        this.player.reset();
    }

    public boolean isPlayerBlackjack(Player player) {
        return player.getScore() == 21;
    }

    /**
     * @return the players of this game
     */
    public Player getPlayer() {
        return this.player;
    }

    public Dealer getDealer() {
        return this.dealer;
    }
}
