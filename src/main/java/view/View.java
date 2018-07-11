package view;

public class View {

    private static final String passwordCracker = "Password cracker";
    private static final String mainMenuLabel = "Main menu";
    private static final String[] menuOptions =
            new String[] {"1. Enter password", "2. Exit"};

    public void displayMenu() {
        System.out.println(passwordCracker + "\n");
        System.out.println(mainMenuLabel);

        for (String menuOption : menuOptions) {
            System.out.println(menuOption);
        }

        System.out.println("Enter number option: ");
    }

}
