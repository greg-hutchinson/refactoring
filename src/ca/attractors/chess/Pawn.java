package ca.attractors.chess;

public class Pawn extends ChessPiece {
    Chessboard chessboard;
    int x;
    int y;

    protected Pawn(Chessboard chessboard, int x, int y) {
        this.chessboard = chessboard;
        this.x = x;
        this.y = y;
        chessboard.pieces[x][y] = this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
