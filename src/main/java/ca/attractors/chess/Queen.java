package ca.attractors.chess;


import ca.attractors.chesscheckers.Board;
import ca.attractors.chesscheckers.PieceColor;
import ca.attractors.chesscheckers.Position;

public class Queen extends ChessPiece {

    protected Queen(PieceColor color, Board chessboard, Position position)
    {
        super(color, chessboard, position);
    }

    @Override
    protected boolean isValidMove(Move move) {
        if (move.areSourceAndTargetSameColor())
            return false;

        return isQueensMove(move);
    }

    private boolean isQueensMove(Move move) {
            return false;
    }

    @Override
    protected String getAbbreviation() {
        return "Q";
    }
}
