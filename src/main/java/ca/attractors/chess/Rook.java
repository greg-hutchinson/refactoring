package ca.attractors.chess;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
    protected Rook(Chessboard chessboard, PieceColor color) {
        super(chessboard, color);
    }

    public boolean moveTo(Position targetPosition) {
        Position currentPosition = getPosition();
        //same row or same column?
        if (targetPosition.x != currentPosition.x && targetPosition.y != currentPosition.y) {
            return false;
        }
        ChessPiece targetPiece = getChessboard().getPieceAt(targetPosition);
        if (targetPiece != null) {
            if (targetPiece.getColor() == getColor())
                return false;
        }
        if (targetPosition.x == currentPosition.x) {
            int start = currentPosition.getYOffset();
            int end = targetPosition.getYOffset();
            int increment = 0;
            if (start > end)
                increment = -1;
            else
                increment = 1;
            List<Position> positions = new ArrayList<>();
            for (int y = start+increment; y != end; y = y + increment) {
                positions.add(Position.getPositionFor(targetPosition.getXOffset(), y));
            }
            for (Position position: positions) {
                if (getChessboard().getPieceAt(position) != null) {
                    return false;
                }
            }
        }
        if (targetPosition.y == currentPosition.y) {
            int start = currentPosition.getXOffset();
            int end = targetPosition.getXOffset();
            int increment = 0;
            if (start > end)
                increment = -1;
            else
                increment = 1;
            List<Position> positions = new ArrayList<>();
            for (int x = start+increment; x != end; x = x + increment) {
                positions.add(Position.getPositionFor(x, targetPosition.getYOffset()));
            }
            for (Position position: positions) {
                if (getChessboard().getPieceAt(position) != null) {
                    return false;
                }
            }
        }
        getChessboard().movePieceTo(this, targetPosition);
        return true;
    }

}
