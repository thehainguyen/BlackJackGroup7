package ca.sheridancollege.project;

/**
 * The MainPlayer class models a player in the game who has chips and can place bets.
 * It extends the Player class, adding functionality for tracking the player's chips 
 * and the amount they have bet in the current round. The player starts with an initial
 * chip amount and can update their chips and bet throughout the game.
 * 
 * @author The Hai Nguyen - 991745555 - November 27, 2024
 */
public class MainPlayer extends Player {

    private int chips = 1000; // The player's current chips
    private int bet = 0; // The player's current bet

    /**
     * Constructor to set the name of the player and initialize their chips and bet.
     * 
     * @param name The name of the player.
     */
    public MainPlayer(String name) {
        // Set the name of the player
        super(name);
    }

    /**
     * Gets the current number of chips the player has.
     * 
     * @return The number of chips the player has.
     */
    public int getChips() {
        return chips;
    }

    /**
     * Sets the player's chip count to the specified value.
     * 
     * @param chips The new chip count for the player.
     */
    public void setChips(int chips) {
        this.chips = chips;
    }

    /**
     * Gets the current bet placed by the player.
     * 
     * @return The amount the player has bet.
     */
    public int getBet() {
        return bet;
    }

    /**
     * Sets the amount the player has bet in the current round.
     * 
     * @param bet The new bet amount.
     */
    public void setBet(int bet) {
        this.bet = bet;
    }
}
