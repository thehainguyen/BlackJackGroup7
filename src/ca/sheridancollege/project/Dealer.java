package ca.sheridancollege.project;

import java.util.Scanner;

public class Dealer extends Player {

    public Dealer() {
        super("Dealer");
    }
    
    public void play(Player player, GroupOfCards deckOfCards) {
        // Dealer's turn
        int playerScore = player.getScore();

        // Dealer will hit until dealer's score is above the player's score
        while (getScore() < playerScore) {
            dealToSelf(deckOfCards);
        }

        // If dealer's score is equal to or above 16, dealer will stand
        if (getScore() == playerScore && getScore() <16) {
            dealToSelf(deckOfCards);
        }
    }

    public void start(MainPlayer player, GroupOfCards deckGroupOfCards) {
        //Deal 2 cards to the player
        dealToPlayer(player, deckGroupOfCards);
        dealToPlayer(player, deckGroupOfCards);

        System.out.println();
        
        //Deal 2 cards to the dealer
        dealToSelf(deckGroupOfCards);
        dealToSelf(deckGroupOfCards);
    }

    public void dealToPlayer(MainPlayer player, GroupOfCards deckGroupOfCards) {
        // Get the first card from the deck and remove it from the deck
        NormalCard card = (NormalCard) deckGroupOfCards.getCards().removeFirst();

        // Check if the card is an Ace
        if (card.getValue() == 1 || card.getValue() == 11) {
            // Instantiate the scanner
            Scanner scanner = new Scanner(System.in);

            // Ask the player if they want an Ace as 1 or 11
            System.out.print("An Ace was dealt to you. Please choose the value you want (1 or 11): ");
            int choice = scanner.nextInt();
            
            // Set the value of the card
            switch (choice) {
                case 1 -> card.setValue(1);
                case 11 -> card.setValue(11);
                default -> card.setValue(1);
            }
        }

        player.addCard(card);
        
        // Display the card
        System.out.println("You got: " + card.toString());
    }
    
    public void dealToSelf(GroupOfCards deckGroupOfCards) {
        // Get the first card from the deck and remove it from the deck
        NormalCard card = (NormalCard) deckGroupOfCards.getCards().removeFirst();

        // Check if the card is an Ace
        if (card.getValue() == 1 || card.getValue() == 11) {
            // If score is less than 11, set the value to 11
            if (this.getScore() < 11) { 
                card.setValue(11);
            }
        }

        // Display the card
        System.out.println("The Dealer got: " + card.toString());

        // Add the card to the dealer's hand
        addCard(card);
    }
}
