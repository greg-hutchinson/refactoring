package ca.attractors.chess;

public class Rook extends ChessPiece {
    Chessboard chessboard;

    protected Rook(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public Position getPosition() {
        return chessboard.getPositionOf(this);
    }

}
