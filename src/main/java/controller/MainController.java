package main.java.controller;

public class MainController {

    private static final String exit = "exit";

    private boolean isAppEnd = false;

    public void runApp() {
        while (!isAppEnd) {

            if (exit.equals(userInput)) {
                isAppEnd = true;
            }
        }
    }
}
