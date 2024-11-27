package ca.sheridancollege.project;

public class MainGame extends Game {
    private Dealer dealer; // Dealer object
    private MainPlayer player; // Player object
    private DeckOfCards deckOfCards; // Deck of cards
    
    public MainGame(String name) {
        super(name); // Set the name of the game
        this.deckOfCards = new DeckOfCards(); //Create the deck of cards
    }

    // Start the game
    @Override
    public void play() {
        // Dealer deals 2 cards to player and dealer
        this.dealer.start(this.player, this.deckOfCards);

        // Display player's cards and dealer's cards
        Displayer.displayAll(this.player, this.dealer); 

        // Check if player or dealer has blackjack
        if (isBlackJack()) {
            return;
        }

        // Player's turn
        while (this.player.getScore() < 21) {
            // Ask player if they want to hit or stand
            String userChoice = Prompter.askPlayerHitOrStand();

            // If player hits, deal another card
            if (userChoice.equals("hit")) {
                this.dealer.dealToPlayer(this.player, this.deckOfCards);
                Displayer.displayAll(this.player, this.dealer);
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
        Displayer.displayAll(this.player, this.dealer);

        // Declare winner
        declareWinner();
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

        // Compare scores if both are below 21
        if (this.player.getScore() > this.dealer.getScore()) {
            declarePlayerWin(); // Player wins
        } else if (this.player.getScore() < this.dealer.getScore()) {
            declarePlayerLose(); // Player loses
        } else {
            Displayer.displayDraw(false); // Draw
        }
    }

    // Declare player win
    public void declarePlayerWin() {
        // Display win amount
        Displayer.displayWinAmount(this.player); 
        
        // Add won amount to player's budget
        this.player.setChips(this.player.getChips() + this.player.getBet()*2); 

        // Print a blank line
        System.out.println();
    }

    // Declare player lose
    public void declarePlayerLose() {
        // Display lose amount
        Displayer.displayLoseAmount(this.player);

        // Subtract lost amount from player's budget
        this.player.setChips(this.player.getChips() - this.player.getBet());

        // Print a blank line
        System.out.println();
    }

    // Check if player or dealer has blackjack
    public boolean isBlackJack() {
        // Both player and dealer have blackjack
        if (this.player.getScore() == 21 && this.dealer.getScore() == 21) {
            Displayer.displayDraw(true);
            return true;
        } 
        
        // Player has blackjack
        if (this.player.getScore() == 21) { 
            Displayer.displayPlayerWin(true);
            declarePlayerWin(); // Player wins
            return true;
        } 
        
        // Dealer has blackjack
        if (this.dealer.getScore() == 21) {
            Displayer.displayPlayerWin(false);
            declarePlayerLose(); // Player loses
            return true;
        }

        // Neither player nor dealer has blackjack
        return false;
    }
    
    // Reset the game
    public void playAgain() {
        this.dealer.releaseCards();
        this.player.releaseCards();
    }

    // Player setter and getter
    public void setPlayer(MainPlayer player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    // Dealer setter and getter 
    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    // deckOfCards getter
    public GroupOfCards getDeckOfCards() {
        return deckOfCards;
    }

    // deckOfCards setter
    public void setDeckOfCards(DeckOfCards deckOfCards) {
        this.deckOfCards = deckOfCards;
    }
}
