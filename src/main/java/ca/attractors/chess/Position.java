package ca.attractors.chess;

public enum Position {
    A1('a',1), A2('a', 2);
    char x;
    int y;

    Position(char x, int y) {
        this.x = x;
        this.y = y;
    }

    int getXOffset() {
        return x - 'a';
    }
    int getYOffset() {
        return y - 1;
    }
}
