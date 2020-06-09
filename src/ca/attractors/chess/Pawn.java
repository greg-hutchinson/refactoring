package ca.attractors.chess;

public class Pawn extends ChessPiece {
    Chessboard chessboard;

    protected Pawn(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public Position getPosition() {
        return chessboard.getPositionOf(this);
    }

}
