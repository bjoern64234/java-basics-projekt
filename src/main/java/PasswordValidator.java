import java.util.Scanner;
import java.util.Set;

public final class PasswordValidator {

    private static final Set<String> forbidden = Set.of(
            "password",
            "Passwort1",
            "12345678",
            "Aa345678"
    );

    private static final String specialCharString = "!@#$%^&*()-_+=?.,;:";
    private static final String lettersCharString = "abcdefghijklmnopqrstuvwxyz";
    private static final String numbersCharString = "0123456789";

    static void main() {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your password:");
        String password = input.nextLine();

        boolean hasMinLength = hasMinLength(password);
        System.out.println(hasMinLength);

        boolean containsDigit = containsDigit(password);
        System.out.println(containsDigit);

        String securePassword = generateSecurePassword(8);
        System.out.println(securePassword);
    }

    public static boolean hasMinLength(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        return password.length() >= 8;
    }

    public static boolean containsDigit(String password) {
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] passwordArray = password.split("");

        for (String letter : passwordArray) {
            for (String digit : digits) {
                if (letter.equals(digit)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean containsUpperAndLower(String password) {
        if (password.length() == 1) {
            return false;
        }

        boolean isUpperCaseLetter = false, isLowerCaseLetter = false;
        char[] chars = password.toCharArray();

        for (char letter : chars) {
            if(Character.isUpperCase(letter)) {
                isUpperCaseLetter = true;
            }
            if(Character.isLowerCase(letter)) {
                isLowerCaseLetter = true;
            }
        }

        return isUpperCaseLetter && isLowerCaseLetter;
    }

    public static boolean isCommonPassword(String password) {

        for (String forbidden : forbidden) {
            if (password.equalsIgnoreCase(forbidden)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSpecialChar(String password, String specialCharString) {
        char[] specialChars = specialCharString.toCharArray();
        char[] letters = password.toCharArray();

        for (char letter : letters) {
            for (char specialChar : specialChars) {
                if (letter == specialChar) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isValid(String password) {
        String p = password.trim();

        return hasMinLength(p) && containsDigit(p) && containsUpperAndLower(p) && !isCommonPassword(p) && containsSpecialChar(p, specialCharString);
    }

    public static String generateSecurePassword(int length) {
        boolean isValid = false;
        String securePassword = "";
        // Set output to input length
        char[] output = new char[length];
        // Get all chars
        char[] specialChars = specialCharString.toCharArray();
        char[] lowerLettersChars = lettersCharString.toCharArray();
        char[] upperLettersChars = lettersCharString.toUpperCase().toCharArray();
        char[] numberChars = numbersCharString.toCharArray();
        // Set char array of available charSets
        char[][] charSets = {specialChars, lowerLettersChars, upperLettersChars, numberChars};

        // Generate securePassword since it is not valid
        while(!isValid) {
            for (int j = 0; j < length; j++) {
                // Select random charSet
                int randomCharset = (int) (Math.random() * charSets.length);
                char[] currentCharSet = charSets[randomCharset];
                // Select random char from charSet
                int randomChar = (int) (Math.random() * currentCharSet.length);
                output[j] = currentCharSet[randomChar];
            }

            securePassword = new String(output);
            isValid = isValid(securePassword);
        }

        return securePassword;
    }
}
