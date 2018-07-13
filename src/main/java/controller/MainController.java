package controller;


import model.BinarySearch;
import model.Comparator;
import model.Password;
import service.InputGetter;
import utils.Message;
import view.BinarySearchView;
import view.View;

public class MainController {
    private InputGetter inputGetter;
    private View view;
    private BinarySearchView bsView;
    private BinarySearchController bsC;
    private String passwordToCrack;


    private static final String crackPassword = "1";
    private static final String checkPassword = "2";

    private static final String exit = "3";


    private boolean isAppEnd = false;

    public MainController(BinarySearchController bsC) {
        this.inputGetter = new InputGetter();
        this.view = new View();
        this.bsC = bsC;
        this.bsView = new BinarySearchView();

    }

    public void runApp() {
        String userInput;

        while (!isAppEnd) {
            view.displayMenu();
            userInput = inputGetter.takeUserInput();

            if (checkPassword.equals(userInput)) {

                view.display(Message.passwordInput.msg);
                this.passwordToCrack = inputGetter.takeUserInput();

                handleBinarySearch();
            }

            if (crackPassword.equals(userInput)) {
                view.display(Message.passwordInput.msg);
                this.passwordToCrack = inputGetter.takeUserInput();
                handleCrackPassword();
            }

            if (exit.equals(userInput)) {
                isAppEnd = true;
                break;
            }
        }
    }

    private void handleBinarySearch() {
        bsC.binarySearch(passwordToCrack);
        if (bsC.getBinarySearch().isSearchFinished()) {
            bsView.printLine("Search finished.");
        }
        if (bsC.getBinarySearch().isPasswordFound()) {
            bsView.printLine("Password found. Times breached: " + bsC.getBinarySearch().getBreachCount());
        } else {
            bsView.printLine("Password is not in databse");
        }

    }

    private void handleCrackPassword() {
        Password password = null;
        try {
            password = new Password(passwordToCrack);
        }
        catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        }
        
        if (password != null) {
            new Comparator(password.getPassword());
            BruteForceController.runCracker(password);
        }
    }
}
