package ca.sheridancollege.project;

import ca.sheridancollege.project.NormalCard.Suit;
import ca.sheridancollege.project.NormalCard.Value;

import java.util.ArrayList;

public class DeckOfCards extends GroupOfCards {
    // Constructor
    public DeckOfCards() {
        fullfillDeck();
    }

    // Refill the deck
    public void fullfillDeck() {
        // Get the cards
        ArrayList<Card> cards = getCards();

        // Add 52 cards to the deck
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards.add(new NormalCard(Suit.values()[i], Value.values()[j]));
            }
        }

        // Shuffle the deck
        shuffle();
    }

    // Get the last card from the deck
    public Card takeACard() {
        // If the deck is empty, refill it
        if (getCards().size() == 0) {
            fullfillDeck();
        }

        // Return the last card in the deck
        return getCards().removeLast();
    }
}
