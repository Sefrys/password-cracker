package model;

import service.PasswordService;
import utils.Complexity;

public class Password {

    private String password;
    private int length;
    private char[] array;
    private Complexity complexity;

    public Password(String password) {
        this.password = password;
        this.length = password.length();
        this.array = password.toCharArray();
        preparePasswordComplexity();
    }

    private void preparePasswordComplexity() {
        PasswordService.validate(password);
        this.complexity = PasswordService.getComplexity();
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

    public Complexity getComplexity() {
        return complexity;
    }
}