import java.lang.reflect.Array;
import java.util.Scanner;

public final class PasswordValidator {

    static void main() {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your password:");
        String password = input.nextLine();

        boolean hasMinLength = hasMinLength(password);
        System.out.println(hasMinLength);

        boolean containsDigit = containsDigit(password);
        System.out.println(containsDigit);
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
}
