package ca.attractors.chess;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
    protected Rook(Chessboard chessboard, PieceColor color) {
        super(chessboard, color);
    }

    //FIXME, This method works but seems to violate lots of rules.
    //Fixme, GH, Clean up the duplication. isPathBlockedFor
    //Fixme, GH, Clean up the duplication. getPathTo
    //Fixme, GH, Extract cantMove
    //Fixme, GH, Extract isOccupiedBySameColor and move to top of can't move

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


/*
    private List<Position> getPathTo(Position source, Position target) {
        List<Position> path = new ArrayList<>();
        int startX = source.getXOffset();
        int endX = target.getXOffset();
        int startY = source.getYOffset();
        int endY = target.getYOffset();
        int incrementX = Integer.signum(endX - startX);
        int incrementY = Integer.signum(endY - startY);
        int y = startY + incrementY;
        for (int x = startX + incrementX; x != endX || y != endY; x = x + incrementX, y = y + incrementY)
            path.add(Position.getPositionFor(x, y));
        return path;
    }

*/