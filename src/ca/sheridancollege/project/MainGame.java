package ca.sheridancollege.project;

/**
 * MainGame class extends the Game class to implement the logic for a blackjack game.
 * It handles player and dealer actions, determines winners, and maintains the game flow.
 * 
 * @author The Hai Nguyen - 991745555 - November 27, 2024
 */
public class MainGame extends Game {

    private Dealer dealer; // Dealer object
    private MainPlayer player; // Player object
    private DeckOfCards deckOfCards; // Deck of cards

    /**
     * Constructor to initialize the MainGame with a name and a deck of cards.
     * 
     * @param name The name of the game.
     */
    public MainGame(String name) {
        super(name); // Set the name of the game
        this.deckOfCards = new DeckOfCards(); // Create the deck of cards
    }

    /**
     * Starts the blackjack game. Handles the flow of actions for the player and dealer,
     * including dealing cards, checking for blackjack, and determining the winner.
     */
    @Override
    public void play() {
        // Dealer deals 2 cards to player and dealer
        this.dealer.start(this.player, this.deckOfCards);

        // Display initial cards of both player and dealer
        Displayer.displayAll(this.player, this.dealer);

        // Check if there's an initial blackjack for player or dealer
        if (isBlackJack()) {
            return;
        }

        // Player's turn to hit or stand
        while (this.player.getScore() <= 21) {
            // Ask player for their choice (hit or stand)
            String userChoice = Prompter.askPlayerHitOrStand();

            // If player chooses to hit, deal another card
            if (userChoice.equals("hit")) {
                this.dealer.dealToPlayer(this.player, this.deckOfCards);
                Displayer.displayAll(this.player, this.dealer); // Show updated hands
            } else {
                break; // End player's turn
            }
        }

        // If player's score exceeds 21, they bust
        if (this.player.getScore() > 21) {
            System.out.println("You Bust!");
            declarePlayerLose();
            return;
        }

        // Dealer's turn to play
        System.out.println("\nDealer's turn...");
        this.dealer.play(this.player, this.deckOfCards);

        // Show final hands of both player and dealer
        Displayer.displayAll(this.player, this.dealer);

        // Determine and declare the winner
        declareWinner();
    }

    /**
     * Determines and declares the winner based on the scores of the player and dealer.
     */
    @Override
    public void declareWinner() {
        // Check if the dealer busts
        if (this.dealer.getScore() > 21) {
            System.out.println("Dealer Bust!");
            declarePlayerWin();
            return;
        }

        // Compare scores if neither busts
        if (this.player.getScore() > this.dealer.getScore()) {
            declarePlayerWin(); // Player wins
        } else if (this.player.getScore() < this.dealer.getScore()) {
            declarePlayerLose(); // Dealer wins
        } else {
            Displayer.displayDraw(false); // It's a draw
        }
    }

    /**
     * Declares the player as the winner, updates the player's chips, and displays the result.
     */
    public void declarePlayerWin() {
        Displayer.displayWinAmount(this.player); // Show win amount
        this.player.setChips(this.player.getChips() + this.player.getBet() * 2); // Update chips
        System.out.println(); // Blank line for readability
    }

    /**
     * Declares the player as the loser, updates the player's chips, and displays the result.
     */
    public void declarePlayerLose() {
        Displayer.displayLoseAmount(this.player); // Show lose amount
        this.player.setChips(this.player.getChips() - this.player.getBet()); // Update chips
        System.out.println(); // Blank line for readability
    }

    /**
     * Checks if either the player or the dealer has a blackjack.
     * 
     * @return true if there is a blackjack, false otherwise.
     */
    public boolean isBlackJack() {
        // Check for a tie blackjack
        if (this.player.getScore() == 21 && this.dealer.getScore() == 21) {
            Displayer.displayDraw(true);
            return true;
        }

        // Check if the player has blackjack
        if (this.player.getScore() == 21) {
            Displayer.displayPlayerWin(true);
            declarePlayerWin();
            return true;
        }

        // Check if the dealer has blackjack
        if (this.dealer.getScore() == 21) {
            Displayer.displayDealerWin(true);
            declarePlayerLose();
            return true;
        }

        // No blackjack
        return false;
    }

    /**
     * Resets the game by releasing all cards held by the player and dealer.
     */
    public void playAgain() {
        this.dealer.releaseCards();
        this.player.releaseCards();
    }

    /**
     * Sets the player object.
     * 
     * @param player The player object to be set.
     */
    public void setPlayer(MainPlayer player) {
        this.player = player;
    }

    /**
     * Gets the player object.
     * 
     * @return The current player object.
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Sets the dealer object.
     * 
     * @param dealer The dealer object to be set.
     */
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    /**
     * Gets the dealer object.
     * 
     * @return The current dealer object.
     */
    public Dealer getDealer() {
        return this.dealer;
    }

    /**
     * Gets the deck of cards object.
     * 
     * @return The deck of cards used in the game.
     */
    public GroupOfCards getDeckOfCards() {
        return deckOfCards;
    }

    /**
     * Sets the deck of cards object.
     * 
     * @param deckOfCards The deck of cards to be set.
     */
    public void setDeckOfCards(DeckOfCards deckOfCards) {
        this.deckOfCards = deckOfCards;
    }
}
