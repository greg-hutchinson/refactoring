package ca.attractors.chess;

import ca.attractors.chesscheckers.Board;
import ca.attractors.chesscheckers.PieceColor;
import ca.attractors.chesscheckers.Position;

public class Pawn extends ChessPiece {
    protected Pawn(PieceColor color, Board chessboard, Position position)
    {
        super(color, chessboard, position);
    }


    @Override
    protected boolean isValidMove(Move move) {
        if (move.areSourceAndTargetSameColor())
            return false;
        return true;
    }

    @Override
    protected String getAbbreviation() {
        return "P";
    }
}
