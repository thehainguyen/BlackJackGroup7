package ca.sheridancollege.project;

import java.util.Scanner;

import ca.sheridancollege.project.NormalCard.Suit;
import ca.sheridancollege.project.NormalCard.Value;

public class MainGame extends Game {
    private Dealer dealer;
    private MainPlayer player;
    private GroupOfCards deckOfCards;
    
    public MainGame(String name, Dealer dealer, MainPlayer player) {
        super(name);
        this.dealer = dealer;
        this.player = player;
        this.deckOfCards = createDeckOfCards();
    }

    @Override
    public void play() {
        // Start the game
        this.dealer.start(this.player, this.deckOfCards);
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
                this.dealer.dealToPlayer(this.player, this.deckOfCards);
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
        System.out.println();
        System.out.println("Dealer's turn...");

        // Dealer's turn
        this.dealer.play(this.player, this.deckOfCards);

        // Display player's cards and dealer's cards
        displayPlayerCards();

        // Declare winner
        declareWinner();

        // Reset the deck of cards
        this.deckOfCards = createDeckOfCards();
    }

    @Override
    public void declareWinner() {
        // If dealer's score is above 21, declare winner
        if (this.dealer.getScore() > 21) {
            System.out.println("Dealer Bust!");
            this.player.win();
            return;
        }

        // Compare scores
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

    public GroupOfCards createDeckOfCards() {
        // Create a new deck of cards
        GroupOfCards deckOfCards = new GroupOfCards();

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 13; j++) {
                deckOfCards.addCard(new NormalCard(Suit.values()[i], Value.values()[j]));
            }
        }

        // Shuffle the deck
        deckOfCards.shuffle();

        return deckOfCards;
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
        // Initialise the Scanner to read user input
        Scanner scanner = new Scanner(System.in);

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
        // Initialise the Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("You have " + player.getChips() + " chips.");
        System.out.print("PLease enter your bet: ");
        int bet = scanner.nextInt();

        // Check if the player has enough chips
        while (bet > player.getChips()) {
            System.out.print("You only have " + player.getChips() + " chips. Please enter a smaller amount.");
            bet = scanner.nextInt();
        }

        System.out.println();

        // Set the player's bet
        player.setBet(bet);
    }

    public void displayResult() {
        // Display the result
        if (this.player.getChips() < 1000){
            System.out.println("You lost total of " + (1000 - player.getChips()) + " chips!");
        } else {
            System.out.println("Congratulations! " + player.getName());
            System.out.println("You won total of " + (player.getChips() - 1000) + " chips!");
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

    public GroupOfCards getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(GroupOfCards deckOfCards) {
        this.deckOfCards = deckOfCards;
    }
}
