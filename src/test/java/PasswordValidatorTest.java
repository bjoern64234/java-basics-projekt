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

    /** Run tests for containsDigit **/
    @Test
    void containsDigit_isTrueWhenPasswordHasOnlyOneDigit() {
        // Given
        String password = "fdsfdfs3dfdfds";
        // When
        boolean result = PasswordValidator.containsDigit(password);
        // Then
        assertTrue(result);
    }

    @Test
    void containsDigit_isTrueWhenPasswordHasOnlyDigits() {
        // Given
        String password = "432423432432";
        // When
        boolean result = PasswordValidator.containsDigit(password);
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

    /** Run tests for containsUpperAndLower **/
    @Test
    void containsUpperAndLower_isTrueWhenUpperAndLower() {
        // Given
        String password = "KSDLdwdw23";
        // When
        boolean result = PasswordValidator.containsUpperAndLower(password);
        // Then
        assertTrue(result);
    }

    @Test
    void containsUpperAndLower_isFalseWhenOnlyUppercase() {
        // Given
        String password = "IEUDJWODPWMMCS";
        // When
        boolean result = PasswordValidator.containsUpperAndLower(password);
        // Then
        assertFalse(result);
    }

    @Test
    void containsUpperAndLower_isFalseWhenOnlyLowercase() {
        // Given
        String password = "sadsdawwqds";
        // When
        boolean result = PasswordValidator.containsUpperAndLower(password);
        // Then
        assertFalse(result);
    }

    @Test
    void containsUpperAndLower_isFalseWhenOnlyOneLetter() {
        // Given
        String password = "H";
        // When
        boolean result = PasswordValidator.containsUpperAndLower(password);
        // Then
        assertFalse(result);
    }

    /** Run tests for isCommonPassword **/
    @ParameterizedTest
    @CsvSource({
            "password",
            "Passwort1",
            "12345678",
            "Aa345678"
    })
    void isCommonPassword_isTrueWhenForbiddenPassword(String forbidden) {
        // When
        boolean result = PasswordValidator.isCommonPassword(forbidden);
        // Then
        assertTrue(result);
    }

    /** Run tests for isValid **/
    @ParameterizedTest
    @CsvSource({
            "Abc1defg#",
            "Abcdef1g!",
            "Smdj3mfkQr&"
    })
    void isValid_isTrueForGivenPasswords(String password) {
        // When
        boolean result = PasswordValidator.isValid(password);
        // Then
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({
            "Abc1def",
            "Abcdefgh",
            "abcdefg1",
            "ABCDEFG1",
            "Passwort1",
            "mcdlspapc",
            "ASLKSAJEKC"
    })
    void isValid_isTrueForGivenWrongPasswords(String password) {
        // When
        boolean result = PasswordValidator.isValid(password);
        // Then
        assertFalse(result);
    }

    @ParameterizedTest
    @CsvSource({
            "@Abc1def",
            "Abcde$%fgh",
            "abc$ds2fg1",
            "ABCD&FG1"
    })
    void containsSpecialChar_isTrueWhenASpecialCharIsGiven(String password) {
        // When
        boolean result = PasswordValidator.containsSpecialChar(password, "!@#$%^&*()-_+=?.,;:");
        // Then
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({
            "jAbc1def",
            "Abcde67fgh",
            "abcWds2fg1",
            "ABCDTFG1"
    })
    void containsSpecialChar_isFalseWhenASpecialCharIsNotGiven(String password) {
        // When
        boolean result = PasswordValidator.containsSpecialChar(password, "!@#$%^&*()-_+=?.,;:");
        // Then
        assertFalse(result);
    }
}