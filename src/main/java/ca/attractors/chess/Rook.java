package ca.attractors.chess;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
    protected Rook(Chessboard chessboard, PieceColor color) {
        super(chessboard, color);
    }

    /**
     *
     * @param targetPosition - the position that we would like to move to
     * @return true if we were able to complete the move. false otherwise
     */
    public boolean moveTo(Position targetPosition) {
        //if it is not the same x or y coordinate it is not a rooks valid move at all
        if (targetPosition.x != getPosition().x && targetPosition.y != getPosition().y) {
            return false;
        }
        //Next - Check to make sure that if the target square is occupied it is not the same color
        ChessPiece targetPiece = getChessboard().getPieceAt(targetPosition);
        if (targetPiece != null) {
            if (targetPiece.getColor() == getColor())
                return false;
        }
        //Next - Get all the cells between the source and the target and ensure that they are empty.
        // if this is a horizontal move we need to increment the y coordinate until it is the same as the target's y
        // the increment might be positive or negative.
        if (targetPosition.x == getPosition().x) {
            int start = getPosition().getYOffset();
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
        //Next - Get all the cells between the source and the target and ensure that they are empty.
        // if this is a vertical move we need to increment the x coordinate until it is the same as the target's x
        // the increment might be positive or negative.
        if (targetPosition.y == getPosition().y) {
            int start = getPosition().getXOffset();
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
        //If we get here - is is a valid move. Physically move the piece and answer true.
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


//FIXME, This method works but seems to violate lots of rules.
//FIXME, GH, Clean up the duplication. isPathBlockedFor
//FIXME, GH, Clean up the duplication. getPathTo
//FIXME, GH, Extract cantMove
//FIXME, GH, Extract isOccupiedBySameColor and move to top of can't move
//FIXME, GH, Pull up moveTo
//FIXME, GH, Refactor cantMove into 2
//FIXME, GH, Pull up cantMove , isOccupied..
//FIXME, GH, getPathTo
//FIXME, GH, isPathBlocked to Chessboard
//FIXME, getPathTo to Positions
