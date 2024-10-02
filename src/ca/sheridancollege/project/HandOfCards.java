package ca.sheridancollege.project;

import java.util.ArrayList;

public class HandOfCards extends GroupOfCards {
    // The total score of the group of cards
    private int totalScore = 0;

    // Add a card to the group
    public void addCard(NormalCard card) {
        getCards().add(card);
        this.totalScore += card.getValue();
    }

    // Get the total score
    public int getTotalScore() {
        return totalScore;
    }

    // Set the total score
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    // Reset 
    public void reset() {
        this.totalScore = 0;
        getCards().clear();
    }
}
