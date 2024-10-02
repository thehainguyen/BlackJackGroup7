package ca.sheridancollege.project;

public class MainPlayer extends Player {
    // Player's chips
    private int chips = 1000;
    // Player's bet
    private int bet = 0;

    public MainPlayer(String name) {
        // Set the name of the player
        super(name);
    }

    // Chips getter and setter
    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    // Bet getter and setter
    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}
