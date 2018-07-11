package utils;

public enum Complexity {

    EASY(10),
    MEDIUM(36),
    HARD(62);

    private int size;

    Complexity(int possibilities) {
        this.size = possibilities;
    }

    public int getComplexity() {
       return size;
    }
}
