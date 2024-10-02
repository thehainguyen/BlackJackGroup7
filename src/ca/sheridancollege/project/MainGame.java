package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;
import ca.sheridancollege.project.NormalCard.Suit;
import ca.sheridancollege.project.NormalCard.Value;

public class MainGame extends Game {
    private Dealer dealer; // Dealer object
    private MainPlayer player; // Player object
    private GroupOfCards deckOfCards; // Deck of cards
    
    public MainGame(String name, Dealer dealer, MainPlayer player) {
        super(name); // Set the name of the game
        this.dealer = dealer;
        this.player = player;
        this.deckOfCards = createDeckOfCards(); //Create the deck of cards
    }

    // Start the game
    @Override
    public void play() {
        // Dealer deals  2 cards to player and dealer
        this.dealer.start(this.player, this.deckOfCards);
        displayPlayerCards(); // Display player's cards

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
            declarePlayerLose();;
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

    // Declare winner
    @Override
    public void declareWinner() {
        // If dealer's score is above 21, declare winner
        if (this.dealer.getScore() > 21) {
            System.out.println("Dealer Bust!");
            declarePlayerWin();
            return;
        }

        // Compare scores
        if (this.player.getScore() > this.dealer.getScore()) {
            declarePlayerWin(); // Player wins
        } else if (this.player.getScore() < this.dealer.getScore()) {
            declarePlayerLose(); // Player loses
        } else {
            System.out.println("It's a tie!"); // Draw
        }
    }

    // Declare player win
    public void declarePlayerWin() {
        System.out.println("You win!");
        System.out.println(this.getName() + " won " + this.player.getBet() + " chips!");
        System.out.println();
        this.player.setChips(this.player.getChips() + this.player.getBet()); // Add bet to player's chips
    }

    // Declare player lose
    public void declarePlayerLose() {
        System.out.println("You lose!");
        System.out.println(this.getName() + " lost " + this.player.getBet() + " chips!");
        System.out.println();
        this.player.setChips(this.player.getChips() - this.player.getBet()); // Subtract bet from player's chips
    }

    // Create the deck of cards
    public GroupOfCards createDeckOfCards() {
        // Create a new deck of cards
        GroupOfCards deckOfCards = new GroupOfCards();

        // Add 52 cards to the deck
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 13; j++) {
                deckOfCards.addCard(new NormalCard(Suit.values()[i], Value.values()[j]));
            }
        }

        // Shuffle the deck
        deckOfCards.shuffle();

        // Return the deck of cards
        return deckOfCards;
    }

    // Check if player or dealer has blackjack
    public boolean isBlackJack() {
        // Both player and dealer have blackjack
        if (this.player.getScore() == 21 && this.dealer.getScore() == 21) {
            System.out.println("Both you and the dealer have Blackjack! It's a tie.");
            return true;
        } 
        
        // Player has blackjack
        if (this.player.getScore() == 21) { 
            System.out.println("Blackjack! You win!");
            declarePlayerWin(); // Player wins
            return true;
        } 
        
        // Dealer has blackjack
        if (this.dealer.getScore() == 21) {
            System.out.println("Dealer has Blackjack! You lose.");
            declarePlayerLose(); // Player loses
            return true;
        }

        // Neither player nor dealer has blackjack
        return false;
    }

    // Ask player to hit or stand
    public String askPlayerHitOrStand() {
        // Initialise the Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask player to hit or stand
        System.out.print("Hit or Stand?: ");
        String userChoice = scanner.next().toLowerCase(); // Convert user input to lowercase

        // Check for valid input
        while (!userChoice.equals("hit") && !userChoice.equals("stand")) {
            System.out.println("Invalid input. Please enter Hit or Stand: "); // Ask player to hit or stand again
            userChoice = scanner.next().toLowerCase();
        }

        // Return the user's choice
        return userChoice;
    }

    // Display player's cards and dealer's cards
    public void displayPlayerCards() {
        // Print separator line
        System.out.println("-".repeat(100));

        // Create an ArrayList to store the player's cards
        ArrayList<String> Cards = new ArrayList<>();

        // Display player's cards
        System.out.print("Your cards: ");
        for (Card card : player.getCards()) {
            Cards.add(card.toString()); // Add player's cards to the ArrayList
        }

        System.out.println(String.join(", ", Cards)); // Display the player's cards separated by commas

        // Display player's score
        System.out.println("Your score: " + player.getScore());

        // Print separator line
        System.out.println("-".repeat(30));

        // Display dealer's cards
        Cards.clear(); // Clear the ArrayList

        System.out.print("Dealer's cards: ");
        for (Card card : dealer.getCards()) {
            Cards.add(card.toString()); // Add dealer's cards to the ArrayList
        }

        System.out.println(String.join(", ", Cards)); //Display the dealer's cards separated by commas

        // Display dealer's score   
        System.out.println("Dealer's score: " + dealer.getScore());
        System.out.println("-".repeat(100));
        System.out.println();
    }
    
    // Ask the player to bet
    public void askPlayerBet() {
        // Initialise the Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask the player to bet
        System.out.println("You have " + player.getChips() + " chips.");
        System.out.print("PLease enter your bet: ");
        // Get the player's bet
        int bet = scanner.nextInt();

        // Check if the player has enough chips
        while (bet > player.getChips()) {
            // Ask the player to bet again
            System.out.print("You only have " + player.getChips() + " chips. Please enter a smaller amount.");
            bet = scanner.nextInt();
        }

        // Print a blank line
        System.out.println();

        // Set the player's bet
        player.setBet(bet);
    }

    // Display the result
    public void displayResult() {
        // Display the result
        if (this.player.getChips() < 1000){
            System.out.println("You lost total of " + (1000 - player.getChips()) + " chips!");
        } else {
            System.out.println("Congratulations! " + player.getName());
            System.out.println("You won total of " + (player.getChips() - 1000) + " chips!");
        }
    }
    
    // Reset the game
    public void reset() {
        this.dealer.reset();
        this.player.reset();
    }

    // Player getter
    public Player getPlayer() {
        return this.player;
    }

    // Dealer getter
    public Dealer getDealer() {
        return this.dealer;
    }

    // deckOfCards getter
    public GroupOfCards getDeckOfCards() {
        return deckOfCards;
    }
}
