package ca.sheridancollege.project;

import java.util.Random;

import ca.sheridancollege.project.NormalCard.Suit;
import ca.sheridancollege.project.NormalCard.Value;

public class Dealer extends Player {

    public Dealer() {
        super("Dealer");
    }

    public void start(MainPlayer player) {
        //Deal 2 cards to the player
        for (int i = 0; i < 2; i++) {
            dealToPlayer(player);
            dealToSelf();
        }
    }

    public void dealToPlayer(MainPlayer player) {
        player.addCard(getRandomCard());
    }
    
    public void dealToSelf() {
        addCard(getRandomCard());
    }

    public NormalCard getRandomCard() {
        Random rand = new Random();
        return new NormalCard(Suit.values()[rand.nextInt(4)], Value.values()[rand.nextInt(13)]);
    }
}
