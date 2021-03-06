package controller;


import model.BinarySearch;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BinarySearchController {

    private int fileCount;
    private int searchRange;
    private String password;
    private String filePath;
    private BinarySearch binarySearch;

    public BinarySearchController(int fileCount, int searchRange, String password, String filePath) {
        this.fileCount = fileCount;
        this.searchRange = searchRange;
        this.password = passwordHash(password);
        this.filePath = filePath;
    }

    public void binarySearch() {
        this.binarySearch = new BinarySearch(fileCount, password, filePath, searchRange);
        Runnable runnable = binarySearch;
        Thread thread = new Thread(runnable);
        thread.run();

    }
    private static String passwordHash(String input)  {
        MessageDigest mDigest = null;
        try {
            mDigest = MessageDigest.getInstance("sha-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] result  = mDigest.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte element : result) {
            sb.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString().toUpperCase();
    }

    public BinarySearch getBinarySearch() {
        return binarySearch;
    }
}
