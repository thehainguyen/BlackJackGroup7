package ca.sheridancollege.project;

public class Dealer extends Player {

    public Dealer() {
        // Set the name of the dealer to "Dealer"
        super("Dealer");
    }
    
    // Dealer plays the game
    public void play(Player player, DeckOfCards deckOfCards) {
        // Get the player's score
        int playerScore = player.getScore();

        // Dealer will hit until dealer's score is above the player's score
        while (getScore() < playerScore) {
            dealToSelf(deckOfCards);
        }

        // If dealer's score is equal to or above 16, dealer will stand
        if (getScore() == playerScore && getScore() <16) {
            dealToSelf(deckOfCards);
        }
    }

    // At the start of the game, dealer will deal 2 cards to the player and 2 cards to the dealer
    public void start(Player player, DeckOfCards deckGroupOfCards) {
        //Deal 2 cards to the player
        dealToPlayer(player, deckGroupOfCards);
        dealToPlayer(player, deckGroupOfCards);

        // Print a blank line
        System.out.println();
        
        //Deal 2 cards to the dealer
        dealToSelf(deckGroupOfCards);
        dealToSelf(deckGroupOfCards);

        // Print a blank line
        System.out.println();
    }

    // Deal a card to the player
    public void dealToPlayer(Player player, DeckOfCards deckGroupOfCards) {
        // Get the first card from the deck and remove it from the deck
        Card card = deckGroupOfCards.takeACard();

        // Check if the card is an Ace
        if (card.getValue() == 1 || card.getValue() == 11) {
            // Ask the player if they want an Ace as 1 or 11
            int choice = Prompter.askPlayerAceValue();
            
            // Set the value of the card
            switch (choice) {
                case 1 -> card.setValue(1); // If the player chooses 1, set the value to 1
                case 11 -> card.setValue(11); // If the player chooses 11, set the value to 11
                default -> card.setValue(1); // If the player does not choose 1 or 11, set the value to 1
            }
        }

        // Add the card to the player's hand
        player.addCard(card);

        // Add the value of the card to the player's score
        player.addScore(card.getValue());
        
        // Display the card
        Displayer.displayCardDealed("player", card);
    }
    
    // Deal a card to the dealer
    public void dealToSelf(DeckOfCards deckGroupOfCards) {
        // Get the first card from the deck and remove it from the deck
        Card card = deckGroupOfCards.takeACard();

        // Check if the card is an Ace
        if (card.getValue() == 1 || card.getValue() == 11) {
            // If score is less than 11, set the value to 11
            if (getScore() < 11) { 
                card.setValue(11);
            }
        }

        // Add the card to the dealer's hand
        addCard(card);

        // Add the value of the card to the dealer's score
        addScore(card.getValue());

        // Display the card
        Displayer.displayCardDealed("dealer", card);
    }
}
