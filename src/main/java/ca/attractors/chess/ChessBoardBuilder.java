package ca.attractors.chess;

import ca.attractors.chesscheckers.Board;
import ca.attractors.chesscheckers.PieceColor;
import ca.attractors.chesscheckers.Position;

import java.util.List;

import static ca.attractors.chesscheckers.PieceColor.Black;
import static ca.attractors.chesscheckers.PieceColor.White;
import static ca.attractors.chesscheckers.Position.*;

public class ChessBoardBuilder {
    private final Board board;
    public ChessBoardBuilder() {
        board = new Board();
    }

    public Board build() {
        initializeWhite();
        initializeBlack();
        return board;
    }

    private void initializeWhite()
    {
        new Rook(White, board, A1);
        new Knight(White, board, B1);
        new Bishop(White, board, C1);

        new Queen(White, board, D1);
        new King(White, board, E1);

        new Bishop(White, board, F1);
        new Knight(White, board, G1);
        new Rook(White, board, H1);

        initializePawns(White, 1);
    }

    private void initializeBlack()
    {
        new Rook(Black, board, A8);
        new Knight(Black, board, B8);
        new Bishop(Black, board, C8);

        new Queen(Black, board, D8);
        new King(Black, board, E8);

        new Bishop(Black, board, F8);
        new Knight(Black, board, G8);
        new Rook(Black, board, H8);

        initializePawns(Black, 6);
    }

    private void initializePawns(PieceColor color, int y) {
        List<Position> row = Position.getRowAt(y);
        row.forEach(position -> new Pawn(color, board, position));
    }


}
