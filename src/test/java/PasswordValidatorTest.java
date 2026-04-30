import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    /** Run tests for hasMinLength **/
    @ParameterizedTest
    @CsvSource({
            "1",
            "7"
    })
    void hasMinLength_isFalseWhenLessThen8(String password) {
        // When
        boolean result = PasswordValidator.hasMinLength(password);
        // Then
        assertFalse(result);
    }

    @Test
    void hasMinLength_isFalseWhenNull() {
        // Given
        String password = null;
        // When
        boolean result = PasswordValidator.hasMinLength(password);
        // Then
        assertFalse(result);
    }

    @Test
    void hasMinLength_isFalseWhenEmpty() {
        // Given
        String password = "";
        // When
        boolean result = PasswordValidator.hasMinLength(password);
        // Then
        assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({
            "xksnerko",
            "ksndjetnd",
    })
    void hasMinLength_isTrueWhenEqualOrGreaterThen8(String password) {
        // When
        boolean result = PasswordValidator.hasMinLength(password);
        // Then
        assertTrue(result);
    }

    @Test
    void containsDigit_isTrueWhenPasswordHasMinOneDigit() {
        // Given
        String password = "sdf2cd1dsaw";
        // When
        boolean result = PasswordValidator.containsDigit(password);
        // Then
        assertTrue(result);
    }

    @Test
    void containsDigit_isFalseWhenPasswordHasMinOneDigit() {
        // Given
        String password = "sadsdawwqds";
        // When
        boolean result = PasswordValidator.containsDigit(password);
        // Then
        assertFalse(result);
    }
}