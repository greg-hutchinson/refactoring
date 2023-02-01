package ca.attractors.chess;


import ca.attractors.chesscheckers.Board;
import ca.attractors.chesscheckers.PieceColor;
import ca.attractors.chesscheckers.Position;

public class Bishop extends ChessPiece {

    protected Bishop(PieceColor color, Board chessboard, Position position)
    {
        super(color, chessboard, position );
    }

    @Override
    protected boolean isValidMove(Move move) {
        if (move.areSourceAndTargetSameColor())
                return false;
        if (!(move.isDiagonal()))
            return false;
        return move.isPathUnoccupied();
    }

    @Override
    protected String getAbbreviation() {
        return "B";
    }
}
