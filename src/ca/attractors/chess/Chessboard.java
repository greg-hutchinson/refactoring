package ca.attractors.chess;


public class Chessboard {
    ChessPiece [][] pieces = new ChessPiece[8][8];

    public Chessboard() {
        Pawn pawn = new Pawn(this, 0,1);
        pieces[0][1] = pawn;
    }

    public ChessPiece getPieceAt(int x, int y) {
        return pieces[x] [y];
    }
}
