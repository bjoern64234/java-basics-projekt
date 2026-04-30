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
        return false;
    }
}
