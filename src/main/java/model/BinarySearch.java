package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

    private void findePossibleFileRange() {

    }

    private String readFirstLine(int fileNumber) {
        String line = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath + "Passwords_" + fileNumber + ".txt"));
            line = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseLineGetHex(line);
    }

    private String parseLineGetHex(String line) {
        return line.substring(0, line.indexOf(':'));
    }

    
}
