package controller;


import service.InputGetter;
import view.View;

public class MainController {
    private InputGetter inputGetter;
    private View view;

    private static final String checkPassword = "1";
    private static final String exit = "2";


    private boolean isAppEnd = false;

    public MainController() {
        this.inputGetter = new InputGetter();
        this.view = new View();
    }

    public void runApp() {
        String userInput;

        while (!isAppEnd) {
            view.displayMenu();
            userInput = inputGetter.takeUserInput();

            if (checkPassword.equals(userInput)) {
                ;
            }

            if (exit.equals(userInput)) {
                isAppEnd = true;
            }
        }
    }
}
