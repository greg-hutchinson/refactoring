package ca.attractors.chess;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
    protected Rook(Chessboard chessboard, PieceColor color) {
        super(chessboard, color);
    }

    @Override
    protected boolean isInvalidMove(Move move) {
        if (!(move.isVertical() || move.isHorizontal()))
            return true;
        return move.isPathBlocked();
    }
}
