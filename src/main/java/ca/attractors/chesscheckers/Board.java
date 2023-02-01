package ca.attractors.chesscheckers;


public class Board {
    private final Piece[][] pieces = new Piece[8][8];

    public Board() {
    }

    public Piece getPieceAt(Position position) {
        return pieces[position.getXOffset()] [position.getYOffset()];
    }

    public void putPieceAt(Piece piece, Position position) {
        pieces[position.getXOffset()][position.getYOffset()] = piece;
    }

    public void movePieceTo(Piece piece, Position position) {
        putPieceAt(null, piece.getPosition());
        putPieceAt(piece, position);
    }

    public Position getPositionOf(Piece piece1) {
        for (Position position: Position.values()) {
            Piece piece = getPieceAt(position);
            if (piece == piece1) {    //Refactor - inline variable - remove braces?
                return position;
            }
        }
        throw new UnsupportedOperationException("This piece is not found on this chessboard");
    }

    public String toString() {
        return new ToStringBuilder().build();
    }
    private class ToStringBuilder {
        final String FRAME =  "+----+----+----+----+----+----+----+----+\n";
        private final StringBuilder builder = new StringBuilder(FRAME);
        public String build() {
            for (int y = 7; y >= 0; y--) {
                doPositionsForRow(y);
                builder.append("|\n" + FRAME);
            }
            return builder.toString();
        }
        private void doPositionsForRow(int y) {
            for (int x = 0; x <= 7; x++)
                addCellToBuilder(y, x);
        }
        private void addCellToBuilder(int y, int x) {
            Position position = Position.getPositionFor(x, y);
            builder.append("|");
            appendPiece(getPieceAt(position));
        }
        private void appendPiece(Piece piece) {
            if (piece == null)
                builder.append( "    ");
            else
                builder.append(" " + piece + " ");
        }
    }
}
