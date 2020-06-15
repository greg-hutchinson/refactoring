package ca.attractors.chess;

public class Bishop extends ChessPiece {

    protected Bishop(Chessboard chessboard) {
        super(chessboard, PieceColor.White);
    }

    public boolean moveTo(Position b1) {
        return false;
    }
}
