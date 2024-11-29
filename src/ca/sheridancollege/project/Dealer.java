package ca.sheridancollege.project;

import ca.sheridancollege.project.NormalCard.Value;

/**
 * The Dealer class represents the dealer in the card game. It extends the Player class and 
 * includes methods to manage the dealer's actions such as playing the game, dealing cards,
 * and calculating the dealer's score. The dealer follows a set of rules for when to hit 
 * or stand during the game.
 * 
 * @author The Hai Nguyen
 * @studentID 991745555
 * @date November 27, 2024
 */
public class Dealer extends Player {

    /**
     * Constructs a Dealer object with the name "Dealer".
     */
    public Dealer() {
        // Set the name of the dealer to "Dealer"
        super("Dealer");
    }

    /**
     * This method handles the dealer's gameplay, where the dealer hits (draws cards) 
     * until their score is higher than the player's score. If the scores are tied, the 
     * dealer will continue drawing cards until their score is at least 16.
     * 
     * @param player The player object representing the user in the game.
     * @param deckOfCards The deck of cards from which cards are dealt.
     */
    public void play(Player player, DeckOfCards deckOfCards) {
        // Get the player's score
        int playerScore = player.getScore();

        // Dealer will hit until dealer's score is above the player's score
        while (getScore() < playerScore) {
            dealToSelf(deckOfCards);
        }

        // If dealer's score is equal to or above 16, dealer will stand
        if (getScore() == playerScore && getScore() < 16) {
            dealToSelf(deckOfCards);
        }
    }

    /**
     * This method starts the game by dealing two cards to the player and two cards to the dealer.
     * It ensures both parties have the necessary initial cards to begin gameplay.
     * 
     * @param player The player object who will receive cards.
     * @param deckGroupOfCards The deck from which the cards are dealt.
     */
    public void start(Player player, DeckOfCards deckGroupOfCards) {
        // Deal 2 cards to the player
        dealToPlayer(player, deckGroupOfCards);
        dealToPlayer(player, deckGroupOfCards);

        // Print a blank line
        System.out.println();
        
        // Deal 2 cards to the dealer
        dealToSelf(deckGroupOfCards);
        dealToSelf(deckGroupOfCards);

        // Print a blank line
        System.out.println();
    }

    /**
     * Deals a card to the player and updates the player's score. If the card is an Ace, 
     * the player is prompted to choose whether to value it as 1 or 11.
     * 
     * @param player The player object who will receive the card.
     * @param deckGroupOfCards The deck from which the card is drawn.
     */
    public void dealToPlayer(Player player, DeckOfCards deckGroupOfCards) {
        // Get the first card from the deck and remove it from the deck
        NormalCard card = (NormalCard) deckGroupOfCards.takeACard();

        // Display the card
        Displayer.displayCardDealed(card, "player");

        // Add the card to the player's hand
        player.addCard(card);

        // Check if the card is an Ace
        if (card.getValue() == Value.ACE) {
            // Ask the player if they want an Ace as 1 or 11
            int score = Prompter.askPlayerAceValue(card);
            
            // Add the value of the card to the player's score
            player.setScore(player.getScore() + score);
        } else {
            // Add the value of the card to the player's score
            player.setScore(player.getScore() + card.getValue().getValue());
        }
    }

    /**
     * Deals a card to the dealer and updates the dealer's score. If the card is an Ace, 
     * it is valued either as 1 or 11 based on the dealer's current score.
     * 
     * @param deckGroupOfCards The deck from which the card is drawn.
     */
    public void dealToSelf(DeckOfCards deckGroupOfCards) {
        // Get the first card from the deck and remove it from the deck
        NormalCard card = (NormalCard) deckGroupOfCards.takeACard();

        // Display the card
        Displayer.displayCardDealed(card, "dealer");

        // Add the card to the dealer's hand
        addCard(card);
        
        // Check if the card is an Ace
        if (card.getValue() == Value.ACE) {
            // If score is less than 11, set the value to 11
            if (getScore() < 11) { 
                setScore(getScore() + 11);
            } else {
                // If score is 11, set the value to 1
                setScore(getScore() + 1);
            }
        } else {
            // Add the value of the card to the dealer's score
            setScore(getScore() + card.getValue().getValue());
        }   
    }
}
