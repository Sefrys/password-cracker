package controller;


import model.Comparator;
import model.Password;
import service.InputGetter;
import utils.Message;
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
                handleCrackPassword();
            }

            if (exit.equals(userInput)) {
                isAppEnd = true;
            }
        }
    }

    private void handleCrackPassword() {
        view.display(Message.passwordInput.msg);
        String passwordToCrack = inputGetter.takeUserInput();

        try {
            Password password = new Password(passwordToCrack);
            new Comparator(password.getPassword());
            BruteForceController.runCracker(password);
        }
        catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        }

        
    }
}
