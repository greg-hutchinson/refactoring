package ca.attractors.chess;

public enum Position {
    A1(0,0), A2(0,1);
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
