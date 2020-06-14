package ca.attractors.chess;

public class Pawn extends ChessPiece {
    protected Pawn(Chessboard chessboard, PieceColor white) {
        super(chessboard, PieceColor.White);
    }


    @Override
    protected boolean isInvalidMove(Move move) {

        return false;
    }
}
