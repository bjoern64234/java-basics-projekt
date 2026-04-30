import java.util.Scanner;

public final class PasswordValidator {

    static void main() {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your password:");
        String password = input.nextLine();

        boolean isValid = hasMinLength(password);
        System.out.println(isValid);
    }

    public static boolean hasMinLength(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        return password.length() >= 8;
    }
}
