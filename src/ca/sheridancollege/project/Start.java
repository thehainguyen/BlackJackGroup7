package ca.sheridancollege.project;

/**
 * The Start class is the entry point for the Blackjack game.
 * It manages the overall game flow, including initializing the player and dealer,
 * starting the game, handling betting, playing rounds, and asking the player if they want to play again.
 * The game continues as long as the player has chips and chooses to continue.
 * 
 * @author The Hai Nguyen - 991745555 - November 27, 2024
 */
public class Start {

    /**
     * The main method that starts the Blackjack game. It initializes the game objects
     * (player, dealer, and game), sets up the initial game conditions, and runs the game loop.
     * The player is prompted to place a bet, and after each round, they are asked if they want to play again.
     * The game ends when the player runs out of chips or chooses to stop playing.
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Get the name of the player
        String name = Prompter.askPlayerName();

        // Welcome the player
        System.out.println("Welcome to Blackjack, " + name + "!");
        System.out.println();

        // Create the player and the dealer
        MainPlayer player = new MainPlayer(name);
        Dealer dealer = new Dealer();

        // Create the game
        MainGame game = new MainGame("Blackjack");

        // Set the player and the dealer in the game
        game.setPlayer(player);
        game.setDealer(dealer);

        // Start the game loop
        String userAnswer = "yes";
        while (userAnswer.equals("yes")) {
            // Ask the player to place a bet
            Prompter.askPlayerBet(player);

            // Play a round of the game
            game.play();

            // If the player has no chips, exit the game
            if (player.getChips() == 0) {
                break;
            }

            // Reset the game for the next round
            game.playAgain();
            
            // Ask if the player wants to play another round
            userAnswer = Prompter.askPlayerToPLayAgain();
        }

        // Display the final result after the game ends
        Displayer.displayFinalResult(player);

        // Exit the game
        System.out.println();
        System.out.println("Thanks for playing!");
    }
}
