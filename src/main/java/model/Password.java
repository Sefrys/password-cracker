package model;

public class Password {

    private String password;
    private int length;
    private char[] array;
//    private int level;

    public Password(String password) {
        this.password = password;
        this.length = password.length();
        this.array = password.toCharArray();
//        this.level = 0;
    }

    public String getPassword() {
        return password;
    }

    public int getLength() {
        return length;
    }

    public char[] getArray() {
        return array;
    }

//    public int getLevel() {
//        return level;
//    }
}