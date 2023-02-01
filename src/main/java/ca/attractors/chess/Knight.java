package ca.attractors.chess;


import ca.attractors.chesscheckers.Board;
import ca.attractors.chesscheckers.PieceColor;
import ca.attractors.chesscheckers.Position;

public class Knight extends ChessPiece {

    protected Knight(PieceColor color, Board chessboard, Position position) {
        super(color, chessboard, position);
    }

    @Override
    protected boolean isValidMove(Move move) {
        if (move.areSourceAndTargetSameColor())
            return false;

        return isKnightsMove(move);
    }


    public boolean isKnightsMove (Move move) {
        if (move.isLine())
            return false;
        return move.getStepsBetween() == 3;
    }

    @Override
    protected String getAbbreviation() {
        return "N";
    }
}
