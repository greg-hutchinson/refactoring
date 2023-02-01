package ca.attractors.chess;

import ca.attractors.chesscheckers.Board;
import ca.attractors.chesscheckers.Piece;
import ca.attractors.chesscheckers.Position;

public class Move {
    private final Piece piece;
    private final Position source;
    private final Position target;
    private final Board board;

    public Move(Piece piece, Position target) {
        this.piece = piece;
        this.source = piece.getPosition();
        this.target = target;
        this.board = piece.getBoard();
    }


    public boolean isLine() {
        return source.isLineTo(target);
    }
    public boolean isHorizontal() { return source.isHorizontalTo(target); }
    public boolean isVertical() {
        return source.isVerticalTo(target);
    }
    public boolean isDiagonal() {return source.isDiagonalTo(target); }


    public boolean isPathUnoccupied() {
        return !isPathBlocked();

    }
    public boolean isPathBlocked() {
        if (!isLine())
            throw new IllegalStateException("Can't invoke isBlocked if the move is not a line.");
        for (Position position :  source.getPathTo(target))
            if (board.getPieceAt(position) != null)
                return true;
        return false;
    }

    public boolean areSourceAndTargetSameColor() {
        Piece targetPiece = board.getPieceAt(target);
        if (targetPiece == null)
            return false;
        return piece.getColor() == targetPiece.getColor();
    }

    public boolean isTargetOccupied() {
        Piece targetPiece = board.getPieceAt(target);
        return  targetPiece != null;
    }

    public int getStepsBetween() {
        return source.getStepsTo(target);
    }
}
