package ca.sheridancollege.project;

/**
 * The HandOfCards class models a collection of cards held by a player or dealer. 
 * It allows cards to be added to the hand and provides a method to reset the hand by clearing the cards.
 * 
 * @author The Hai Nguyen
 * @studentID 991745555
 * @date November 27, 2024
 */
public class HandOfCards extends GroupOfCards {

    /**
     * Adds a card to the hand of cards.
     * This method is used to add a card to the player's or dealer's hand.
     * 
     * @param card The card to be added to the hand.
     */
    public void addCard(Card card) {
        getCards().add(card);
    }

    /**
     * Resets the hand by clearing all cards.
     * This method is used to reset the hand, typically at the start of a new game or round.
     */
    public void reset() {
        getCards().clear();
    }
}
