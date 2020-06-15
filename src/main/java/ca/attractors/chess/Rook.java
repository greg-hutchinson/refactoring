package ca.attractors.chess;

public class Rook extends ChessPiece {
    //FIXME, GH, duplicate code - pull up
    Chessboard chessboard;

    protected Rook(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public Position getPosition() {
        return chessboard.getPositionOf(this);
    }

    public boolean moveTo(Position position) {
        return false;
    }

}
