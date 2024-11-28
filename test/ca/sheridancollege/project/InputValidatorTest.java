package ca.sheridancollege.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for the InputValidator class.
 * 
 * This class contains test cases to validate the correctness of the InputValidator
 * methods. The methods are tested for good, bounded (edge cases), and bad inputs 
 * to ensure robustness and proper behavior in various scenarios.
 * 
 * Methods tested include:
 * - isHitOrStand: Validates input for "hit" or "stand".
 * - isYesOrNo: Validates input for "yes" or "no".
 * - isValidName: Validates player names for non-blank and valid formats.
 * - isValidBet: Validates player bets within allowable chip range.
 * - isValidAceValue: Validates if an ace value is either 1 or 11.
 * 
 * @author The Hai Nguyen
 * @studentID 991745555
 * @date November 28, 2024
 */
public class InputValidatorTest {

    /**
     * Test of isHitOrStand method, of class InputValidator.
     */
    @Test
    public void testIsHitOrStand() {
        System.out.println("isHitOrStand");

        // Good test case: Valid input
        assertTrue(InputValidator.isHitOrStand("hit"));
        assertTrue(InputValidator.isHitOrStand("stand"));

        // Bounded test case: Case-sensitive input
        assertFalse(InputValidator.isHitOrStand("Hit"));
        assertFalse(InputValidator.isHitOrStand("Stand"));

        // Bad test case: Invalid input
        assertFalse(InputValidator.isHitOrStand("sit"));
        assertFalse(InputValidator.isHitOrStand(""));
    }

    /**
     * Test of isYesOrNo method, of class InputValidator.
     */
    @Test
    public void testIsYesOrNo() {
        System.out.println("isYesOrNo");

        // Good test case: Valid input
        assertTrue(InputValidator.isYesOrNo("yes"));
        assertTrue(InputValidator.isYesOrNo("no"));

        // Bounded test case: Case-sensitive input
        assertFalse(InputValidator.isYesOrNo("Yes"));
        assertFalse(InputValidator.isYesOrNo("No"));

        // Bad test case: Invalid input
        assertFalse(InputValidator.isYesOrNo("maybe"));
        assertFalse(InputValidator.isYesOrNo(""));
    }

    /**
     * Test of isValidName method, of class InputValidator.
     */
    @Test
    public void testIsValidName() {
        System.out.println("isValidName");

        // Good test case: Valid name
        assertTrue(InputValidator.isValidName("Player1"));
        assertTrue(InputValidator.isValidName("JohnDoe"));

        // Bounded test case: Edge case with special characters
        assertFalse(InputValidator.isValidName("John_Doe"));
        assertFalse(InputValidator.isValidName("John@Doe"));

        // Bad test case: Blank or invalid input
        assertFalse(InputValidator.isValidName(""));
        assertFalse(InputValidator.isValidName("   "));
    }

    /**
     * Test of isValidBet method, of class InputValidator.
     */
    @Test
    public void testIsValidBet() {
        System.out.println("isValidBet");
        MainPlayer player = new MainPlayer("Player1");
        player.setChips(100);

        // Good test case: Valid bet within range
        assertTrue(InputValidator.isValidBet(player, 50));
        assertTrue(InputValidator.isValidBet(player, 100));

        // Bounded test case: Edge values
        assertFalse(InputValidator.isValidBet(player, 0));
        assertFalse(InputValidator.isValidBet(player, 101));

        // Bad test case: Invalid bet
        assertFalse(InputValidator.isValidBet(player, -10));
        assertFalse(InputValidator.isValidBet(null, 50));
    }

    /**
     * Test of isValidAceValue method, of class InputValidator.
     */
    @Test
    public void testIsValidAceValue() {
        System.out.println("isValidAceValue");

        // Good test case: Valid ace values
        assertTrue(InputValidator.isValidAceValue(1));
        assertTrue(InputValidator.isValidAceValue(11));

        // Bounded test case: Near valid values
        assertFalse(InputValidator.isValidAceValue(0));
        assertFalse(InputValidator.isValidAceValue(12));

        // Bad test case: Invalid ace values
        assertFalse(InputValidator.isValidAceValue(-1));
        assertFalse(InputValidator.isValidAceValue(5));
    }
}
