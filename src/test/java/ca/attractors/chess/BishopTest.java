package ca.attractors.chess;


import ca.attractors.chesscheckers.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.attractors.chesscheckers.PieceColor.Black;
import static ca.attractors.chesscheckers.PieceColor.White;
import static ca.attractors.chesscheckers.Position.*;
import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {
    private Board chessboard;
    private Bishop bishop;

    @BeforeEach
    void initialize() {
        chessboard = new Board();
        bishop  = new Bishop(White, chessboard, D4 );
    }

    @Test
    void moveToNonDiagonalSpot() {
        assertFalse(bishop.moveTo(B1));
    }
    @Test
    void moveToOccupiedCellOfSameColor() {
        Bishop bishop2 = new Bishop(White, chessboard, E5);
        assertFalse(bishop.moveTo(E5));
    }

    @Test
    void moveToOccupiedCellOfDifferentColor() {
        Bishop bishop2 = new Bishop(Black, chessboard,E5);
        assertTrue(bishop.moveTo(E5));
        assertSame(bishop.getPosition(), E5);
        assertNull (chessboard.getPieceAt(D4));
    }

    @Test
    void moveDiagonallyInAllDirectionsWithUnoccupiedCells() {
        assertTrue(bishop.moveTo(A1));
        assertTrue(bishop.moveTo(D4));
        assertTrue(bishop.moveTo(A7));
        assertTrue(bishop.moveTo(D4));
    }

    @Test
    void moveDiagonallyToCellWithOccupiedCellsInBetween() {
        Bishop bishop2 = new Bishop(Black, chessboard, E5 );
        assertFalse(bishop.moveTo(F6));
    }

}
