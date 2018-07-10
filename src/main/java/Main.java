import model.BinarySearch;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        int fileCount = 1004;
        String password = sha1("1qazxsw2");
        String filePath = "Passwords/";
        int searchRange = 10;
        BinarySearch bs = new BinarySearch(fileCount, password, filePath, searchRange);
        bs.binarySearch();
    }

    public static String sha1(String input) {
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
}
