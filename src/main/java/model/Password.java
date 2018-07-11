package model;

import service.PasswordService;

public class Password {

    private String password;
    private int length;
    private char[] array;
    private Enum complexity;

    public Password(String password) {
        this.password = password;
        this.length = password.length();
        this.array = password.toCharArray();
        this.complexity = PasswordService.validate(password);
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

    public Enum getComplexity() {
        return complexity;
    }
}