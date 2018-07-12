package utils;

public enum AsciiValues {
    LOWER_DIGIT_BOUND(48),
    UPPER_DIGIT_BOUND(58),

    LOWER_CAPITAL_LETTER_BOUND(65),
    UPPER_CAPITAL_LETTER_BOUND(91),

    LOWER_LOWERCASE_LETTER_BOUND(97),
    UPPER_LOWERCASE_LETTER_BOUND(123);

    private int value;

    AsciiValues(int value) {
        this.value = value;
    }

    public char getValue() {
        return (char)value;
    }
}
