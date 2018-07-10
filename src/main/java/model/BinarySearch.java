package model;

import java.io.BufferedReader;
import java.io.FileReader;

public class BinarySearch {
    private int INIT_FILE_NUMBER;
    private int currentFileNumber;
    private int previousFileNumber;
    private String password;
    private String filePath;
    private boolean possibleRangeFound;
    private boolean passwordFound;

    public BinarySearch(int initialFileNumber, String password, String filePath) {
        this.INIT_FILE_NUMBER = initialFileNumber;
        this.currentFileNumber = INIT_FILE_NUMBER;
        this.password = password;
        this.filePath = filePath;
        this.possibleRangeFound = false;
        this.passwordFound = false;
    }

}
