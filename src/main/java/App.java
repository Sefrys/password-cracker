import controller.BinarySearchController;
import view.BinarySearchView;

public class App {
    public static void main(String[] args) {
        BinarySearchController bsController = new BinarySearchController(1004, 10, "password", "Passwords/");
        BinarySearchView bsView = new BinarySearchView();
        bsController.binarySearch();
        if (bsController.getBinarySearch().isSearchFinished()) {
            bsView.printLine("Search finished.");
        }
        if (bsController.getBinarySearch().isPasswordFound()) {
            bsView.printLine("Password found. Times breached: " + bsController.getBinarySearch().getBreachCount());
        } else {
            bsView.printLine("Password is not in databse");
        }

    }
}
