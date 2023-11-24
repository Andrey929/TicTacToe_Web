package Sourse;

public enum Figure {
    EMPTY(' '),
    CROSS('X'),
    NOUGHT('0');

    private final char figure;

    Figure(char sign) {
        this.figure = sign;
    }

    public char getFigure() {
        return figure;
    }
}
