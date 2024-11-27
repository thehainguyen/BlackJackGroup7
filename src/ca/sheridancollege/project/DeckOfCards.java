package ca.sheridancollege.project;

import ca.sheridancollege.project.NormalCard.Suit;
import ca.sheridancollege.project.NormalCard.Value;

import java.util.ArrayList;

/**
 * The DeckOfCards class represents a standard deck of 52 playing cards. It provides methods 
 * to refill the deck with cards, shuffle the deck, and draw a card from the deck. 
 * The deck is composed of 4 suits, each containing 13 values (cards).
 * 
 * @author The Hai Nguyen - 991745555 - November 27, 2024
 */
public class DeckOfCards extends GroupOfCards {

    /**
     * Constructs a DeckOfCards object and fills the deck with a standard set of cards.
     */
    public DeckOfCards() {
        fullfillDeck();
    }

    /**
     * Fulfills the deck by adding 52 standard playing cards to the deck. 
     * It creates cards with all 4 suits (Hearts, Diamonds, Clubs, Spades) 
     * and 13 values (2 through Ace) for each suit.
     * After adding the cards, the deck is shuffled for randomness.
     */
    public void fullfillDeck() {
        // Get the cards list from the GroupOfCards parent class
        ArrayList<Card> cards = getCards();

        // Add 52 cards to the deck
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards.add(new NormalCard(Suit.values()[i], Value.values()[j]));
            }
        }

        // Shuffle the deck to randomize the card order
        shuffle();
    }

    /**
     * Draws (takes) the last card from the deck. If the deck is empty, 
     * it refills the deck with 52 new cards before drawing the next card.
     * 
     * @return The card taken from the top of the deck.
     */
    public Card takeACard() {
        // If the deck is empty, refill it with a new set of 52 cards
        if (getCards().size() == 0) {
            fullfillDeck();
        }

        // Return and remove the last card in the deck
        return getCards().removeLast();
    }
}
