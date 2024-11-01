package ca.sheridancollege.project;

public class InputValidator {

    public static boolean isHitOrStand(String input) {
        return input.equals("hit") || input.equals("stand");
    }

    public static boolean isYesOrNo(String input) {
        return input.equals("yes") || input.equals("no");
    }

    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static boolean isValidBet(MainPlayer player, int bet) {
        return bet > 0 && bet <= player.getChips();
    }
}
