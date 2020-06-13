package ca.attractors.chess;

public class Bishop extends ChessPiece {

    protected Bishop(Chessboard chessboard) {
        super(chessboard, PieceColor.White);
    }

    @Override
    protected boolean isInvalidMoveTo(Position targetPosition) {
        return false;
    }
}
