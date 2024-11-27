/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @moffied by The Hai Nguyen - 991745555 - September 30, 2024
 */
public abstract class Player {

    private String name; //the unique name for this player
    private HandOfCards cards; // the cards that this player holds
    private int score; // the score of this player

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        this.cards = new HandOfCards();
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    // Add a card to the player's hand
    public void addCard(Card card) {
        cards.addCard(card);
    }

    // Get the group of cards from the player
    public ArrayList<Card> getCards() {
        return cards.getCards();
    }       

    // Get the player's score
    public int getScore() {
        return this.score;
    }

    // Set the player's score
    public void setScore(int score) {
        this.score = score;
    }

    // Add the player's score
    public void addScore(int score) {
        this.score += score;
    }

    // Reset the player cards
    public void releaseCards() {
        this.cards.reset();
        this.score = 0;
    }
}
