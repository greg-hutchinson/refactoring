package ca.attractors.chess;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends ChessPiece {

    protected Bishop(Chessboard chessboard, PieceColor color) {
        super(chessboard, color);
    }

    @Override
    protected boolean isValidMove(Move move) {
        if (!(move.isDiagonal()))
            return false;
        return move.isPathUnoccupied();
    }
}
