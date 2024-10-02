package ca.sheridancollege.project;

public class NormalCard extends Card{
    public enum Suit {
        SPADES,
        HEARTS,
        CLUBS,
        DIAMONDS
    }

    public enum Value {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10);
        
        private int value;
        Value(int value) {
            this.value = value;
        }
    }

    private Suit suit;
    private Value value;

    public NormalCard(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public int getValue() {
        return value.value;
    }

    public void setValue(int value) {
        this.value.value = value;
    }

    @Override
    public String toString() {
        return this.value + " of " + this.suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final NormalCard other = (NormalCard) obj;
        if (this.suit != other.getSuit()) {
            return false;
        }

        if (this.value.value != other.getValue()) {
            return false;
        }
        
        return true;
    }
}
