package ca.attractors.chess;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private Position source;
    private Position target;
    private Chessboard chessboard;
    private List<Position> path = new ArrayList<>();

    public Move(Position source, Position target, Chessboard chessboard) {
        this.source = source;
        this.target = target;
        this.chessboard = chessboard;
    }


    public boolean isLine() {
        return isDiagonal() || isHorizontal() || isVertical();
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
        path = source.getPathTo(target);
        for (Position position : path)
            if (chessboard.getPieceAt(position) != null)
                return true;
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
