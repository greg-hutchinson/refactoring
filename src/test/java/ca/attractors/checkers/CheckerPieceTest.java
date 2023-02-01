package ca.attractors.checkers;

import ca.attractors.chess.ChessBoardBuilder;
import ca.attractors.chesscheckers.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.attractors.chesscheckers.PieceColor.Black;
import static ca.attractors.chesscheckers.PieceColor.White;
import static ca.attractors.chesscheckers.Position.*;
import static org.junit.jupiter.api.Assertions.*;


// What's wrong with this test?
public class CheckerPieceTest {
    private Board board;
    private CheckerPiece checkerPiece;

    @BeforeEach
    void initialize() {
        board = new Board();
        checkerPiece = new CheckerPiece(White, board, A1);
    }

    @Test
    void canMove() {
        assertTrue(checkerPiece.canMoveTo(B2));
        assertFalse(checkerPiece.canMoveTo(C3));
        CheckerPiece opponent = new CheckerPiece(Black, board, B2);
        assertTrue(checkerPiece.canMoveTo(C3));
    }

}
