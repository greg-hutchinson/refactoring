package ca.attractors.chess;


import ca.attractors.chesscheckers.Board;
import ca.attractors.chesscheckers.PieceColor;
import ca.attractors.chesscheckers.Position;

public class King extends ChessPiece {

    protected King(PieceColor color, Board chessboard, Position position) {
        super(color, chessboard, position);
    }

    @Override
    protected boolean isValidMove(Move move) {
        if (move.areSourceAndTargetSameColor())
            return false;
        return isKingsMove(move);
    }

    private boolean isKingsMove(Move move) {
        return false;
    }

    @Override
    protected String getAbbreviation() {
        return "K";
    }
}
