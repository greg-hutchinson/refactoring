package ca.attractors.checkers;

import ca.attractors.chess.Move;
import ca.attractors.chesscheckers.Board;
import ca.attractors.chesscheckers.Piece;
import ca.attractors.chesscheckers.PieceColor;
import ca.attractors.chesscheckers.Position;

// FIXME, Lots more needed, concept of Man vs King.
// FIXME, Man can only go forward, King Backward.
// But I think the Board and Piece are now generic

public class CheckerPiece implements Piece {
    private Board board;
    private PieceColor color;
    public CheckerPiece(PieceColor color, Board aBoard, Position position) {
        this.color = color;
        this.board = aBoard;
        aBoard.putPieceAt(this, position);
    }
    @Override
    public PieceColor getColor() {
        return color;
    }

    @Override
    public Board getBoard() {
        return board;
    }


    public boolean moveTo(Position targetPosition) {
        Move move = new Move(this, targetPosition);
        if (!canMoveTo(move))
            return false;
        getBoard().movePieceTo(this, targetPosition);
        return true;
    }

    public boolean canMoveTo(Position targetPosition) {
        return canMoveTo(new Move(this, targetPosition));
    }

    private boolean canMoveTo(Move move) {
        return isValidMove(move);
    }

    private boolean isValidMove(Move move) {
        if (move.isTargetOccupied())
            return false;
        if (!move.isDiagonal())
            return false;
        if (move.getStepsBetween() == 2)  //up 1 over 1
            return true;
        if (move.getStepsBetween() != 4)  //up 2 over 2
            return false;
        return move.isPathBlocked();
    }

}
