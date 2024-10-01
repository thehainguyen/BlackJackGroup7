package ca.sheridancollege.project;

import java.util.Random;
import java.util.Scanner;

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
        NormalCard card = getRandomCard();

        // Check if the card is an Ace
        if (card.getValue() == 1) {
            // Instantiate the scanner
            Scanner scanner = new Scanner(System.in);

            // Ask the player if they want an Ace as 1 or 11
            System.out.println("An Ace was dealt. Do you want it as 1 or 11?");
            int choice = scanner.nextInt();
            
            // Set the value of the card
            switch (choice) {
                case 1 -> card.setValue(1);
                case 11 -> card.setValue(11);
                default -> card.setValue(1);
            }
        }

        player.addCard(card);
    }
    
    public void dealToSelf() {
        addCard(getRandomCard());
    }

    public NormalCard getRandomCard() {
        Random rand = new Random();
        return new NormalCard(Suit.values()[rand.nextInt(4)], Value.values()[rand.nextInt(13)]);
    }
}
