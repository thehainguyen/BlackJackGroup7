package ca.sheridancollege.project;

public class HandOfCards extends GroupOfCards {
    // Add a card to the group
    public void addCard(Card card) {
        getCards().add(card);
    }

    // Reset 
    public void reset() {
        getCards().clear();
    }
}
