package task_5;

import java.util.regex.*;

public class EmailValidator {
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    public static void validateEmail(String email) throws InvalidEmailException {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new InvalidEmailException("Invalid email: " + email);
        }

        System.out.println("Valid email: " + email);
    }
}
