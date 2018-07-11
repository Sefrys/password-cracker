package service;

import utils.Complexity;

public class PasswordService {

    private static boolean containsDigits = false;
    private static boolean containsUpperCaseCharacter = false;
    private static boolean containsLowerCaseCharacter = false;
    private static Complexity complexity = null;

    public static void validate(String password) throws IllegalArgumentException {
        iterate(password);
        if (containsDigits && containsLowerCaseCharacter && containsUpperCaseCharacter) complexity = Complexity.HARD;
        else if (containsUpperCaseCharacter && containsDigits) complexity = Complexity.ADVANCED;
        else if (!containsDigits && containsUpperCaseCharacter) complexity = Complexity.MEDIUM;
        else if (containsDigits && !containsUpperCaseCharacter && !containsLowerCaseCharacter) complexity = Complexity.EASY;
    }

    private static void iterate(String password) throws IllegalArgumentException {
        for (char letter : password.toCharArray()) {
            if (isUpperCaseLetter(letter)) {
                containsUpperCaseCharacter = true;
            } else if (isLowerCaseLetter(letter)) {
                containsLowerCaseCharacter = true;
            } else if (isDigit(letter)) {
                containsDigits = true;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public static Complexity getComplexity() {
        return complexity;
    }

    private static boolean isUpperCaseLetter(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    private static boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    private static boolean isLowerCaseLetter(char c) {
        return (c >= 'a' && c <= 'z');
    }
}
