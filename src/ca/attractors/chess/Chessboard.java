package ca.attractors.chess;

public class Chessboard {
    ChessPiece [][] pieces = new ChessPiece[8][8];

    public Chessboard() {
        Rook rook = new Rook(this);
        pieces[0][0] = rook;
        Pawn pawn = new Pawn(this);
        pieces[0][1] = pawn;
    }

    public void move (ChessPiece piece, char x,int y) {
        int xOffset = x - 'a';
        int existingX = getPieceX(piece);
        int existingY = getPieceY(piece);
        pieces[xOffset][y] = piece;
        pieces[existingX][existingY] = null;
    }

    private int getPieceX(ChessPiece piece) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                ChessPiece existingPiece = pieces[x][y];
                if (existingPiece != null) {
                    if (existingPiece == piece) {
                        return x;
                    }
                }
            }
        }
        throw new UnsupportedOperationException("This piece does not exist on this board");
    }

    private int getPieceY(ChessPiece piece) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                ChessPiece existingPiece = pieces[x][y];
                if (existingPiece != null) {
                    if (existingPiece == piece) {
                        return y;
                    }
                }
            }
        }
        throw new UnsupportedOperationException("This piece does not exist on this board");
    }

    public ChessPiece getPieceAt(char x, int y) {
        int xOffset = x - 'a';
        return pieces[xOffset] [y];
    }
}
