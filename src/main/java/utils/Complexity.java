package main.java.utils;

public enum Complexity {

    ERROR(-1),
    EASY(10),
    MEDIUM(26),
    ADVANCED(36),
    HARD(62)
    ;

    private int size;

    Complexity(int possibilities) {
        this.size = possibilities;
    }

    public int getComplexity() {
       return size;
    }


}
