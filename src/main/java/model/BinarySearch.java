package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearch {
    private int INIT_FILE_NUMBER;
    private int currentFileNumber;
    private int previousFileNumber;
    private int searchRange;
    private String password;
    private String filePath;
    private boolean possibleRangeFound;
    private boolean passwordFound;

    public BinarySearch(int initialFileNumber, String password, String filePath, int searchRange) {
        this.INIT_FILE_NUMBER = initialFileNumber;
        this.currentFileNumber = INIT_FILE_NUMBER;
        this.searchRange = searchRange;
        this.password = password;
        this.filePath = filePath;
        this.possibleRangeFound = false;
        this.passwordFound = false;
    }

    private void findPossibleFileRange() {
        String lookedUpHash = readFirstLine(currentFileNumber);

        if (isPossibleRange()) {
            possibleRangeFound = true;
        }

    }


    private boolean isPossibleRange() {
        if (Math.abs(previousFileNumber - currentFileNumber) < searchRange) {
            possibleRangeFound = true;
            return true;
        }
        return false;
    }

    private String readFirstLine(int fileNumber) {
        String line = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath + "Passwords_" + fileNumber + ".txt"));
            line = br.readLine();

            if (line == null) {
                throw new NullPointerException("First line in file nr: " + fileNumber + " is empty");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseLineGetHex(line);
    }

    private String parseLineGetHex(String line) {
        return line.substring(0, line.indexOf(':'));
    }

}