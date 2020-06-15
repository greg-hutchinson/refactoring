package ca.attractors.chess;

public class Chessboard {
    private ChessPiece[][] pieces = new ChessPiece[8][8];

    public Chessboard() {
    }

    public ChessPiece getPieceAt(Position position) {
        return pieces[position.getXOffset()] [position.getYOffset()];
    }

    void putPieceAt(ChessPiece chessPiece, Position position) {
        pieces[position.getXOffset()][position.getYOffset()] = chessPiece;
    }

    void movePieceTo(ChessPiece chessPiece, Position position) {
        Position old = getPositionOf(chessPiece);
        putPieceAt(chessPiece, position);
        putPieceAt(null, old);
    }


    //FIXME, GH, Two code smells in this method and a simplification
    public Position getPositionOf(ChessPiece pawn) {
        for (Position position: Position.values()) {
            ChessPiece piece = getPieceAt(position);
            if (piece == pawn) {
                return position;
            }
        }
        return null;
    }
}




//Answers below



// Variable named pawn
// Simplify - inline the call to getPiece
// Don't return null -          throw new UnsupportedOperationException("This piece is not found on this chessboard");