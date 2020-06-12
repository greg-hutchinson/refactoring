package ca.attractors.chess;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
    protected Rook(Chessboard chessboard) {
        super(chessboard);
    }
    public boolean moveTo(Position position) {
        Position currentPosition = getPosition();
        //same row or same column?
        if (position.x != currentPosition.x && position.y != currentPosition.y) {
            return false;
        }
        ChessPiece targetPiece = getChessboard().getPieceAt(position);
        if (targetPiece != null) {
            if (targetPiece.)
        }
        if (position.x == currentPosition.x) {
            int start = position.getXOffset();
            int end = current.getXOffset();
            int increment = 1;
            if (start > end)
                increment = -1;
            List<Position> positions = new ArrayList<>();
            for (int x = start; x != end; x = x + increment) {
                if (x != start && x != end)
                    positions.add(Position.getPositionFor(x, position.getYOffset()));
            }
            for (Position position: Position.values()) {
                if (getChessboard().getPieceAt(position) != null) {
                    return false;
                }
            }

        }

        return true;
    }

}
