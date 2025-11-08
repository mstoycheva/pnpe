package task_6;

import java.util.regex.*;

public class PasswordValidator {

    public static void validatePassword(String pass)
            throws ShortPasswordException, NoUppercaseException,
            NoDigitException, NoSpecialCharacterException {

        if (pass.length() < 8) {
            throw new ShortPasswordException("Too short password / 8 at least");
        }

        if (!Pattern.compile("[A-Z]").matcher(pass).find()) {
            throw new NoUppercaseException("No uppercase letter found");
        }

        if (!Pattern.compile("[0-9]").matcher(pass).find()) {
            throw new NoDigitException("No digit found");
        }

        if (!Pattern.compile("[!@#$%^&*]").matcher(pass).find()) {
            throw new NoSpecialCharacterException("No special character found");
        }

        System.out.println("Password is correct!");
    }
}
