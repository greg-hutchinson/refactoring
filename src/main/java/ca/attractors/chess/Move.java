package ca.attractors.chess;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private Position source;
    private Position target;
    private Chessboard chessboard;
    private int startX;
    private int endX;
    private int incrementX;
    private int startY;
    private int endY;
    private int incrementY;
    private List<Position> path = new ArrayList<>();

    public Move(Position source, Position target, Chessboard chessboard) {
        this.source = source;
        this.target = target;
        this.chessboard = chessboard;
        initialize();
    }

    private void initialize() {
        if (!isLine())
            return;
        initializeIfHorizontal();
        initializeIfVertical();
        initializeIfDiagonal();
        initializePath();
    }

    public boolean isLine() {
        return isDiagonal() || isHorizontal() || isVertical();
    }

    private void initializePath() {
        int y = startY + incrementY;
        for (int x = startX + incrementX; x != endX || y != endY; x = x + incrementX, y = y + incrementY)
            path.add(Position.getPositionFor(x, y));
    }

    private void initializeIfDiagonal() {
        if (isDiagonal()) {
            startX = source.getXOffset();
            endX = target.getXOffset();
            if (startX > endX)
                incrementX = -1;
            else
                incrementX = 1;
            startY = source.getYOffset();
            endY = target.getYOffset();
            if (startY > endY)
                incrementY = -1;
            else
                incrementY = 1;
        }
    }

    private void initializeIfVertical() {
        if (isVertical()) {
            startY = source.getYOffset();
            endY = target.getYOffset();
            if (startY > endY)
                incrementY = -1;
            else
                incrementY = 1;
            startX = endX = source.getXOffset();
        }
    }

    private void initializeIfHorizontal() {
        if (isHorizontal()) {
            startX = source.getXOffset();
            endX = target.getXOffset();
            if (startX > endX)
                incrementX = -1;
            else
                incrementX = 1;
            startY = endY = source.getYOffset();
        }
    }

    public boolean isHorizontal() {
        return target.y == source.y;
    }

    public boolean isVertical() {
        return target.x == source.x;
    }

    public boolean isDiagonal() {
        int diffx = Math.abs(source.getXOffset() - target.getXOffset());
        int diffy = Math.abs(source.getYOffset() - target.getYOffset());
        return diffx == diffy;
    }

    public boolean isPathUnoccupied() {
        return !isPathBlocked();

    }
    public boolean isPathBlocked() {
        if (!isLine())
            throw new IllegalStateException("Can't invoke isBlocked if the move is not a line.");
        for (Position position : path) {
            if (chessboard.getPieceAt(position) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean isOccupiedBySameColor() {
        ChessPiece targetPiece = chessboard.getPieceAt(target);
        if (targetPiece == null)
            return false;
        ChessPiece sourcePiece = chessboard.getPieceAt(source);
        return sourcePiece.getColor() == targetPiece.getColor();
    }

}
