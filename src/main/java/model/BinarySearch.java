package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class BinarySearch {
    private int INIT_FILE_NUMBER;
    private int currentFileNumber;
    private int previousFileNumber;
    private int searchRange;
    private String breachCount;
    private String password;
    private String filePath;
    private boolean possibleRangeFound;
    private boolean passwordFound;

    public BinarySearch(int fileCount, String password, String filePath, int searchRange) {
        this.INIT_FILE_NUMBER = fileCount / 2;
        this.currentFileNumber = INIT_FILE_NUMBER;
        this.searchRange = searchRange;
        this.password = password;
        this.filePath = filePath;
        this.possibleRangeFound = false;
        this.passwordFound = false;
    }

    public void binarySearch() {
        while (!possibleRangeFound) {
            findPossibleFileRange();
        }

        while (!passwordFound) {
            readFile();
        }
    }

    private void findPossibleFileRange() {
        String lookedUpHash = readFirstLine(currentFileNumber);

        if (isPossibleRangeFound()) {
            possibleRangeFound = true;
        } else if (compareHexValues(lookedUpHash) == 0) {
            this.passwordFound = true;
        } else if (compareHexValues(lookedUpHash) == 1) {
            setLowerFileNumber();
            findPossibleFileRange();
        } else if (compareHexValues(lookedUpHash) == -1) {
            setHigherFileNumber();
            findPossibleFileRange();
        }
    }

    private int compareHexValues(String hash) {
        return hexToDecimal(hash).compareTo(hexToDecimal(password));
    }


    private BigInteger hexToDecimal(String hash) {
        return new BigInteger(hash, 16);
    }

    private void setHigherFileNumber() {
        this.previousFileNumber = currentFileNumber;
        double temp = currentFileNumber * 1.5;

        if (temp > 1004) {
            temp = 1004;
        }

        this.currentFileNumber = (int) temp;
    }

    private void setLowerFileNumber() {
        int temp = Math.abs(previousFileNumber - currentFileNumber) / 2;
        this.currentFileNumber = currentFileNumber - temp;
    }



    private boolean isPossibleRangeFound() {
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

    private void readFile() {
        int lowerBound = currentFileNumber - searchRange;
        int upperBound = currentFileNumber + searchRange;

        for (int i = lowerBound; i <= upperBound; i++) {
            System.out.println("Looking in file nr: " + i);
            if (readLines(i)) {
                System.out.println("Password found. Breached times: " + breachCount);
                break;
            }
        }
    }

    private boolean readLines(int fileNumber) {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath + "Passwords_" + fileNumber + ".txt"));
            while ((line = br.readLine()) != null) {
                if (compareHexValues(parseLineGetHex(line)) == 0) {
                    this.breachCount = parseLineGetBreachCount(line);
                    this.passwordFound = true;
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private int validateFileNumberBound(int fileNumberBound) {
        if (fileNumberBound < 1) return 1;
        if (fileNumberBound > 1004) return 1004;
        return fileNumberBound;
    }

    private String parseLineGetHex(String line) {
        return line.substring(0, line.indexOf(':'));
    }

    private String parseLineGetBreachCount(String line) {
        return line.substring(line.indexOf(':') + 1);
    }

}
