package ca.attractors.chess;

public abstract  class ChessPiece {
    private Chessboard chessboard;
    private PieceColor color;

    public ChessPiece(Chessboard chessboard, PieceColor color) {
        this.chessboard = chessboard;
        this.color = color;
    }

    public Chessboard getChessboard() {
        return chessboard;
    }

    public Position getPosition() {
        return chessboard.getPositionOf(this);
    }

    public PieceColor getColor() {
        return color;
    }

    public boolean moveTo(Position targetPosition) {
        if (isInvalidMoveTo(targetPosition))
            return false;
        getChessboard().movePieceTo(this, targetPosition);
        return true;
    }

    protected abstract boolean isInvalidMoveTo(Position targetPosition);
}
