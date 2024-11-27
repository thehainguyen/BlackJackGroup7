package ca.sheridancollege.project;

/**
 * The InputValidator class provides static methods for validating user input 
 * during the game. It includes checks for valid gameplay actions, such as whether 
 * a player wants to hit or stand, whether the player's name is valid, and if 
 * the player's bet is within a valid range. The class ensures that the game 
 * runs smoothly by preventing invalid user input.
 * 
 * @author The Hai Nguyen - 991745555 - November 27, 2024
 */
public class InputValidator {

    /**
     * Validates if the input is either "hit" or "stand".
     * This method is used to determine if the player wants to hit or stand during the game.
     * 
     * @param input The input string from the user.
     * @return True if the input is either "hit" or "stand", otherwise false.
     */
    public static boolean isHitOrStand(String input) {
        return input.equals("hit") || input.equals("stand");
    }

    /**
     * Validates if the input is either "yes" or "no".
     * This method is used to handle simple yes/no responses in the game.
     * 
     * @param input The input string from the user.
     * @return True if the input is either "yes" or "no", otherwise false.
     */
    public static boolean isYesOrNo(String input) {
        return input.equals("yes") || input.equals("no");
    }

    /**
     * Validates if the name entered is not blank and contains only alphanumeric characters.
     * This method is used to ensure that the player's name is valid.
     * 
     * @param name The player's name to validate.
     * @return True if the name is not blank and contains only valid characters, otherwise false.
     */
    public static boolean isValidName(String name) {
        return !name.isBlank() && name.matches("\\w+");
    }

    /**
     * Validates if the bet is positive and less than or equal to the player's available chips.
     * This method is used to check that the player's bet is within their available balance.
     * 
     * @param player The player making the bet.
     * @param bet The amount the player wishes to bet.
     * @return True if the bet is valid, otherwise false.
     */
    public static boolean isValidBet(MainPlayer player, int bet) {
        return bet > 0 && bet <= player.getChips();
    }

    /**
     * Validates if the value of an Ace is either 1 or 11.
     * This method ensures that the player can only choose valid values for the Ace card.
     * 
     * @param aceValue The value the player wants to assign to the Ace card.
     * @return True if the Ace value is either 1 or 11, otherwise false.
     */
    public static boolean isValidAceValue(int aceValue) {
        return aceValue == 1 || aceValue == 11;
    }
}
