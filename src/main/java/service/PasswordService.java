package service;

import utils.Complexity;

public class PasswordService {

    public static Complexity validate(String password) {
        boolean containsDigits = false;
        boolean containsCharacter = false;

        for (char letter : password.toCharArray()) {
            if (isLetter(letter)) {
                containsCharacter = true;
            } else if (isDigit(letter)) {
                containsDigits = true;
            }
        }

        if (containsCharacter && containsDigits) return Complexity.ADVANCED;
        else if (containsDigits && !containsCharacter) return Complexity.EASY;
        else if (!containsDigits && containsCharacter) return Complexity.MEDIUM;
        return Complexity.ERROR;
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    private static boolean isDigit(char c) {
       return (c >= '0' && c <= '9');
    }

}
