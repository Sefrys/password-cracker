package main.java.model;

public class Comparator {

    private static String password;

    public Comparator(String password) {
        Comparator.password = password;
    }

    public static boolean isPasswordFound(String result) {
        return password.equals(result);
    }
}
