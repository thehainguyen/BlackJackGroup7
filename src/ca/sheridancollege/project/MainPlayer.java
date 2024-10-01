package ca.sheridancollege.project;

public class MainPlayer extends Player {
    private int chips = 1000;
    private int bet = 0;

    public MainPlayer(String name) {
        super(name);
    }

    public void win() {
        System.out.println(this.getName() + " won " + this.getBet() + " chips!");
        this.setChips(this.getChips() + this.getBet());
    }

    public void lose() {
        System.out.println(this.getName() + " lost " + this.getBet() + " chips!");
        this.setChips(this.getChips() - this.getBet());
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}
