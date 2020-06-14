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
        if (cantMoveTo(targetPosition))
            return false;
        getChessboard().movePieceTo(this, targetPosition);
        return true;
    }

    private boolean cantMoveTo(Position targetPosition) {
        if (isOccupiedBySameColorPiece(targetPosition))
            return true;
        if (isInvalidMoveTo(targetPosition))
            return true;
        return false;
    }

    protected abstract boolean isInvalidMoveTo(Position targetPosition);

    private boolean isOccupiedBySameColorPiece(Position targetPosition) {
        ChessPiece targetPiece = getChessboard().getPieceAt(targetPosition);
        if (targetPiece != null) {
            if (targetPiece.getColor() == getColor())
                return true;
        }
        return false;
    }
}