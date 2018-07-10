package model;

public class BinarySearch {
    private int INIT_FILE_NUMBER;
    private int currentFileNumber;
    private int previousFileNumber;
    private String password;
    private boolean possibleRangeFound;
    private boolean passwordFound;

    public BinarySearch(int initialFileNumber, String password) {
        this.INIT_FILE_NUMBER = initialFileNumber;
        this.currentFileNumber = INIT_FILE_NUMBER;
        this.password = password;
        this.possibleRangeFound = false;
        this.passwordFound = false;
    }
}
