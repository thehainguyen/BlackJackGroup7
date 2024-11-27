package ca.sheridancollege.project;

public class NormalCard extends Card{
    // Card Suits
    public enum Suit {
        SPADES, HEARTS, CLUBS, DIAMONDS
    }

    // Card Values
    public enum Value {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
        
        private final int value;

        private Value(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Suit suit; // Card Suit
    private Value value; // Card Value

    public NormalCard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
    
    // Getters and Setters
    public Suit getSuit() {
        return suit;
    }
    
    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value + " of " + this.suit;
    }
}
