package ca.attractors.chess;

public class ChessPiece {
    private Chessboard chessboard;
    private PieceColor color;
    public ChessPiece(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public Chessboard getChessboard() {
        return chessboard;
    }

    public Position getPosition() {
        return chessboard.getPositionOf(this);
    }
    public PieceColor getColor() {
        return PieceColor.Black;
    }
}
