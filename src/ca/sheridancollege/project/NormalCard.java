package ca.sheridancollege.project;

/**
 * The NormalCard class represents a standard playing card in a deck. 
 * Each card has a suit (Spades, Hearts, Clubs, or Diamonds) and a value 
 * (Ace, Two, ..., King). The class provides methods to access the card's 
 * suit and value and overrides the toString method to display the card 
 * in a readable format.
 * 
 * This class also includes nested enums for Suit and Value to define 
 * the possible attributes of a card.
 * 
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @moffied by The Hai Nguyen - 991745555 - October 30, 2024
 */
public class NormalCard extends Card {

    /**
     * Enum representing the four suits in a standard deck of playing cards.
     * The suits are Spades, Hearts, Clubs, and Diamonds.
     */
    public enum Suit {
        SPADES, HEARTS, CLUBS, DIAMONDS
    }

    /**
     * Enum representing the values of the cards in a standard deck.
     * Each card value corresponds to a numerical value, with face cards (Jack, Queen, King) 
     * being valued at 10, and Ace valued as 1.
     */
    public enum Value {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
        
        private final int value;

        // Constructor to set the value for each card
        private Value(int value) {
            this.value = value;
        }

        /**
         * Gets the numerical value of the card.
         * 
         * @return The value of the card as an integer.
         */
        public int getValue() {
            return value;
        }
    }

    private Suit suit; // Card Suit
    private Value value; // Card Value

    /**
     * Constructs a NormalCard object with a specified suit and value.
     * 
     * @param suit The suit of the card (Spades, Hearts, Clubs, or Diamonds).
     * @param value The value of the card (Ace, Two, Three, ..., King).
     */
    public NormalCard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    // Getters and Setters

    /**
     * Gets the suit of the card.
     * 
     * @return The suit of the card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Gets the value of the card.
     * 
     * @return The value of the card.
     */
    public Value getValue() {
        return value;
    }

    /**
     * Returns a string representation of the card in the format "VALUE of SUIT".
     * For example: "ACE of SPADES" or "KING of HEARTS".
     * 
     * @return The string representation of the card.
     */
    @Override
    public String toString() {
        return this.value + " of " + this.suit;
    }
}
