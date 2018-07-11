package service;

import utils.Complexity;

public class PasswordService {

    private static boolean containsDigits = false;
    private static boolean containsUpperCaseCharacter = false;
    private static boolean containsLowerCaseCharacter = false;
    private static Complexity complexity = null;

    public static void validate(String password) throws IllegalArgumentException {
        iterate(password);
        if (containsLowerCaseCharacter) complexity = Complexity.HARD;
        else if (containsUpperCaseCharacter) complexity = Complexity.MEDIUM;
        else if (containsDigits) complexity = Complexity.EASY;
    }

    public static Complexity getComplexity() {
        return complexity;
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
                throw new IllegalArgumentException("Illegal character! Password can contain only numbers and letters");
            }
        }
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
