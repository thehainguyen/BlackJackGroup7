package ca.sheridancollege.project;

import ca.sheridancollege.project.NormalCard.Value;

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
        NormalCard card = (NormalCard) deckGroupOfCards.takeACard();

        // Display the card
        Displayer.displayCardDealed("player", card);

        // Add the card to the player's hand
        player.addCard(card);

        // Check if the card is an Ace
        if (card.getValue() == Value.ACE) {
            // Ask the player if they want an Ace as 1 or 11
            int score = Prompter.askPlayerAceValue(card);
            
            // Add the value of the card to the player's score
            player.addScore(score);
        } else {
            // Add the value of the card to the player's score
            player.addScore(card.getValue().getValue());
        }
    }
    
    // Deal a card to the dealer
    public void dealToSelf(DeckOfCards deckGroupOfCards) {
        // Get the first card from the deck and remove it from the deck
        NormalCard card = (NormalCard) deckGroupOfCards.takeACard();

        // Display the card
        Displayer.displayCardDealed("dealer", card);

        // Add the card to the dealer's hand
        addCard(card);
        
        // Check if the card is an Ace
        if (card.getValue() == Value.ACE) {
            // If score is less than 11, set the value to 11
            if (getScore() < 11) { 
                addScore(11);
            } else {
                // If score is 11, set the value to 1
                addScore(1);
            }
        } else {
            // Add the value of the card to the dealer's score
            addScore(card.getValue().getValue());
        }   
    }
}
