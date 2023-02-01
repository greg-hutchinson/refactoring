package ca.attractors.chess;

import ca.attractors.chesscheckers.Board;
import ca.attractors.chesscheckers.Piece;
import ca.attractors.chesscheckers.PieceColor;
import ca.attractors.chesscheckers.Position;

public abstract  class ChessPiece implements Piece {
    private final Board board;
    private final PieceColor color;

    public ChessPiece(PieceColor color, Board aBoard, Position position) {
        this.color = color;
        this.board = aBoard;
        aBoard.putPieceAt(this, position);
    }

    public Board getBoard() {
        return board;
    }

    public PieceColor getColor() {
        return color;
    }

    public boolean moveTo(Position targetPosition) {
        Runnable runnable = () -> {
 //           throw new IllegalStateException("Not a valid move");
        };
        moveTo(targetPosition, runnable);
        return true;
    }
    public void moveTo(Position targetPosition, Runnable runnable) {
        if (isValidMove(targetPosition)) {
            getBoard().movePieceTo(this, targetPosition);
        }
        runnable.run();
    }

    public boolean isValidMove(Position targetPosition) {
        return isValidMove(new Move(this, targetPosition));
    }

    protected abstract boolean isValidMove(Move move);

    @Override
    public String toString() {
        return getColor().toSimpleString() + getAbbreviation();
    }

    protected abstract String getAbbreviation();
}