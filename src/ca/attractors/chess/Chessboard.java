package ca.attractors.chess;


public class Chessboard {
    private ChessPiece [][] pieces = new ChessPiece[8][8];

    public Chessboard() {
        Pawn pawn = new Pawn(this);
        pieces[0][1] = pawn;
    }

    public ChessPiece getPieceAt(Position position) {
        return pieces[position.getXOffset()] [position.getYOffset()];
    }

    public Position getPositionOf(ChessPiece pawn) {
        for (Position position: Position.values()) {
            ChessPiece piece = getPieceAt(position);
            if (piece == pawn) {    //Refactor - inline variable - remove braces?
                return position;
            }
        }
        throw new UnsupportedOperationException("This piece is not found on this chessboard");
    }
}
