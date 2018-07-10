package main.java.utils;

public class Complexity {

    private char[] signContainer;

    private static final String easy = "easy";
    private static final String medium = "medium";
    private static final String advanced = "advanced";

    public Complexity(String level) {
        if (level.equals(easy)) {
            signContainer = prepareNumbers();
        }
        else if (level.equals(medium)) {
            signContainer = prepareChars();
        }
        else if (level.equals(advanced)) {
            signContainer = prepareAll();
        }
    }

    private char[] prepareNumbers() { return "1234567890".toCharArray(); }
    private char[] prepareChars() { return "abcdefghijklmnopqrstuvwxyz".toCharArray(); }
    private char[] prepareAll() { return "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray(); }

    public char[] getSignContainer() {
        return signContainer;
    }


}
