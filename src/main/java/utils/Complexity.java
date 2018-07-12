package utils;

public enum Complexity {

    ERROR(-1),
    NUMS(10),
    LETTERS(36),
    NUMS_AND_LETTERS(62);

    private int size;

    Complexity(int possibilities) {
        this.size = possibilities;
    }

    public int getComplexity() {
       return size;
    }
}
