import controller.BinarySearchController;
import controller.MainController;
import model.BruteForcer;
import model.Comparator;
import model.Password;
import view.BinarySearchView;

import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        final int passwordAPIFileCount = 1004;
        final int fileSearchRange = 10;
        final String passwordAPIFilePath = "Passwords/";


        BinarySearchController bsC = new BinarySearchController(passwordAPIFileCount, fileSearchRange, passwordAPIFilePath);

        MainController mainController = new MainController(bsC);
        mainController.runApp();
    }
}
