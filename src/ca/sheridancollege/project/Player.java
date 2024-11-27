/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Each player has a unique name (ID), 
 * a hand of cards, and a score. This class provides methods for managing the player's 
 * name, hand, and score during the game.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @moffied by The Hai Nguyen - 991745555 - October 30, 2024
 */
public abstract class Player {

    private String name; //the unique name for this player
    private HandOfCards cards; // the cards that this player holds
    private int score; // the score of this player

    /**
     * Constructs a Player object with a unique name. Initializes the player's hand and score.
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        this.cards = new HandOfCards();
        this.score = 0;
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

    /**
     * Adds a card to the player's hand.
     * 
     * @param card The card to add to the player's hand.
     */
    public void addCard(Card card) {
        cards.addCard(card);
    }

    /**
     * Gets the list of cards the player holds in their hand.
     * 
     * @return An ArrayList of cards held by the player.
     */
    public ArrayList<Card> getCards() {
        return cards.getCards();
    }

    /**
     * Gets the score of the player.
     * 
     * @return The player's current score.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Sets the player's score to the specified value.
     * 
     * @param score The score to set for the player.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Adds the specified value to the player's score.
     * 
     * @param score The score to add to the player's current score.
     */
    public void addScore(int score) {
        this.score += score;
    }

    /**
     * Resets the player's hand of cards and score. This method is used to prepare the player 
     * for a new round of the game.
     */
    public void releaseCards() {
        this.cards.reset();
        this.score = 0;
    }
}