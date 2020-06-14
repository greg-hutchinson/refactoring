package ca.attractors.chess;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends ChessPiece {

    protected Bishop(Chessboard chessboard, PieceColor color) {
        super(chessboard, color);
    }

    @Override
    protected boolean isInvalidMoveTo(Position targetPosition) {
        int diffx = Math.abs(getPosition().getXOffset() - targetPosition.getXOffset());
        int diffy = Math.abs(getPosition().getYOffset() - targetPosition.getYOffset());
        if (diffx != diffy)
            return true;
        int startX = getPosition().getXOffset();
        int endX = targetPosition.getXOffset();
        int incrementX = 0;
        if (startX > endX)
            incrementX = -1;
        else
            incrementX = 1;
        int startY = getPosition().getYOffset();
        int endY = targetPosition.getYOffset();
        int incrementY = 0;
        if (startY > endY)
            incrementY = -1;
        else
            incrementY = 1;
        List<Position> positions = new ArrayList<>();
        int y = startY + incrementY;
        for (int x = startX + incrementX; x != endX; x = x + incrementX, y = y + incrementY) {
            positions.add(Position.getPositionFor(x, y));
        }
        for (Position position : positions) {
            if (getChessboard().getPieceAt(position) != null) {
                return true;
            }
        }
        return false;
    }
}
