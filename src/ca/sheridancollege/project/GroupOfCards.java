/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @moffied by The Hai Nguyen - 991745555 - September 30, 2024
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<>();
    // The total score of the group of cards
    private int totalScore;

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    // Add a card to the group
    public void addCard(NormalCard card) {
        cards.add(card);
        this.totalScore += card.getValue();
    }

    // Shuffle the cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Get the total score
    public int getTotalScore() {
        return totalScore;
    }

    // Reset 
    public void reset() {
        this.totalScore = 0;
        this.cards = new ArrayList<>();
    }
}
