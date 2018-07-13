package view;

public class View {

    private static final String passwordCracker = "Running Password cracker";
    private static final String passwordAPICrawler = "Checking if password has been breached";
    private static final String mainMenuLabel = "Main menu";
    private static final String[] menuOptions =
                new String[] {"1. Brute force password check", "2. Password's in-API presence check ", "3. Exit"};

    public void displayMenu() {
        System.out.println(passwordCracker + "\n");
        System.out.println(mainMenuLabel);

        for (String menuOption : menuOptions) {
            System.out.println(menuOption);
        }

        System.out.println("Enter number option: ");
    }

    public void display(String msg) {
        System.out.println(msg);
    }

    public void displayError(String msg) {
        System.out.println(msg);
    }

}
