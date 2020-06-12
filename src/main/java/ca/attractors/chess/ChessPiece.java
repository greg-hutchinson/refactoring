package ca.attractors.chess;

public class ChessPiece {
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
}
