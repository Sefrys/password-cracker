import controller.BinarySearchController;
import model.BruteForcer;
import model.Comparator;
import model.Password;
import view.BinarySearchView;

import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {

        try {
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
        }catch (Throwable e ){
            //e.printStackTrace();
        }

        String passwd = "0AA";
        new Comparator(passwd);
        (new Thread(new BruteForcer(new Password(passwd), (char) 48 ))).start();

    }
}
