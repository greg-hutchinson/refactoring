package ca.attractors.chess;

public class Pawn extends ChessPiece {
    Chessboard chessboard;
    int x;
    int y;

    public Pawn(Chessboard chessboard, int x, int y) {
        this.chessboard = chessboard;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
