package ca.sheridancollege.project;

/**
 * The MainPlayer class models a player in the game who has chips, can place bets, and tracks
 * their performance during the game. It extends the Player class, adding attributes and methods
 * for managing the player's chips, bet, maximum chips, and round statistics (wins and losses).
 * 
 * The player starts with an initial chip amount of 1000 and can update these attributes
 * based on the gameplay.
 * 
 * @author The Hai Nguyen
 * @studentID 991745555
 * @date November 27, 2024
 */
public class MainPlayer extends Player {

    private int chips = 1000; // The player's current chips
    private int maxChips = 1000; // The maximum number of chips the player has achieved
    private int bet = 0; // The player's current bet

    private int winRounds = 0; // The number of rounds the player has won
    private int loseRounds = 0; // The number of rounds the player has lost

    /**
     * Constructor to initialize a MainPlayer with a given name.
     * The player starts with a default chip count of 1000.
     * 
     * @param name The name of the player.
     */
    public MainPlayer(String name) {
        super(name);
    }

    /**
     * Gets the player's current chip count.
     * 
     * @return The number of chips the player currently has.
     */
    public int getChips() {
        return chips;
    }

    /**
     * Updates the player's chip count.
     * 
     * @param chips The new chip count for the player.
     */
    public void setChips(int chips) {
        this.chips = chips;
    }

    /**
     * Gets the player's current bet.
     * 
     * @return The amount the player has bet in the current round.
     */
    public int getBet() {
        return bet;
    }

    /**
     * Sets the amount the player has bet in the current round.
     * 
     * @param bet The amount the player wants to bet.
     */
    public void setBet(int bet) {
        this.bet = bet;
    }

    /**
     * Gets the maximum number of chips the player has achieved during the game.
     * 
     * @return The maximum chips the player has reached.
     */
    public int getMaxChips() {
        return maxChips;
    }

    /**
     * Updates the maximum chips value.
     * 
     * @param maxChips The new maximum chips value.
     */
    public void setMaxChips(int maxChips) {
        this.maxChips = maxChips;
    }

    /**
     * Gets the number of rounds the player has won.
     * 
     * @return The number of rounds won by the player.
     */
    public int getWinRound() {
        return winRounds;
    }

    /**
     * Updates the number of rounds the player has won.
     * 
     * @param winRound The new number of rounds won by the player.
     */
    public void setWinRound(int winRound) {
        this.winRounds = winRound;
    }

    /**
     * Gets the number of rounds the player has lost.
     * 
     * @return The number of rounds lost by the player.
     */
    public int getLoseRound() {
        return loseRounds;
    }

    /**
     * Updates the number of rounds the player has lost.
     * 
     * @param loseRound The new number of rounds lost by the player.
     */
    public void setLoseRound(int loseRound) {
        this.loseRounds = loseRound;
    }
}
