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

        // Check if player or dealer has blackjack
        if (isBlackJack()) {
            return;
        }

        // Player's turn
        while (this.player.getScore() < 21) {
            // Ask player if they want to hit or stand
            String userChoice = askPlayerHitOrStand();

            // If player hits, deal another card
            if (userChoice.equals("hit")) {
                this.dealer.dealToPlayer(this.player);
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

        // Dealer will hit until dealer's score is above the player's score
        while (this.dealer.getScore() < playerScore) {
            this.dealer.dealToSelf();
            displayPlayerCards();
        }

        // Declare winner
        declareWinner();
    }

    @Override
    public void declareWinner() {
        if (this.player.getScore() > this.dealer.getScore()) {
            System.out.println("You win!");
            this.player.win();
        } else if (this.player.getScore() < this.dealer.getScore()) {
            System.out.println("You lose!");
            this.player.lose();
        } else {
            System.out.println("It's a tie!");
        }
    }

    public boolean isBlackJack() {
        // Both player and dealer have blackjack
        if (this.player.getScore() == 21 && this.dealer.getScore() == 21) {
            System.out.println("Both you and the dealer have Blackjack! It's a tie.");
            return true;
        } 
        
        // Player has blackjack
        if (this.player.getScore() == 21) { 
            System.out.println("Blackjack! You win!");
            this.player.win();
            return true;
        } 
        
        // Dealer has blackjack
        if (this.dealer.getScore() == 21) {
            System.out.println("Dealer has Blackjack! You lose.");
            this.player.lose();
            return true;
        }

        return false;
    }

    public String askPlayerHitOrStand() {
        System.out.print("Hit or Stand?: ");
        String userChoice = scanner.next().toLowerCase();
        // Check for valid input
        while (!userChoice.equals("hit") && !userChoice.equals("stand")) {
            System.out.println("Invalid input. Please enter Hit or Stand: ");
            userChoice = scanner.next().toLowerCase();
        }
        return userChoice;
    }

    public void displayPlayerCards() {
        System.out.println("-".repeat(100));

        // Display player's cards
        System.out.print("Your cards: ");
        for (Card card : player.getCards()) {
            System.out.print(card.toString() + ", ");
        }

        // Display player's score
        System.out.println();
        System.out.println("Your score: " + player.getScore());

        System.out.println("-".repeat(30));

        // Display dealer's cards
        System.out.print("Dealer's cards: ");
        for (Card card : dealer.getCards()) {
            System.out.print(card.toString() + ", ");
        }

        // Display dealer's score   
        System.out.println();
        System.out.println("Dealer's score: " + dealer.getScore());
        System.out.println("-".repeat(100));
        System.out.println();
    }
    

    public void askPlayerBet() {
        System.out.println("You have " + player.getChips() + " chips.");
        System.out.print("PLease enter your bet: ");
        int bet = scanner.nextInt();

        // Check if the player has enough chips
        while (bet > player.getChips()) {
            System.out.print("You only have " + player.getChips() + " chips. Please enter a smaller amount.");
            bet = scanner.nextInt();
        }

        // Set the player's bet
        player.setBet(bet);
    }

    public void displayResult() {
        // Display the result
        if (this.player.getChips() < 1000){
            System.out.println("You lost" + (1000 - player.getChips()) + " chips!");
        } else {
            System.out.println("You won " + (player.getChips() - 1000) + " chips!");
        }
    }
    
    public void reset() {
        this.dealer.reset();
        this.player.reset();
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
