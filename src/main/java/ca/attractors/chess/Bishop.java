package ca.attractors.chess;

public class Bishop extends ChessPiece {
    Chessboard chessboard;

    protected Bishop(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public Position getPosition() {
        return chessboard.getPositionOf(this);
    }

}
