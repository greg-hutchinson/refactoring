package ca.attractors.chess;

import java.util.ArrayList;
import java.util.List;

public class Rook extends ChessPiece {
    protected Rook(Chessboard chessboard, PieceColor color) {
        super(chessboard, color);
    }


    @Override
    protected boolean isInvalidMoveTo(Position targetPosition) {
        if (! isRooksMove(targetPosition))
            return true;
        if (isInvalidVerticalMove(targetPosition)) return true;
        if (isInvalidHorizontalMove(targetPosition)) return true;
        return false;
    }

    private boolean isRooksMove(Position targetPosition) {
        return isHorizontal(targetPosition) || isVertical(targetPosition);
    }

    private boolean isVertical(Position targetPosition) {
        return targetPosition.y == getPosition().y;
    }

    private boolean isHorizontal(Position targetPosition) {
        return targetPosition.x == getPosition().x;
    }

    private boolean isInvalidHorizontalMove(Position targetPosition) {
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
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isInvalidVerticalMove(Position targetPosition) {
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
                    return true;
                }
            }
        }
        return false;
    }

}
